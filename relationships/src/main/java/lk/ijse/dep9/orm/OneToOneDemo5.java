package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Employee;
import lk.ijse.dep9.orm.entity.Spouse;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;

public class OneToOneDemo5 {

    public static void main(String[] args) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();

//            Employee rupe = new Employee("E004", "Rupe", "Trinco", "011-1234567");
//            Spouse ruwani = new Spouse("S003", "Ruwani", "011-1234778", rupe);
//
//            session.persist(rupe);
//            session.persist(ruwani);

            session.getTransaction().commit();
        }
    }
}
