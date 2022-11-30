package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Customer;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class LoadDemo {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        Customer c001 = session.load(Customer.class, "C001");
        System.out.println(c001);

        session.getTransaction().commit();

        session.close();
        sf.close();
    }
}
