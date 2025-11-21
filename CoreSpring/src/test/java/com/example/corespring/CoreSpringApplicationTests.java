package com.example.corespring;

import com.example.corespring.demo.integration.DatabaseConnection;
import com.example.corespring.demo.service.OrderService;
import com.example.corespring.demo.service.StudentService;
import com.example.corespring.demo.component.warrior.Warrior;
import com.example.corespring.demo.component.email.NotificationClient;
import com.example.corespring.luyentap.SmartBulb;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CoreSpringApplicationTests {
    @Autowired
    private Warrior warrior;

    @Autowired
    private NotificationClient notificationClient;

    @Autowired
    private StudentService studentService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private DatabaseConnection databaseConnection;

    @Autowired
    private SmartBulb smartBulb;

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
    @Test
    void testStudent(){
        System.out.println("-------TestStudent-------");
        studentService.addStudent("    trAN          DInh huu       Tho     ");
        studentService.addStudent("Huu Tho");
        System.out.println("Danh sách sinh viên:");
        List<String> nameList = studentService.getAllStudents();
        for (String list : nameList){
            System.out.println(list);
        }
    }

    @Test
    void TestPayment(){
        System.out.println("------TestPayment------");
        orderService.datHang("Bút chì",10000);

    }
    @Test
    void TestLifecycle(){
        System.out.println("-----Bắt Đầu Test-----");
        databaseConnection.queryData();
        System.out.println("-----Kết Thúc Test-----");
    }

    @Test
    void TestSmartBulb(){
    }
}
