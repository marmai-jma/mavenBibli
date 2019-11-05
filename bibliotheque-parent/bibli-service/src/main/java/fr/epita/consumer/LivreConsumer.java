package fr.epita.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class LivreConsumer {
    @JmsListener(destination = "livreNotification", containerFactory = "myFactory")
    public void receiveMessage(String msg) {
        System.out.println("notification recue <" + msg + ">");
    }
}
