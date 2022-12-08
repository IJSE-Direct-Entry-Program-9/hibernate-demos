package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Customer;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.jpa.spi.NativeQueryTupleTransformer;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.transform.AliasToBeanResultTransformer;

import java.util.List;

public class QueryDemo4 {

    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String namedNativeQueryName = "findAllCustomers";
//            Query query = session.createNamedQuery(namedNativeQueryName);
//            List<Object[]> list = query.list();
//            list.forEach(row -> {
//                System.out.printf("%s, %s\n", row[0], row[1]);
//            });

            Query<Customer> query = session.createNamedQuery(namedNativeQueryName, Customer.class);
            List<Customer> customerList = query.list();
            customerList.forEach(System.out::println);
        }
    }
}
