package io.turntable.projectwebservice.email;

import org.springframework.mail.SimpleMailMessage;

public class EmaillService {

    public void sendEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText("john.erbynn@turntabl.io");

        message.setSubject("Message from Java");
        message.setText("Welcome Erbynn \n Enjoy your day");

//        javaMailSender.
    }
}
