package app.message;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContextComponentScanMain {
   public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("app/message/contextComponentScan.xml");
      MessageRenderer renderer = context.getBean("simpleMessageRenderer", MessageRenderer.class);
      renderer.render();
   }
}
