package lk.ijse.dep9.orm;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Tuple;
import lk.ijse.dep9.orm.dto.OrderInfoDTO;
import lk.ijse.dep9.orm.entity.User;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;

import java.util.List;

public class QueryDemo10 {

    public static void main(String[] args) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            List<User> users = session.createQuery("FROM User u", User.class).list();
            users.forEach(System.out::println);

            EntityManager em = session;
            List users2 = em.createQuery("SELECT u FROM User u").getResultList();
            users2.forEach(System.out::println);

        }

    }

}

