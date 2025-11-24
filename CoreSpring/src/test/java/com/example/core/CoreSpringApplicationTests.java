package com.example.core;

import com.example.core.lombokdemo.User;
import com.example.core.luyentap.MarketingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CoreSpringApplicationTests {
   /* @Autowired
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

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private Printer printer;
*/
    @Autowired
    private MarketingService marketingService;


/*
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

    @Test
    void TestPaymentAll(){
        paymentService.payAll();
    }
    @Test
    void TestPrinter(){
        System.out.println("Vé 1");
        printer.printCustomerTicket();
        System.out.println("Vé 2");
        printer.printCustomerTicket();
    }
*/

    @Test
    void TestMarketing(){
        marketingService.sendEmail("khachhang@gmail.com");
    }

    @Test
    void testLombok(){
        User user1 = new User();
        user1.setId(1l);
        user1.setName("Trần Đình Hữu Thọ");
        user1.setEmail("A@gmail.com");

        User user2 = new User(2L,"Hữu Thọ","b@gmail.com");

        System.out.println("User1: " + user1);
        System.out.println("User2: " + user2);
    }
}
