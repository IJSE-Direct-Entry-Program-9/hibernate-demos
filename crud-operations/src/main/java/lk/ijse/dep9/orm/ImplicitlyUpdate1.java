package lk.ijse.dep9.orm;

import jakarta.persistence.PersistenceUnitUtil;
import jakarta.persistence.PersistenceUtil;
import lk.ijse.dep9.orm.entity.Customer;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ImplicitlyUpdate1 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        Customer c002 = session.get(Customer.class, "C002");
        c002.setFullName("Nuwan Ramindu Sampath");
        c002.setAddress("Panadura");
        c002.setContact("078-1234567");

        session.getTransaction().commit();

        session.close();
        sf.close();
    }
}
