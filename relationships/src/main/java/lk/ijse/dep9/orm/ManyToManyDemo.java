package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Actor;
import lk.ijse.dep9.orm.entity.Author;
import lk.ijse.dep9.orm.entity.Book;
import lk.ijse.dep9.orm.entity.Movie;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.Date;
import java.time.LocalDate;
import java.util.stream.Stream;

public class ManyToManyDemo {

    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            Actor chathura = new Actor("A001", "Chathura");
            Actor maca = new Actor("A002", "Maca");
            Actor amiya = new Actor("A003", "Amiya");
            Actor kim = new Actor("A004", "Kim");

            Movie threeIditos = new Movie("M001", "3-Iditos", Date.valueOf(LocalDate.now()));
            Movie m002 = new Movie("M002", "Live Free or Die Hard", Date.valueOf(LocalDate.now()));

            Stream.of(chathura, maca, amiya, kim, threeIditos, m002).forEach(session::persist);

//            threeIditos.getActorSet().add(chathura);
//            threeIditos.getActorSet().add(maca);
//            threeIditos.getActorSet().add(amiya);
//
//            m002.getActorSet().add(kim);
//            m002.getActorSet().add(maca);
//            m002.getActorSet().add(chathura);

            session.getTransaction().commit();
        }
    }
}
