package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Customer;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SaveDemo {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        Customer c001 = new Customer("C001", "Ruwan+", "Galle", "011-1234567");
        session.save(c001);

        session.getTransaction().commit();

        session.close();
        sf.close();
    }
}
