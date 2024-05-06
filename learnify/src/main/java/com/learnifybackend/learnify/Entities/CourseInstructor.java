package com.learnifybackend.learnify.Entities;

import jakarta.persistence.*;

@Entity
@Table(name ="course_instructor" )
public class CourseInstructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    // Constructors, getters, and setters

    public CourseInstructor() {
    }

    public CourseInstructor(Instructor instructor, Course course) {
        this.instructor = instructor;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
