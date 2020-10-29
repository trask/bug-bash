package bugbash;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener(destination = "message", containerFactory = "factory")
    public void message(String message) {
        System.out.println("Received: " + message);
    }
}
