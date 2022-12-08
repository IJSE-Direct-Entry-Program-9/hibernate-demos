package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Customer;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

public class QueryDemo5 {

    public static void main(String[] args) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Object[]> query1 = session.createNamedQuery("findAllCustomers");
            query1.stream().forEach(row -> {
                System.out.printf("%s, %s \n", row[0], row[1]);
            });
        }

//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            NativeQuery query2 = session.getNamedNativeQuery("findAllCustomers")
//                    .addEntity(Customer.class);
//            query2.list().forEach(System.out::println);
//        }

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Customer> query2 = session.createNamedQuery("findAllCustomers2");
            query2.list().forEach(System.out::println);
        }
    }
}
