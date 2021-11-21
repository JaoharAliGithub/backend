package com.example.glassfish.Students;

import com.example.glassfish.Students.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import java.util.ArrayList;
import java.util.List;


@Path("/cars")
public class Rest {
    @GET
    @Produces("application/json")

    public List<Student> getStudents()
    {
        Student s1 = new Student();
        s1.setId(1000L);
        s1.setName("Jaohar Ali");
        s1.setSteps(696969);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cars-pu");
        EntityManager eman = emf.createEntityManager();

        eman.getTransaction().begin();
        eman.persist(s1);
        eman.getTransaction().commit();

        List<Student> students = new ArrayList<>();
        try {
            String sql = "SELECT s FROM Student s";
            Query query = eman.createQuery(sql);
            students = query.getResultList();

            students.add(s1);
        } finally {
            eman.close();
            emf.close();
        }
        return students;
    }

}