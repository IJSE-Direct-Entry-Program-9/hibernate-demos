package lk.ijse.dep9.orm;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

public class QueryDemo1 {

    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            NativeQuery<Tuple> query1 = session.createNativeQuery("SELECT * FROM Item", Tuple.class);
            query1.stream().forEach(tuple -> {
                System.out.printf("%s, %s, %s, %s \n",
                        tuple.get("code"),
                        tuple.get("description"),
                        tuple.get("qty"),
                        tuple.get("unit_price"));
            });

            System.out.println("-----------------------------");

            EntityManager em = session;
            Query query2 = em.createNativeQuery("SELECT * FROM Item", Tuple.class);
            query2.getResultStream().forEach(record -> {
                Tuple tuple = (Tuple) record;
                System.out.printf("%s, %s, %s, %s \n",
                        tuple.get("code"),
                        tuple.get("description"),
                        tuple.get("qty"),
                        tuple.get("unit_price"));
            });
        }
    }
}
