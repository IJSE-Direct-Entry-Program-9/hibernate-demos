package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Item;
import lk.ijse.dep9.orm.entity.User;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class QueryDemo {

    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String sql = "SELECT code, description, qty, unit_price FROM Item";
//            NativeQuery query = session.createNativeQuery(sql);
//            List<Object[]> list = query.list();
//            list.forEach(row -> {
//                System.out.printf("%s, %s, %s, %s \n", row[0], row[1], row[2], row[3]);
//            });

            NativeQuery<Item> query = session.createNativeQuery(sql).addEntity(Item.class);
            List<Item> itemList = query.list();
            itemList.forEach(System.out::println);

        }
    }
}
