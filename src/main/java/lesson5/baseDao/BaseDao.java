package lesson5.baseDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;

public class BaseDao <T , K >   {
    private SessionFactory sessionFactory;
    private Session session;
    private Class <T> item;

    public BaseDao(SessionFactory sessionFactory, Class<T> item) {
        this.sessionFactory = sessionFactory;
        this.item = item;
    }

    public void save (T object) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }

    public T get (K id) {
        T temp;
        session = sessionFactory.getCurrentSession();
        return session.get(item , (Serializable) id);
    }
}
