package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Customer;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MergeDemo2 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        Customer customer = session.get(Customer.class, "C001");
        System.out.println("Is customer inside the context? " + session.contains(customer));
        System.out.println(customer);   // C001, Ruwan+, Galle
        session.evict(customer);
        customer.setAddress("Colombo");
        Customer c001Customer = session.get(Customer.class, "C001");
        Customer clonedCustomer = session.merge(customer);
        System.out.println("Is customer inside the context? " + session.contains(customer));
        System.out.println("Is clonedCustomer inside the context? " + session.contains(clonedCustomer));
        System.out.println("Is c001 inside the context? " + session.contains(c001Customer));
        System.out.println("Is clonedCustomer == c001Customer? " + (c001Customer == clonedCustomer));

        customer.setAddress("Matara");
        customer.setFullName("Nipun");

        session.getTransaction().commit();

        session.close();
        sf.close();
    }
}
