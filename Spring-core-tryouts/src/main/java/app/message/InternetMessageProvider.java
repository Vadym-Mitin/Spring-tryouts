package app.message;

import org.springframework.stereotype.Component;

@Component
public class InternetMessageProvider implements MessageProvider {
   @Override
   public String getMessage() {
      return "Message from internet";
   }
}
