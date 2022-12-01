package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Car;
import lk.ijse.dep9.orm.entity.Manager;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;

public class OneToOneDemo7 {

    public static void main(String[] args) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();

//            Car bugati = new Car("C003", "Bugati");
//            session.persist(bugati);

            Manager kasun = session.get(Manager.class, 1);
            System.out.println(kasun);

            Car bugati = session.get(Car.class, "C003");
            System.out.println(bugati);

//            bugati.setManager(kasun);
            bugati.setManager(null);

            session.getTransaction().commit();
        }
    }
}
