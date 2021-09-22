package dao;

import domain.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.NoSuchElementException;

public class StudentDao {
    public Student findById(String studentId){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("student-management-system");
        EntityManager em = emf.createEntityManager();

        Student student = em.find(Student.class, studentId);

        if(student == null){
            throw new NoSuchElementException("NO DATA FOUND WITH THE ID "+studentId);
        }

        return student;
    }
}