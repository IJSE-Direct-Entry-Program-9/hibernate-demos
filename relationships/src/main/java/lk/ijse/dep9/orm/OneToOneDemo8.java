package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Car;
import lk.ijse.dep9.orm.entity.Manager;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;

public class OneToOneDemo8 {

    public static void main(String[] args) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();

            Manager kasun = session.get(Manager.class, 1);
//            System.out.println(kasun.getCar());

            Manager ruwan = session.get(Manager.class, 2);
//            System.out.println(ruwan.getCar());

            Car bugati = session.get(Car.class, "C003");

            Car c001 = session.get(Car.class, "C001");
//            System.out.println(c001);

//            bugati.setManager(kasun);
            kasun.setCar(null);
//            bugati.setManager(null);

            session.getTransaction().commit();
        }
    }
}
