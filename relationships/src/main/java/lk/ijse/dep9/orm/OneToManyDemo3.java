package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Guradian;
import lk.ijse.dep9.orm.entity.Kid;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;

import java.util.stream.Stream;

public class OneToManyDemo3 {

    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            Kid nimal = session.get(Kid.class, "K001");
            System.out.println(nimal);

            Guradian nuwan = session.get(Guradian.class, "G002");
            System.out.println(nuwan);

            nuwan.getKidSet().add(nimal);

            session.getTransaction().commit();
        }
    }
}
