package lk.ijse.dep9.orm;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

public class QueryDemo {

    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            NativeQuery<Object[]> query1 = session.createNativeQuery("SELECT * FROM Item");
            query1.stream().forEach(row -> {
                //Object[] row = (Object[]) record;
                System.out.printf("%s, %s, %s, %s \n", row[0], row[1], row[2], row[3]);
            });

            System.out.println("-----------------------------");

            EntityManager em = session;
            Query query2 = em.createNativeQuery("SELECT * FROM Item");
            query2.getResultStream().forEach(record -> {
                Object[] row = (Object[]) record;
                System.out.printf("%s, %s, %s, %s \n", row[0], row[1], row[2], row[3]);
            });
        }
    }
}
