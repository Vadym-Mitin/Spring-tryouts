package todo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Vadym Mitin
 */
public class Launcher {
    public void launch() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("app-context.xml");
    }
}
