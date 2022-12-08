package lk.ijse.dep9.orm;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;

public class QueryDemo6 {

    public static void main(String[] args) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            EntityManager em = session;
            Query query1 = em.createNamedQuery("findAllCustomers");
            query1.getResultStream().forEach(record -> {
                Object[] row = (Object[]) record;
                System.out.printf("%s, %s \n", row[0], row[1]);
            });
        }

//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            NativeQuery query2 = session.getNamedNativeQuery("findAllCustomers")
//                    .addEntity(Customer.class);
//            query2.list().forEach(System.out::println);
//        }

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            EntityManager em = session;
            Query query2 = session.createNamedQuery("findAllCustomers2");
            query2.getResultStream().forEach(System.out::println);
        }
    }
}
