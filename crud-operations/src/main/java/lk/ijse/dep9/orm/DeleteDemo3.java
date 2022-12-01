package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Customer;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeleteDemo3 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        Customer cusC001 = session.get(Customer.class, "C001");
        session.remove(cusC001);
        System.out.println("Is cusC001 inside the context? " + session.contains(cusC001));  // false
        Customer cusC001Cloned = new Customer("C001", "Ruwan", "Galle", "011-1234567");
        session.remove(cusC001Cloned);

        session.getTransaction().commit();

        session.close();
        sf.close();
    }
}
