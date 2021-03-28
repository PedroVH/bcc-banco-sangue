package br.furb.bcc.bancosangue;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBConnection {

    private static final SessionFactory sessionFactory = buildSessionFactory();
    public static Session session;

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration()
                    .setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
                    .setProperty("hibernate.connection.url","jdbc:mysql://pedrones.heliohost.us:3306/pedrones_banco_sangue" +
                            "?useTimezone=true&serverTimezone=UTC")
                    .setProperty("hibernate.connection.username","pedrones")
                    .setProperty("hibernate.connection.password","pepito")
                    .setProperty("hibernate.jdbc.time_zone","UTC")
                    .setProperty("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect")
                    .setProperty("hibernate.show_sql","true")
                    .setProperty("hibernate.format_sql","false")
                    .setProperty("hibernate.hbm2ddl.auto","update")
                    .setProperty("hibernate.connection.autocommit","true")
                    .addAnnotatedClass(br.furb.bcc.bancosangue.model.TipoSanguineo.class)
                    .addAnnotatedClass(br.furb.bcc.bancosangue.model.Pessoa.class)
                    //TODO adicionar outras entidades aqui
                    .buildSessionFactory();
        }
        catch (Throwable e) {
            //System.err.println("Initial SessionFactory creation failed: " + e);
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession() {
        if(session == null) {
            session = getSessionFactory().openSession();
        }
        return session;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
