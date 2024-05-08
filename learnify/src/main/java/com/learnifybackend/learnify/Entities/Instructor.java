package com.learnifybackend.learnify.Entities;

import jakarta.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity

public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "instructor_id")
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String username;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 6)
    private String password;

    @Transient
    private String passwordConfirmation;

    private String phone;

    @Column(columnDefinition = "TEXT")
    private String bio;

    @OneToMany(mappedBy = "instructor")
    private List<CourseInstructor> courseInstructors;

    public Instructor(String firstName, String lastName, String username, String email, String password, String passwordConfirmation, String phone, String bio, List<CourseInstructor> courseInstructors) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
        this.phone = phone;
        this.bio = bio;
        this.courseInstructors = courseInstructors;
    }

    public Instructor() {

    }

    public Long getId() {
    return id;}

    // Getters and Setters

}
