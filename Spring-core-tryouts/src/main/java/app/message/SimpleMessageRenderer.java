package app.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleMessageRenderer implements MessageRenderer {

    @Autowired
    private MessageProvider provider;


//    public SimpleMessageRenderer(MessageProvider provider) {
//        this.provider = provider;
//    }

    @Override
    public void render() {
        System.out.println(provider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider provider) {
        this.provider = provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return provider;
    }
}
