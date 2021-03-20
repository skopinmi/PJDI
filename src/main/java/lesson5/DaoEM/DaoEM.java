package lesson5.DaoEM;

import lesson5.entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;


public class DaoEM {

    private final EntityManager em;

    public DaoEM(EntityManagerFactory factory) {
        em = factory.createEntityManager();
    }

    public void save (Student student) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(student);
        transaction.commit();
    }

    public Student getById (Long id) {
        Student student = em.find(Student.class, id);
        return student;
    }

    public List <Student> findAll (){
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s", Student.class);
        List<Student> studentList = query.getResultList();
        return studentList;
    }

    public void update (Student student) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Student updatingStudent = getById(student.getId());
        updatingStudent.setName(student.getName());
        updatingStudent.setMark(student.getMark());
        transaction.commit();
    }

    public void delete (Long id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Student student = em.find(Student.class, id);
        em.remove(student);
        transaction.commit();
    }
}
