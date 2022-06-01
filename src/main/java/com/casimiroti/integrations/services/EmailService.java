package com.casimiroti.integrations.services;

import com.casimiroti.integrations.dto.EmailDTO;
import com.casimiroti.integrations.exceptions.EmailException;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailService {

    private static Logger log = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private SendGrid sendGrid;

    public void sendEmail(EmailDTO emailDTO) throws EmailException {
        Email from = new Email( emailDTO.getFromEmail(), emailDTO.getFromName());
        Email to = new Email(emailDTO.getTo());
        Content content = new Content(emailDTO.getContentType(), emailDTO.getBody());
        Mail mail = new Mail(from, emailDTO.getSubject(), to, content);

        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            log.info("Sending email to: " + emailDTO.getTo());
            Response response = sendGrid.api(request);
            if (response.getStatusCode() >= 400 && response.getStatusCode() <= 500) {
                log.error("ERROR sending email: "+ response.getBody());
                throw new EmailException(response.getBody());
            }
            log.info("Email sent! Status: "+ response.getStatusCode());

        } catch (IOException e) {
            throw new EmailException(e.getMessage());
        }
    }
}
