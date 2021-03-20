package lesson5.dao;

import lesson5.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Dao {
    private SessionFactory sessionFactory;
    private Session session;

    public Dao (SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save (Student student) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
    }

    public Student getById (Long id) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Student student = session.get(Student.class , id);
        session.getTransaction().commit();
        return student;
    }

    public void update (Student student) {
        session.beginTransaction();
        Student studentForUpdate = session.createQuery("SELECT s FROM students s WHERE s.id = :id", Student.class)
                .setParameter("id", student.getId())
                .getSingleResult();
        System.out.println(studentForUpdate);

        simpleItemForUpdate.setPrice(simpleItemForUpdate.getPrice() + 1100000);
        System.out.println("Modified item: " + simpleItemForUpdate);
        session.getTransaction().commit();

        session = factory.getCurrentSession();
        session.beginTransaction();
        SimpleItem simpleItemAfterUpdate = session.get(SimpleItem.class, simpleItemForUpdate.getId());
        System.out.println("Loaded item after update: " + simpleItemAfterUpdate);
        session.getTransaction().commit();
        
    }

    public void delete (Long id) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(session.get(Student.class, id));
        session.getTransaction().commit();
    }

}
