package fleet.model;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
    public static void send(String emailTo, String emailCc, String emailSubject, String emailBody) {
        final String username = "kiprotich.chemweno@fao.org";
        final String password = "Universitas91!";
        //final String username = "faofleetbooking@gmail.com";
        //final String username = "almondsata@gmail.com";
       // final String password = "universitas21";         
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
       // props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.host", "smtp.office365.com");
        props.put("mail.smtp.port", "587");
        //props.put("mail.smtp.port", "465");
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            //message.setFrom(new InternetAddress("so-logistics@fao.org"));
            //message.setFrom(new InternetAddress("faofleetbooking@gmail.com"));
            message.setFrom(new InternetAddress("kiprotich.chemweno@fao.org"));
            //message.setFrom(new InternetAddress("almondsata@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
            //message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("almondsata@gmail.com"));
            //message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("faofleetbooking@gmail.com"));
            if (emailCc.isEmpty()) {
              message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(emailCc));
            }
            message.setSubject(emailSubject);
           //emailBody = String.format(emailBody, "\r\n");            
            emailBody = emailBody.replaceAll("#END#", "\r\n");
            message.setText(emailBody);
            Transport.send(message);
            System.out.println("Done");
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}