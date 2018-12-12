package app.message;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringJavaConfigMain {
   public static void main(String[] args) {
      ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
      MessageRenderer renderer = context.getBean("renderer", MessageRenderer.class);
      MessageProvider provider = context.getBean("provider", MessageProvider.class);
      renderer.setMessageProvider(provider);
      renderer.render();
   }
}
