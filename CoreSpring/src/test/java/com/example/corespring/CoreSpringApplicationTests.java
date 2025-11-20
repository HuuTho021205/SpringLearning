package com.example.corespring;

import com.example.corespring.Demo.Warrior.Warrior;
import com.example.corespring.Demo.sendNotification.NotificationClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CoreSpringApplicationTests {
    @Autowired
    private Warrior warrior;

    @Autowired
    private NotificationClient notificationClient;

    @Test
    void testGame() {
        System.out.println("------TestGame-------");
        warrior.fight();
    }
    @Test
    void testEmail(){
        System.out.println("------TestEmail-------");
        notificationClient.sendNotification("Xin Chào ! Đây là dòng code Spring đầu tiên của tôi");
    }

}
