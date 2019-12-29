package restaurant.service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailService {

    private static final String USERNAME = "restaurant.is.email@gmail.com";
    private static final String PASSWORD = "Password123.";
    private static Properties properties = new Properties();

    public static void sendEmail(String to, String subject, String content){
        System.out.println("Starting to send email.");

        try{
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");

            Session session = Session.getInstance(properties, createAuth());
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EmailService.USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(content);
            Transport.send(message);

            System.out.println("Mail sent to " + to);
        } catch (MessagingException e){
            System.out.println("Could not send email to " + to);
            e.printStackTrace();
        }
    }

    private static Authenticator createAuth() {
        return  new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(EmailService.USERNAME, EmailService.PASSWORD);
            }
        };
    }
}
