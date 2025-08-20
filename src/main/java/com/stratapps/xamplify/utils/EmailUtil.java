package com.stratapps.xamplify.utils;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.util.List;
import java.util.Properties;

public class EmailUtil {

    private static final String FROM_EMAIL = ConfigReader.getProperty("email.username");
    private static final String PASSWORD = ConfigReader.getProperty("email.password");

    public static void sendReportEmailWithAttachments(String to, String subject, String body, String reportPath, List<String> screenshotPaths) {
        if (FROM_EMAIL == null || FROM_EMAIL.trim().isEmpty()) {
            throw new IllegalArgumentException("❌ 'email.username' is missing in config.properties.");
        }

        if (PASSWORD == null || PASSWORD.trim().isEmpty()) {
            throw new IllegalArgumentException("❌ 'email.password' is missing in config.properties.");
        }

        if (to == null || to.trim().isEmpty()) {
            throw new IllegalArgumentException("❌ 'to' email address is missing or empty.");
        }

        if (subject == null || subject.trim().isEmpty()) {
            subject = "📧 Automation Report";
        }

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM_EMAIL, PASSWORD);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(FROM_EMAIL));
          //  message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            
            
         // Support multiple comma-separated recipients
            String[] recipientList = to.split(",");
            InternetAddress[] addresses = new InternetAddress[recipientList.length];
            for (int i = 0; i < recipientList.length; i++) {
                addresses[i] = new InternetAddress(recipientList[i].trim());
            }
            message.setRecipients(Message.RecipientType.TO, addresses);

            
            
            
            
            
            
            message.setSubject(subject);

            // Body text
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(body);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            // Attach report
            if (reportPath != null && new File(reportPath).exists()) {
                MimeBodyPart reportAttachment = new MimeBodyPart();
                reportAttachment.attachFile(new File(reportPath));
                multipart.addBodyPart(reportAttachment);
            }

            // Attach screenshots if available
            if (screenshotPaths != null && !screenshotPaths.isEmpty()) {
                for (String screenshot : screenshotPaths) {
                    if (new File(screenshot).exists()) {
                        MimeBodyPart screenshotAttachment = new MimeBodyPart();
                        screenshotAttachment.attachFile(new File(screenshot));
                        multipart.addBodyPart(screenshotAttachment);
                    }
                }
            }

            message.setContent(multipart);
            Transport.send(message);

            System.out.println("✅ Email sent successfully!");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("❌ Failed to send email: " + e.getMessage());
        }
    }
}
