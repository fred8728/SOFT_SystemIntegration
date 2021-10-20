
package dao;

import domain.Result;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.NoSuchElementException;

public class ResultDao {
    public Result findById(String studentId){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("student-management-system");
        EntityManager em = emf.createEntityManager();

        Result result = em.find(Result.class, studentId);

        if(result == null){
            throw new NoSuchElementException("NO DATA FOUND WITH THE ID "+studentId);
        }

        return result;
    }
}