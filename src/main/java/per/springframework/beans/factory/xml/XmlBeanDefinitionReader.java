package per.springframework.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import per.springframework.beans.BeansException;
import per.springframework.beans.PropertyValue;
import per.springframework.beans.factory.config.BeanDefinition;
import per.springframework.beans.factory.config.BeanReference;
import per.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import per.springframework.beans.factory.support.BeanDefinitionRegistry;
import per.springframework.core.io.Resource;
import per.springframework.core.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author mangmang.xu
 * @since 2021/8/24
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {
    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try {
            try(InputStream inputStream = resource.getInputStream()) {
                doLoadBeanDefinitions(inputStream);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new BeansException("IOException parsing XML document from " + resource, e);
        }
    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }
    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }

    @Override
    public void loadBeanDefinitions(String... locations) throws BeansException {
        for (String location : locations) {
            loadBeanDefinitions(location);
        }
    }

    protected void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException {
        Document document = XmlUtil.readXML(inputStream);
        Element root = document.getDocumentElement();
        NodeList childNodes = root.getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            if(!(childNode instanceof Element)) {
                continue;
            }
            if(!"bean".equals(childNode.getNodeName())) {
                continue;
            }

            Element bean = (Element) childNode;
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");
            String initMethod = bean.getAttribute("init-method");
            String destroyMethodName = bean.getAttribute("destroy-method");
            String beanScope = bean.getAttribute("scope");

            Class<?> clazz = Class.forName(className);
            String beanName = getBeanName(id, name, clazz);

            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            beanDefinition.setInitMethodName(initMethod);
            beanDefinition.setDestroyMethodName(destroyMethodName);

            if(StrUtil.isNotEmpty(beanScope)) {
                beanDefinition.setScope(beanScope);
            }

            NodeList beanChildNodes = bean.getChildNodes();
            for (int j = 0; j < beanChildNodes.getLength(); j++) {
                Node beanChildNode = beanChildNodes.item(j);
                if (!(beanChildNode instanceof Element)) {
                    continue;
                }
                if (!"property".equals(beanChildNode.getNodeName())) {
                    continue;
                }

                Element property = (Element) beanChildNode;
                String attrName = property.getAttribute("name");
                String attrValue = property.getAttribute("value");
                String attrRef = property.getAttribute("ref");

                // 获取属性值：引入对象、值对象
                Object value = StrUtil.isNotEmpty(attrRef) ? new BeanReference(attrRef) : attrValue;
                // 创建属性信息
                PropertyValue propertyValue = new PropertyValue(attrName, value);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }
            if (getRegistry().containsBeanDefinition(beanName)) {
                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
            }
            getRegistry().registerBeanDefinition(beanName, beanDefinition);
        }
    }

    private String getBeanName(String id, String name, Class<?> clazz) {
        if(StrUtil.isNotBlank(id)) {
            return id;
        }
        if(StrUtil.isNotBlank(name)) {
            return name;
        }
        String beanName = StrUtil.lowerFirst(clazz.getSimpleName());
        if(StrUtil.isNotBlank(beanName)) {
            return beanName;
        }
        throw new BeansException("beanName must not be blank from resource");
    }
}
