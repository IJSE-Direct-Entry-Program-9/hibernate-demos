package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Customer;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RemoveDemo {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        Customer c002 = session.find(Customer.class, "C002");
        session.remove(c002);

        session.getTransaction().commit();

        session.close();
        sf.close();
    }
}
