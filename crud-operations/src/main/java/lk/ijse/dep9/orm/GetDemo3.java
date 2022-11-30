package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Customer;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GetDemo3 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        Customer customer = session.get(Customer.class, "C001");
        System.out.println("Is customer inside the context? " + session.contains(customer));
        System.out.println(customer);   // C001, Ruwan+, Galle
        Customer customer1 = session.get(Customer.class, "C001");
        Customer customer2 = session.get(Customer.class, "C001");
        System.out.println("Is customer1 inside the context? " + session.contains(customer1));
        System.out.println("Is customer2 inside the context? " + session.contains(customer2));
        session.evict(customer2);
        System.out.println("----after evicting-----");
        System.out.println("Is customer inside the context? " + session.contains(customer));
        System.out.println("Is customer1 inside the context? " + session.contains(customer1));

        session.getTransaction().commit();

        session.close();
        sf.close();
    }
}
