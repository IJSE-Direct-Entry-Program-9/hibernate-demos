package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Customer;
import lk.ijse.dep9.orm.entity.Student;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SaveDemo3 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        Student prem = new Student( "Prem", "011-1234567");
        session.persist(prem);
        System.out.println(prem.getId());
        session.delete(prem);
        System.out.println(session.save(prem));

        System.out.println("Just before committing");
        session.getTransaction().commit();

        session.close();
        sf.close();
    }
}
