package lesson5;

import lesson5.baseDao.BaseDao;
import lesson5.dao.Dao;
import lesson5.entities.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {

    public static void main(String[] args) {

        SessionFactory factory =  getSessionFactory();

        BaseDao <Student> baseDao = new BaseDao<>(factory, Student.class);

        Dao dao = new Dao(factory);

// сохранение в таблицу

//        for (int i = 0; i < 10; i++) {
//            Student student = new Student("name-" + i, "mark-" + i );
//            baseDao.save(student);
//        }

// чтение из таблицы по id

//        for (int i = 1; i < 50; i++) {
//            System.out.println(baseDao.get((long) i));
//        }
//        factory.close();


    }

    public static SessionFactory getSessionFactory (){

        SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Student.class)
            .buildSessionFactory();

        return factory;
    }
}