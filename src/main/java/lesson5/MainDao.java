package lesson5;

import lesson5.baseDao.BaseDao;
import lesson5.dao.Dao;
import lesson5.entities.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainDao {

    public static void main(String[] args) {
        SessionFactory factory =  getSessionFactory();
        Dao dao = new Dao(factory);

        System.out.println(dao.getById((long) 1));
        Student student = dao.getById((long) 1);
        student.setName(student.getName() + " changed name ");
        System.out.println("up");
        dao.update(student);
        System.out.println(dao.getById((long) 1));
        System.out.println("del");
        dao.delete((long) 1);
        System.out.println(dao.getById((long) 1));
        System.out.println("save");
        dao.save(student);

    }



    public static SessionFactory getSessionFactory (){

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        return factory;
    }
}
