package mylab.notification.di.annot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mylab.notification.di.annot.*;

@Configuration
public class NotificationConfig {

    // 1. EmailNotificationService 빈 등록 (Gmail 설정)
    @Bean
    public NotificationService emailNotificationService() {
        return new EmailNotificationService("smtp.gmail.com", 587);
    }

    // 2. SmsNotificationService 빈 등록 (SKT 설정)
    @Bean
    public NotificationService smsNotificationService() {
        return new SmsNotificationService("SKT");
    }

    // 3. NotificationManager 빈 등록 (위의 두 서비스를 주입)
    @Bean
    public NotificationManager notificationManager() {
        return new NotificationManager(emailNotificationService(), smsNotificationService());
    }
}