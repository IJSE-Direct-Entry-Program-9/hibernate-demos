package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Customer;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PersistDemo {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        Customer c002 = new Customer("C002", "Kasun", "Galle", "011-1234567");
        session.persist(c002);

        session.getTransaction().commit();

        session.close();
        sf.close();
    }
}
