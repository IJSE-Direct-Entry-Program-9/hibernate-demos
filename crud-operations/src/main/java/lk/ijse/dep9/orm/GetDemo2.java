package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Customer;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GetDemo2 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        Customer c001 = session.get(Customer.class, "C001");
        System.out.println(c001);

        System.out.println("------");

        Customer c002 = session.get(Customer.class, "C002");
        System.out.println(c002);

        System.out.println("------");

        Customer c001Cloned = session.get(Customer.class, "C001");
        System.out.println(c001Cloned);

        System.out.println("------");

        Customer c002Cloned = session.get(Customer.class, "C002");
        System.out.println(c002Cloned);

        session.close();
        sf.close();
    }
}
