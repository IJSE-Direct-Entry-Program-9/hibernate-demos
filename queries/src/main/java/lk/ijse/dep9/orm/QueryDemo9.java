package lk.ijse.dep9.orm;

import jakarta.persistence.Tuple;
import lk.ijse.dep9.orm.dto.OrderInfoDTO;
import lk.ijse.dep9.orm.util.HibernateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;

import java.io.Serializable;
import java.util.List;

public class QueryDemo9 {

    public static void main(String[] args) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String sql =
        "SELECT c.id, c.name , co.order_id as orderId FROM Customer c INNER JOIN CustomerOrder co on c.id = co.customer_id";
            NativeQuery<Object[]> query = session.createNativeQuery(sql);
            query.stream().forEach(record -> {
                System.out.printf("%s, %s, %s \n", record[0], record[1], record[2]);
            });

            NativeQuery<Tuple> query2 = session.createNativeQuery(sql, Tuple.class);
            query2.stream().forEach(tuple -> {
                System.out.printf("%s, %s, %s \n",
                        tuple.get(0),
                        tuple.get("name"),
                        tuple.get(2));
            });

            /* ProjectionDTO (Native Hibernate API) */
            List<OrderInfoDTO> orderInfoDTOList = session.createNativeQuery(sql)
                    .setResultTransformer(Transformers.aliasToBean(OrderInfoDTO.class)).list();
            orderInfoDTOList.forEach(System.out::println);

        }

    }

}

