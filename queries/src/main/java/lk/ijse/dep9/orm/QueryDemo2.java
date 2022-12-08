package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Item;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class QueryDemo2 {

    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String sql = "SELECT code, description, qty, unit_price FROM Item";
            NativeQuery<Item> query = session.createNativeQuery(sql, Item.class);
            List<Item> itemList = query.list();
            itemList.forEach(System.out::println);
        }
    }
}
