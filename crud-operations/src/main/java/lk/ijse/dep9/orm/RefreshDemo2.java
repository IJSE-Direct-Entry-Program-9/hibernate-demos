package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Customer;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RefreshDemo2 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        Customer customer = session.get(Customer.class, "C001");
        session.evict(customer);
        System.out.println(customer);
        customer.setAddress("Ampara");
        customer.setContact("+99111-123456771");
        System.out.println(customer);
        System.out.println("Is customer inside the context? " + session.contains(customer));
        session.refresh(customer);
        System.out.println("Is customer inside the context? " + session.contains(customer));
        System.out.println(customer);

        session.getTransaction().commit();

        session.close();
        sf.close();
    }
}
