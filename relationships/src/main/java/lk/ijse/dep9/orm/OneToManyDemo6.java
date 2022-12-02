package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Department;
import lk.ijse.dep9.orm.entity.Member;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;

import java.util.stream.Stream;

public class OneToManyDemo6 {

    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            Member m001 = session.get(Member.class, "M001");
            Member m002 = session.get(Member.class, "M002");
            Member m003 = session.get(Member.class, "M003");

            Department d003 = session.get(Department.class, "D003");
            Stream.of(m001, m002, m003).forEach(member -> member.setDepartment(null));

            session.getTransaction().commit();
        }
    }
}
