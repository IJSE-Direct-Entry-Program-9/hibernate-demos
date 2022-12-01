package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Customer;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeleteDemo2 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        Customer cusC001 = new Customer("C001", "Kasun", "Galle", "011-1234675");
        session.remove(cusC001);
        System.out.println("Is cusC001 inside the context?: " + session.contains(cusC001));
        Customer cusC001Cloned = session.get(Customer.class, "C001");
        System.out.println(cusC001Cloned);
        System.out.println(cusC001Cloned == cusC001);

        session.getTransaction().commit();

        session.close();
        sf.close();
    }
}
