import com.sun.mail.smtp.SMTPMessage;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
public static void main(String[] args) {
Properties props = new Properties();
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class",
            "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "805");

    Session session = Session.getDefaultInstance(props,new         javax.mail.Authenticator()
                            {
                                 @Override
                                protected PasswordAuthentication     getPasswordAuthentication()
                                {
                return new PasswordAuthentication("scrumprojekt1@gmail.com","test4321");
                                }
        });

    try {

        SMTPMessage message = new SMTPMessage(session);
        message.setFrom(new InternetAddress("scrumprojekt1@gmail.com"));
        message.setRecipients(Message.RecipientType.TO,
                            
                                 InternetAddress.parse( "johanna.jedenius@hotmail.com"));

                    message.setSubject("Testing Subject");
        message.setText("Vi skickar ett mail från vårt projekt! Kramar Team 1");
                   

                    message.setNotifyOptions(SMTPMessage.NOTIFY_SUCCESS);
                    int returnOption = message.getReturnOption();

                     System.out.println(returnOption);        
                Transport.send(message);
                System.out.println("sent");

    }
            catch (MessagingException e)
            {
        throw new RuntimeException(e);

    }
}
}