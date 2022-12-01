package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Employee;
import lk.ijse.dep9.orm.entity.Spouse;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;

public class OneToOneDemo3 {

    public static void main(String[] args) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();

//            Employee dinuka = new Employee("E003", "Dinuka", "Panadura", "038-1234567");
//            session.persist(dinuka);

            Spouse sumana = session.get(Spouse.class, "S001");
            System.out.println(sumana.getEmployee());

            Employee dinuka = session.get(Employee.class, "E003");
            sumana.setEmployee(dinuka);

            session.getTransaction().commit();
        }
    }
}
