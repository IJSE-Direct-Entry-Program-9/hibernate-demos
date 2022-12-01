package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Employee;
import lk.ijse.dep9.orm.entity.Spouse;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;

public class OneToOneDemo4 {

    public static void main(String[] args) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();

            Employee maca = session.get(Employee.class, "E001");
            Spouse sumana = session.get(Spouse.class, "S001");

            System.out.println("Is maca inside the context? " + session.contains(maca));
            System.out.println("Is sumana inside the context? " + session.contains(sumana));
            maca.setSpouse(sumana);

            session.getTransaction().commit();
        }
    }
}
