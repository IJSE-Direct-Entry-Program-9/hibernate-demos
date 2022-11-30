package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Customer;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ContextDemo {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        Customer c001 = session.get(Customer.class, "C001");
        System.out.println(c001);
        System.out.println(session.contains(c001));

        Customer c001Cloned = new Customer("C001", "Kasun", "Galle", "011-1234567");
        System.out.println(c001.equals(c001Cloned));
        System.out.println(session.contains(c001Cloned));
        System.out.println("Dirty: " + session.isDirty());
        c001.setFullName("Ruwan+");
        System.out.println("Dirty: " + session.isDirty());
        System.out.println("------");

        session.getTransaction().commit();

        session.close();
        sf.close();
    }
}
