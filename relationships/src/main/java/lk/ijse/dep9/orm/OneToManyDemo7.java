package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;

public class OneToManyDemo7 {

    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            session.getTransaction().commit();
        }
    }
}
