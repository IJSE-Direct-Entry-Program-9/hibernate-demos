package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Author;
import lk.ijse.dep9.orm.entity.Book;
import lk.ijse.dep9.orm.entity.Department;
import lk.ijse.dep9.orm.entity.Member;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;

import java.util.stream.Stream;

public class OneToManyDemo5 {

    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            Department deptHR = new Department("D001", "HR");
            Department deptSE = new Department("D002", "SE");
            Department deptOPS = new Department("D003", "OPS");

            Member kasun = new Member("M001", "Kasun", "011-1234567");
            Member nuwan = new Member("M002", "nuwan", "011-1234567");
            Member ruwan = new Member("M003", "ruwan", "011-1234567");
            Member supun = new Member("M004", "supun", "011-1234567");
            Member naween = new Member("M005", "naween", "011-1234567");

            Stream.of(deptHR, deptSE, deptOPS, kasun, nuwan, ruwan, supun, naween)
                            .forEach(session::persist);

            session.getTransaction().commit();
        }
    }
}
