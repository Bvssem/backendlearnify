package com.learnifybackend.learnify.Entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity

@Table(name = "courses")

public class Course {


    public Course(String status, String title, String price, String slug, String aboutCourse, int maximumStudents, String difficultyLevel, boolean isPublicCourse, boolean enableQA, String categories, byte[] courseThumbnail, String introVideoPath, List<String> topics, Date startDate, String language, String requirements, String description, int totalCourseDurationHours, int totalCourseDurationMinutes, String courseTags, String targetedAudience, Instructor instructor, byte[] certificateTemplate) {
        this.title = title;
        this.price = price;
        // Course Setting
        // Choose Categories
        this.courseThumbnail = courseThumbnail;
        // Course Intro Video
        // Store local video path or video URL
        this.topics = topics;
        // Additional Information
        this.instructor = instructor;
        this.certificateTemplate = certificateTemplate;
    }

    public Course (Instructor instructor, String title, String price, byte[] certificateTemplate) {
        this.instructor = instructor;

        this.title = title;
        this.price = price;
        this.certificateTemplate = certificateTemplate;
    }

    public Course(Instructor instructor, byte[] certificateTemplate) {

        this.instructor = instructor;
        this.certificateTemplate = certificateTemplate;
    }

    public Course(byte[] certificateTemplate) {

        this.certificateTemplate = certificateTemplate;
    }

    public Course() {

    }

    public Long getId() {

        return id;
    }








    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne // Assuming instructorId is related to an Instructor entity
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;



    // Course Info
    private String title;
    private String price;

    // Course Thumbnail
    @Lob
    @Column(name = "course_thumbnail")
    private byte[] courseThumbnail;

    // Course Builder - Topic
    @ElementCollection
    @CollectionTable(name = "course_topics", joinColumns = @JoinColumn(name = "course_id"))
    private List<String> topics;

    // Certificate Template
    @Lob
    @Column(name = "certificate_template")
    private byte[] certificateTemplate;


    // Getters and setters
}