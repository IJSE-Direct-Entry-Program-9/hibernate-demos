package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Customer;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RefreshDemo {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        Customer customerC001 = session.get(Customer.class, "C001");
        System.out.println(customerC001);
        customerC001.setAddress("Moratuwa");
        customerC001.setContact("099-1234567");
        System.out.println(customerC001);
        System.out.println("Is session dirty: " + session.isDirty());
        session.refresh(customerC001);
        System.out.println(customerC001);
        System.out.println("Is session dirty: " + session.isDirty());

        session.getTransaction().commit();

        session.close();
        sf.close();
    }
}
