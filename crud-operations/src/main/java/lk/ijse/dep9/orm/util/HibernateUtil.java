package lk.ijse.dep9.orm.util;

import lk.ijse.dep9.orm.entity.Customer;
import lk.ijse.dep9.orm.entity.Item;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyComponentPathImpl;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyHbmImpl;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyJpaImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .loadProperties("/application.properties")
                .build();

        Metadata metadata = new MetadataSources(standardRegistry)
                .addAnnotatedClasses(Customer.class, Item.class)
                .getMetadataBuilder()
                .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
                //.applyPhysicalNamingStrategy(new DEPNamingStrategy())
                .build();

        return metadata.getSessionFactoryBuilder().build();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
