package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Employee;
import lk.ijse.dep9.orm.entity.Spouse;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;

public class OneToOneDemo2 {

    public static void main(String[] args) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();

//            Employee maca = session.get(Employee.class, "E001");
//            System.out.println(maca);

            Spouse sumana = session.get(Spouse.class, "S001");
            Employee maca = sumana.getEmployee();
            System.out.println("Is suaman inside the context? " + session.contains(sumana));
            System.out.println("Is maca inside the context? " + session.contains(maca));

            Employee amiya = session.get(Employee.class, "E002");
            Spouse kim = amiya.getSpouse();
            System.out.println("Is amiya inside the context? " + session.contains(amiya));
            System.out.println("Is kim inside the context? " + session.contains(kim));

//            Spouse kim2 = session.get(Spouse.class, "S002");
//            System.out.println(kim2);

            session.getTransaction().commit();
        }
    }
}
