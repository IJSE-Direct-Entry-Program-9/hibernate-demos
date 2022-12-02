package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Author;
import lk.ijse.dep9.orm.entity.Book;
import lk.ijse.dep9.orm.entity.Guradian;
import lk.ijse.dep9.orm.entity.Kid;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;

public class OneToManyDemo4 {

    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            Author maca = new Author("A002", "Maca","011-1234567");
            Book kamaSutra = new Book("456789", "Kama Sutra", Book.Status.NOT_PUBLISHED, maca);

            session.persist(maca);
            session.persist(kamaSutra);

            session.getTransaction().commit();
        }
    }
}
