package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Employee;
import lk.ijse.dep9.orm.entity.Spouse;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;

public class OneToOneDemo {

    public static void main(String[] args) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();

            Employee maca = new Employee("E001", "Maca", "Trinco", "044-1234567");
            Spouse sumana = new Spouse("S001", "Sumana", "044-78912345", maca);

            Employee amiya = new Employee("E002", "Amiya", "Panadura", "033-1234567");
            Spouse kim = new Spouse("S002", "Kim", "088-1234567", amiya);

            session.persist(maca);
            session.persist(sumana);
            session.persist(amiya);
            session.persist(kim);

            session.getTransaction().commit();
        }
    }
}
