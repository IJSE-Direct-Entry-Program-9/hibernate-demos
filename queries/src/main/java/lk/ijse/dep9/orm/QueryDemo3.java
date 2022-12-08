package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Item;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

public class QueryDemo3 {

    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            NativeQuery<Item> query = session.createNativeQuery("SELECT * FROM Item")
                    .addEntity(Item.class);
            query.stream().forEach(System.out::println);
        }
    }
}
