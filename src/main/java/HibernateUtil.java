import java.util.Properties;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static Session session;

    /**
     * Crea la factoria de sesiones
     */
    public static void buildSessionFactory() {
        Properties propiedades = new Properties();
        propiedades.put(Environment.DRIVER,"org.postgresql.Driver");
        propiedades.put(Environment.URL,"jdbc:postgresql://easybyte.club:2224/NCPOP");
        propiedades.put(Environment.USER,"acarneiro");
        propiedades.put(Environment.PASS, "acarneiro@Servo2021*");
        propiedades.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        propiedades.put(Environment.SHOW_SQL, "false");

        Configuration configuration = new Configuration();
        configuration.setProperties(propiedades);
        configuration.configure();
        // Se registran las clases que hay que mapear con cada tabla de la base de datos
        configuration.addAnnotatedClass(Departamentos.class);
        configuration.addAnnotatedClass(Empleados.class);
    //. . .

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();


        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    /**
     * Abre una nueva sesion
     */
    public static void openSession() {
        session = sessionFactory.openSession();
    }

    /**
     * Devuelve la sesión actual
     * @return
     */
    public static Session getCurrentSession() {

        if ((session == null) || (!session.isOpen()))
            openSession();

        return session;
    }

    /**
     * Cierra Hibernate
     */
    public static void closeSessionFactory() {

        if (session != null)
            session.close();

        if (sessionFactory != null)
            sessionFactory.close();
    }

    public static void addObject(Object object){
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        session.close();
    }

    public static void removeObject(Object object){
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
        session.close();
    }


}