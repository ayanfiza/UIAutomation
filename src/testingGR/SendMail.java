package testingGR;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	public Boolean sendMail(String body, String recept) {

		final String username = "kiran.gr1999@gmail.com";
		final String password = "KGgr2015";

		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("kiran.gr1999@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(recept));
			message.setSubject("*** This is an automatically generated email, please do not reply ***");
			message.setText("Hi there,\n\nPlease find the information you need below:\n"+body+"\n\nThanks,\n-Kiran");
			Transport.send(message);
			return true;
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}