package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Contact;
import lk.ijse.dep9.orm.entity.Customer;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;

public class QueryDemo12 {

    public static void main(String[] args) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

           session.createNamedQuery("getContacts", Contact.class)
                   .setParameter(1, "C001").stream().forEach(System.out::println);

           session.createNativeQuery
                   ("SELECT Con.* FROM Contact Con INNER JOIN Customer C ON Con.customer_id = C.id WHERE C.id=?")
                   .setParameter(1, "C001").stream().forEach(System.out::println);

            System.out.println("------------------------");

//           String jpql =
//   "SELECT Con FROM Contact Con INNER JOIN Customer C ON Con.pk.customer.id = C.id WHERE C.id=?1";

//            String jpql =
//"SELECT Con FROM Contact Con INNER JOIN Customer C ON Con.pk.customer = C WHERE C.id=?1";

            String jpql =
    "SELECT Con FROM Contact Con INNER JOIN Con.pk.customer C WHERE C.id=?1";
           session.createQuery(jpql, Contact.class).setParameter(1, "C001")
                   .stream().forEach(System.out::println);


        }

    }

}

