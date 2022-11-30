package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Customer;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MergeDemo3 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        Customer customer = new Customer("C003", "Chathura", "Homagama", "123-1234567");
        Customer clonedCustomer = session.merge(customer);
        System.out.println("Is customer inside the context? " + session.contains(customer));
        System.out.println("Is clonedCustomer inside the context? " + session.contains(clonedCustomer));

        session.getTransaction().commit();

        session.close();
        sf.close();
    }
}
