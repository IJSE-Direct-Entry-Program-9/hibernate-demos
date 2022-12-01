package lk.ijse.dep9.orm;

import lk.ijse.dep9.orm.entity.Car;
import lk.ijse.dep9.orm.entity.Manager;
import lk.ijse.dep9.orm.util.HibernateUtil;
import org.hibernate.Session;

public class OneToOneDemo6 {

    public static void main(String[] args) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();

            Manager kasun = new Manager("Kasun", "011-1234567");
            Manager ruwan = new Manager("Ruwan", "011-4567891");
            Manager nuwan = new Manager("Nuwan", "011-7894561");

            Car lambo = new Car("C001", "Lambo");
            Car ferari = new Car("C002", "Ferari");

            lambo.setManager(ruwan);
            ferari.setManager(nuwan);

            session.persist(kasun);
            session.persist(ruwan);
            session.persist(nuwan);
            session.persist(lambo);
            session.persist(ferari);

            session.getTransaction().commit();
        }
    }
}
