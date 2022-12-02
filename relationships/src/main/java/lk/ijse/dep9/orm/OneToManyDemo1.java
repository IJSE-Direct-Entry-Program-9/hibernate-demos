package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Customer;
import lk.ijse.dep9.orm.entity.Order;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.stream.Stream;

public class OneToManyDemo1 {

    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            Order od001 = session.get(Order.class, "OD001");
            System.out.println(od001);
            Customer kasun = od001.getCustomer();
            System.out.println("Is kasun inside the context? " +  session.contains(kasun));
            System.out.println("Is OD001 inside the context? " +  session.contains(od001));

            Customer nuwan = session.get(Customer.class, "C002");
            nuwan.getOrderSet().forEach(System.out::println);

            // nuwan.getOrderSet().add(od001);
            nuwan.addOrder(od001);

            session.getTransaction().commit();
        }
    }
}
