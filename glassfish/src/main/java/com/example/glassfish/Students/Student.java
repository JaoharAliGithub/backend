package com.example.glassfish.Students;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;


import java.util.List;

@Entity
//@Cacheable(true)
@Table(name = "`Student`")
//@NamedQueries({
//        @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
//        @NamedQuery(name = "Student.findByName", query = "SELECT s FROM Student s WHERE s.name = :name")
//})
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = true)
    private Long id;

    @Column(name = "`name`", nullable = false)
    @NotNull
    private String name = "na";

    @Column(name = "`steps`", nullable = false)
    @NotNull
    private int steps = 2;

    @Column(name = "`distance`", nullable = false)
    @NotNull
    private int distance = 432;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Student() {
    }

    public Student(Long id, String name, int steps, int distance) {
        this.id = id;
        this.name = name;
        this.steps = steps;
        this.distance = distance;
    }

//    public void saveCar(Student student, EntityManager em, EntityManagerFactory emf){
//        em.getTransaction().begin();
//        em.persist(student);
//        em.getTransaction().commit();
//    }
//
//    public Student findStudentByName(String name, EntityManager em, EntityManagerFactory emf){
//        Query query = em.createNamedQuery("Student.findByName");
//        Student student = (Student) query.getSingleResult();
//
//        return student;
//    }
//    public List<Student> findAll(EntityManager em, EntityManagerFactory emf) {
//
//        Query query = em.createNamedQuery("Student.findAll");
//
//        List<Student> students = query.getResultList();
//
//        return students;
//    }

}
