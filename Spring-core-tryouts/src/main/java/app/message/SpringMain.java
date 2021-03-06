package app.message;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
   public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("app/message/context.xml");
      MessageRenderer renderer = context.getBean("renderer", MessageRenderer.class);
      MessageProvider provider = context.getBean("provider", MessageProvider.class);
      renderer.setMessageProvider(provider);
      renderer.render();
   }
}
