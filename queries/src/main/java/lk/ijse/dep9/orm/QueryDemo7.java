package lk.ijse.dep9.orm;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lk.ijse.dep9.orm.entity.Customer;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class QueryDemo7 {

    public static void main(String[] args) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Customer> query1 = session.createNamedQuery("findAllCustomers2");
            query1.stream().forEach(System.out::println);

            Query<Customer> query2 = session.createNamedQuery("findAllCustomers2", Customer.class);
            query2.stream().forEach(System.out::println);

            EntityManager em = session;

            jakarta.persistence.Query query3 = em.createNamedQuery("findAllCustomers2");
            query3.getResultList().forEach(row -> {
                Customer c = (Customer) row;
                System.out.println(c);
            });

            TypedQuery<Customer> query4 = em.createNamedQuery("findAllCustomers2", Customer.class);
            query4.getResultList().forEach(System.out::println);

        }

    }
}
