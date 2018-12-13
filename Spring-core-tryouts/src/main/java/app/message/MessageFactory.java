package app.message;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class MessageFactory {
   private static MessageProvider messageProvider;
   private static MessageRenderer messageRenderer;

   static {
      Properties prop = new Properties();

      try (InputStream in = MessageFactory.class.getClassLoader().getResourceAsStream("app/message/app.properties")) {
         prop.load(in);
         String messageProviderClass = prop.getProperty("provider.class");
         String messageRendererClass = prop.getProperty("renderer.class");
         messageProvider = (MessageProvider) Class.forName(messageProviderClass).newInstance();
         messageRenderer = (MessageRenderer) Class.forName(messageRendererClass).getConstructor(MessageProvider.class).newInstance(messageProvider);
      } catch (IOException | IllegalAccessException | InstantiationException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {
         e.printStackTrace();
      }
   }

   public static MessageProvider getMessageProvider() {
      return messageProvider;
   }

   public static MessageRenderer getMessageRenderer() {
      return messageRenderer;
   }
}
