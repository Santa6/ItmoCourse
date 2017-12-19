package org.example.backend;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class Mail {
    public void SendEmailToWithId(String adress, Long id){
        String from = "dragonpark@bk.ru";
        String host = "smtp.mail.ru";
        int port = 465;

        Properties props = new Properties();

        // При использовании статического метода Transport.send()
        // необходимо указать через какой хост будет передано сообщение
        props.put("mail.smtp.host", host);
        // Если почтовый сервер использует SSL
        props.put("mail.smtp.ssl.enable", "true");
        // Указываем порт SMTP сервера.
        props.put("mail.smtp.port", port);
        // Большинство SMTP серверов, используют авторизацию.
        props.put("mail.smtp.auth", "true");
        // Включение debug-режима
        props.put("mail.debug", "true");
        // Авторизируемся.
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            // Указываем логин пароль, от почты, с которой будем отправлять сообщение.
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("", "");
            }
        });

        try {
            // Создание объекта сообщения
            Message msg = new MimeMessage(session);

            // Установка атрибутов сообщения
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(adress)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject("Your order at Dragon Park");
            msg.setSentDate(new Date());

            // Установка тела сообщения
            msg.setText("To manage your order use this ID:" + id.toString());

            // Отправка сообщения
            Transport.send(msg);
        }
        catch (MessagingException mex) {
            // Печать информации об исключении в случае его возникновения
            mex.printStackTrace();
        }
    }
}
