package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Customer;
import lk.ijse.dep9.orm.entity.Guradian;
import lk.ijse.dep9.orm.entity.Kid;
import lk.ijse.dep9.orm.entity.Order;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;

import java.util.stream.Stream;

public class OneToManyDemo2 {

    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            Guradian kasun = new Guradian("G001", "Kasun", "077-1234567");
            Guradian nuwan = new Guradian("G002", "Nuwan", "071-1234567");

            Kid nimal = new Kid("K001", "Nimal", kasun);
            Kid sunil = new Kid("K002", "Sunil", kasun);

            Stream.of(kasun, nuwan, nimal, sunil).forEach(session::persist);

            session.getTransaction().commit();
        }
    }
}
