package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.*;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.stream.Stream;

public class DataDemo {

    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Item mouse = new Item("I001", "Mouse", 10, new BigDecimal(750));
            Item keyboard = new Item("I002", "Keyboard", 13, new BigDecimal(950));
            Item laptopScreen = new Item("I003", "Laptop Screen", 8, new BigDecimal(18500));

            User nalin = new User("nailn", "nailn123", "Nalin");
            User kushan = new User("kushan", "kushan123", "Kushan");

            byte[] nalinPicBytes = DataDemo.class.getResourceAsStream("/nalin.jpeg").readAllBytes();
            Picture nalinProfilePicture = new Picture(nalin, nalinPicBytes );

            Customer prem = new Customer("C001", "Prem");
            Customer visal = new Customer("C002", "Visal");
            Customer madhushanka = new Customer("C003", "Madhushanka");

            Contact premContact1 = new Contact(prem, "077-1234567");
            Contact premContact2 = new Contact(prem, "078-1234567");
            Contact visalContact = new Contact(visal, "011-1234567");
            Contact madhushankaContact = new Contact(madhushanka, "033-1234567");

            Order od001 = new Order("OD001", Date.valueOf(LocalDate.now()), nalin);
            od001.setCustomer(prem);

            Order od002 = new Order("OD002", Date.valueOf(LocalDate.now()), nalin);
            Order od003 = new Order("OD003", Date.valueOf(LocalDate.now()), kushan);
            od003.setCustomer(visal);
            Order od004 = new Order("OD004", Date.valueOf(LocalDate.now()), kushan);
            od003.setCustomer(visal);
            Order od005 = new Order("OD005", Date.valueOf(LocalDate.now()), nalin);
            od003.setCustomer(visal);

            OrderDetail od1 = new OrderDetail(od001, mouse, 1, mouse.getUnitPrice());
            OrderDetail od2 = new OrderDetail(od001, keyboard, 1, keyboard.getUnitPrice());

            OrderDetail od3 = new OrderDetail(od002, keyboard, 2, keyboard.getUnitPrice());

            OrderDetail od4 = new OrderDetail(od003, laptopScreen, 1, laptopScreen.getUnitPrice());
            OrderDetail od5 = new OrderDetail(od003, mouse, 1, mouse.getUnitPrice());

            OrderDetail od6 = new OrderDetail(od004, laptopScreen, 1, laptopScreen.getUnitPrice());
            OrderDetail od7 = new OrderDetail(od005, mouse, 1, mouse.getUnitPrice());
            OrderDetail od8 = new OrderDetail(od005, keyboard, 1, keyboard.getUnitPrice());
            OrderDetail od9 = new OrderDetail(od005, laptopScreen, 1, laptopScreen.getUnitPrice());

            Stream.of(mouse, keyboard, laptopScreen, nalin, kushan, nalinProfilePicture, prem, visal, madhushanka,
                    premContact1, premContact2, visalContact, madhushankaContact, od001, od002, od003,od004, od005,
                    od1, od2, od3, od4, od5, od6, od7, od8, od9).forEach(session::persist);

            session.getTransaction().commit();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
