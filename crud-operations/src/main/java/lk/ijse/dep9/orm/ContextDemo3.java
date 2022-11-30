package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Customer;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ContextDemo3 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        Customer customer = new Customer("C004", "II-Parkrama", "Anuradhapura", "044-1234567");
        session.persist(customer);
        System.out.println("Is customer inside the context? " + session.contains(customer));
        session.evict(customer);
        //session.clear();
        System.out.println("Is customer inside the context? " + session.contains(customer));
        Customer c002 = session.get(Customer.class, "C002");
        //c002.setAddress("Ampara");
//        Customer maca = new Customer("C005", "Maca", "Kollupitiya", "011-1234567");
//        session.save(maca);
//        Customer clonedCustomer = session.merge(customer);
//        System.out.println("Is customer inside the context? " + session.contains(customer));
//        System.out.println("Is clonedCustomer inside the context? " + session.contains(clonedCustomer));

        session.getTransaction().commit();

        session.close();
        sf.close();
    }
}
