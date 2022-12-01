package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Customer;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeleteDemo4 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        Customer cusC100 = new Customer("C001", "Tharindu", "Matara", "077-1234567");
        session.remove(cusC100);
        System.out.println(cusC100);

        session.getTransaction().commit();

        session.close();
        sf.close();
    }
}
