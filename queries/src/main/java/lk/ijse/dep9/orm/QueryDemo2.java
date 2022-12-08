package lk.ijse.dep9.orm;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;
import lk.ijse.dep9.orm.entity.Item;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

public class QueryDemo2 {

    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            NativeQuery<Item> query1 = session.createNativeQuery("SELECT * FROM Item", Item.class);
            query1.stream().forEach(System.out::println);

            System.out.println("-----------------------------");

            EntityManager em = session;
            Query query2 = em.createNativeQuery("SELECT * FROM Item", Item.class);
            query2.getResultStream().forEach(row -> {
                Item item = (Item) row;
                System.out.println(item);
            });
        }
    }
}
