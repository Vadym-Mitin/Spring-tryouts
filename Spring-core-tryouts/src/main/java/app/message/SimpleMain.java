package app.message;

public class SimpleMain {
   public static void main(String[] args) {
//      MessageProvider provider = MessageFactory.getMessageProvider();
      MessageRenderer renderer = MessageFactory.getMessageRenderer();
      renderer.render();
   }
}
