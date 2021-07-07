package ru.geekbrains.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.entities.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
}
