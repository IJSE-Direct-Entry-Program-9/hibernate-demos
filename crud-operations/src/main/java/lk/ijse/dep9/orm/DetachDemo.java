package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Customer;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DetachDemo {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        Customer customer = session.get(Customer.class, "C001");
        System.out.println("Is c001 inside the context? " + session.contains(customer));
        System.out.println(customer);
        customer.setAddress("Colombo");
        System.out.println("Is session dirty? " + session.isDirty());
        session.detach(customer);
        System.out.println("Is c001 inside the context? " + session.contains(customer));
        System.out.println("Is session dirty? " + session.isDirty());

        session.getTransaction().commit();

        session.close();
        sf.close();
    }
}
