package org.jgnn.study.web.securejpa.utils;

import java.util.Properties;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {
	

	static Logger logger = Logger.getLogger(MailSender.class.getName());
	
	//Sender's email ID needs to be mentioned
    String senderEmail = "mvojgnn@gmail.com";
    String password = "npqrzdwiunjmdgkd";
    
    //Assuming you are sending email from through gmails smtp
    String host = "smtp.gmail.com";
    
 // Get system properties
    Properties smtpProperties = System.getProperties();
	
	public void send(String to, String subject, String body){
		
		 

        // Setup mail server
        smtpProperties.put("mail.smtp.host", host);
        smtpProperties.put("mail.smtp.port", "465");
        smtpProperties.put("mail.smtp.ssl.enable", "true");
        smtpProperties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(smtpProperties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                
				return new PasswordAuthentication(senderEmail, password);
            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(senderEmail));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            
			// Set Subject: header field
            message.setSubject(subject);
            
            // Now set the actual message
            message.setText(body);

            logger.info("Enviando...");
            // Send message
            Transport.send(message);
            System.out.println("Mensagem enviada com sucesso....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
	}

}
