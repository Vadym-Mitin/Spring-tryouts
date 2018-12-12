package app.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class JavaConfig {
   @Bean
   public MessageProvider provider() {
      return new SimpleMessageProvider();
   }

   @Bean
   public MessageRenderer renderer(@Autowired MessageProvider provider) {
      return new SimpleMessageRenderer();
   }
}
