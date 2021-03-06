package jug.spring.ripper;

import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author Vadym Mitin
 */
public class PropertyFileApplicationContext extends GenericApplicationContext {

    public PropertyFileApplicationContext(String fileName) {
        PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(this);
        int i = reader.loadBeanDefinitions(fileName);
        System.out.println("found " + i + " of beans");
        refresh();

    }

    public static void main(String[] args) {
        PropertyFileApplicationContext context = new PropertyFileApplicationContext("jug.spring.ripper/context.properties");
        context.getBean(Quoter.class).sayQuote();

    }

}
