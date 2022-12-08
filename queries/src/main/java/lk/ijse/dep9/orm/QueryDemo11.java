package lk.ijse.dep9.orm;

import jakarta.persistence.EntityManager;
import lk.ijse.dep9.orm.entity.Contact;
import lk.ijse.dep9.orm.entity.Customer;
import lk.ijse.dep9.orm.entity.User;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class QueryDemo11 {

    public static void main(String[] args) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.createNamedQuery("getAllCustomers", Customer.class).list().forEach(
                    System.out::println
            );

            Customer c = (Customer) session.getNamedQuery("getCustomerDetails")
                    .setParameter(1, "C001").uniqueResult();
            System.out.println(c);

        }

    }

}

