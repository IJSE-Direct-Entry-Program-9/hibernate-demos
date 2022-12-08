package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Customer;
import lk.ijse.dep9.orm.entity.Item;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class QueryDemo3 {

    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String namedNativeQueryName = "findAllCustomers";
//            NativeQuery query = session.getNamedNativeQuery(namedNativeQueryName);
//            List<Object[]> list = query.list();
//            list.forEach(row -> {
//                System.out.printf("%s, %s\n", row[0], row[1]);
//            });

            NativeQuery<Customer> query = session.getNamedNativeQuery(namedNativeQueryName).addEntity(Customer.class);
            List<Customer> customerList = query.list();
            customerList.forEach(System.out::println);
        }
    }
}
