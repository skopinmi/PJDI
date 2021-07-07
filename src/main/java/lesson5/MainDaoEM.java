package lesson5;

import lesson5.DaoEM.DaoEM;
import lesson5.entities.Student;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManagerFactory;

public class MainDaoEM {
    public static void main(String[] args) {

        EntityManagerFactory factory =  getEntityManagerFactory();

        DaoEM daoEM = new DaoEM(factory);

// сохранение в таблицу

//        for (int i = 0; i < 10; i++) {
//            Student student = new Student("name-" + i, "mark-" + i );
//            daoEM.save(student);
//        }

// чтение из таблицы по id

        for (int i = 1; i < 50; i++) {
            System.out.println(daoEM.getById((long) i));
        }

        for (int i = 1; i < 50; i++) {
            Student student = daoEM.getById((long) i);
            System.out.println(student);
            if (student != null) {
                student.setName(student.getName() + "changed");
                student.setMark(student.getMark() + "changed");
                daoEM.update(student);
            }
        }

//        daoEM.delete(23l);


        for (int i = 1; i < 50; i++) {
            System.out.println(daoEM.getById((long) i));
        }
        System.out.println("======== FIND ALL =========");
        for (Student s :daoEM.findAll()) {
            System.out.println(s);
        }

        factory.close();
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        EntityManagerFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        return factory;
    }
}

