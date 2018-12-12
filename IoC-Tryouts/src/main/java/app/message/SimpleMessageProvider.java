package app.message;

public class SimpleMessageProvider implements MessageProvider {
   @Override
   public String getMessage() {
       return "Simple message";
   }
}
