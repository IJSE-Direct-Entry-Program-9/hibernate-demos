package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Customer;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class FindVsGetReferenceDemo {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        Customer c001 = session.find(Customer.class, "C001");
        System.out.println("-----------------");
        System.out.println(c001.getId());

        Customer c002 = session.getReference(Customer.class, "C002");
        System.out.println(c002.getId());
        System.out.println("--------");
        System.out.println(c002.getFullName());

        System.out.println("-------------");
        Customer c100 = session.getReference(Customer.class, "C100");
        System.out.println(c100.getId());
        System.out.println(c100.getFullName());
        System.out.println(c100.getAddress());

        session.getTransaction().commit();

        session.close();
        sf.close();
    }
}
