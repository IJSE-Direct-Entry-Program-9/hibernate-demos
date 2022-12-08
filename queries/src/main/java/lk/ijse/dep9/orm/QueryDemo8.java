package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Customer;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;

public class QueryDemo8 {

    public static void main(String[] args) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Customer customer = session.createNamedQuery("findCustomer", Customer.class)
                    .setParameter(1, "C001").uniqueResult();
            System.out.println(customer);
        }

    }
}
