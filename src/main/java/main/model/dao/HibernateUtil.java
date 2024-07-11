package main.model.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static HibernateUtil instance = null;

    private StandardServiceRegistry serviceRegistry;
    private SessionFactory sessionFactory;

    private HibernateUtil(){
        serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("main/model/dao/hibernate.cfgTEST.xml").build();
        Metadata metadata = new MetadataSources(serviceRegistry)
                .getMetadataBuilder().build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }

    public static HibernateUtil getInstance(){
        if(instance == null){
            instance = new HibernateUtil();
        }
        return instance;
    }

    public synchronized SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
