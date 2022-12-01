package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Customer;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeleteDemo5 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        Customer cusKushan = new Customer("C004", "Kushan", "Galle", "011-1234567");
        session.persist(cusKushan);
        session.remove(cusKushan);
        session.persist(cusKushan);

        System.out.println("Just before the transaction");
        session.getTransaction().commit();

        session.close();
        sf.close();
    }
}
