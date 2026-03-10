package mylab.notification.di.annot.config;

import mylab.notification.di.annot.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(NotificationConfig.class)
public class NotificationConfigTest {

    @Autowired
    private NotificationManager notificationManager;

    @Test
    @DisplayName("NotificationManager 의존성 주입 및 설정값 검증")
    void testNotificationManagerDI() {
        // a. NotificationManager 주입 여부 확인
        assertNotNull(notificationManager, "NotificationManager가 주입되지 않았습니다.");

        // b & c. 이메일 서비스 검증
        NotificationService emailService = notificationManager.getEmailService();
        assertNotNull(emailService, "EmailService가 Null입니다.");
        
        EmailNotificationService emailImpl = (EmailNotificationService) emailService;
        assertEquals("smtp.gmail.com", emailImpl.getSmtpServer());
        assertEquals(587, emailImpl.getPort());

        // d. SMS 서비스 검증
        NotificationService smsService = notificationManager.getSmsService();
        assertNotNull(smsService, "SmsService가 Null입니다.");
        
        SmsNotificationService smsImpl = (SmsNotificationService) smsService;
        assertEquals("SKT", smsImpl.getProvider());

        // e. 메서드 실행 (콘솔 출력으로 확인)
        System.out.println(">>> 테스트 시작");
        notificationManager.sendNotificationByEmail("테스트 이메일");
        notificationManager.sendNotificationBySms("테스트 SMS");
        System.out.println(">>> 테스트 완료");
    }
}