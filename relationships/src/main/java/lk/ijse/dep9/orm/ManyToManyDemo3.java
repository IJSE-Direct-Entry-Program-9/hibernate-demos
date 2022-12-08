package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Actor;
import lk.ijse.dep9.orm.entity.Movie;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.Date;
import java.time.LocalDate;
import java.util.stream.Stream;

public class ManyToManyDemo3 {

    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            session.getTransaction().commit();
        }
    }
}
