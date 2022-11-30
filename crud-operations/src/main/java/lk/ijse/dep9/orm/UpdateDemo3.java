package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Customer;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UpdateDemo3 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        Customer customer = session.get(Customer.class, "C001");
        System.out.println("Is customer inside the context? " + session.contains(customer));
        System.out.println(customer);   // C001, Ruwan+, Panadura
        session.update(customer);

        session.getTransaction().commit();

        session.close();
        sf.close();
    }
}
