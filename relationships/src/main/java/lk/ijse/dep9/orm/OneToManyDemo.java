package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Customer;
import lk.ijse.dep9.orm.entity.Order;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.Date;
import java.time.LocalDate;
import java.util.stream.Stream;

public class OneToManyDemo {

    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            Customer kasun = new Customer("C001", "Kasun", "011-1234567");
            Customer nuwan = new Customer("C002", "Nuwan", "077-1234567");
            Customer supun = new Customer("C003", "Supun", "071-1234567");

            Order od001 = new Order("OD001", Date.valueOf(LocalDate.now()), kasun);
            Order od002 = new Order("OD002", Date.valueOf(LocalDate.now()), kasun);
            Order od003 = new Order("OD003", Date.valueOf(LocalDate.now()), kasun);

            Order od004 = new Order("OD004", Date.valueOf(LocalDate.now()), nuwan);
            Order od005 = new Order("OD005", Date.valueOf(LocalDate.now()), nuwan);
            Order od006 = new Order("OD006", Date.valueOf(LocalDate.now()), nuwan);

            Stream.of(kasun, nuwan, supun, od001, od002, od003, od004, od005, od006)
                            .forEach(session::persist);

            session.getTransaction().commit();
        }
    }
}
