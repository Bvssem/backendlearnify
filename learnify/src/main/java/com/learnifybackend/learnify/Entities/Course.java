package com.learnifybackend.learnify.Entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity

@Table(name = "courses")
public class Course {





    private String status;

    public Course(String status, String slug, String aboutCourse, int maximumStudents, String difficultyLevel, boolean isPublicCourse, boolean enableQA, String categories, byte[] courseThumbnail, String introVideoPath, List<String> topics, Date startDate, String language, String requirements, String description, int totalCourseDurationHours, int totalCourseDurationMinutes, String courseTags, String targetedAudience) {
        this.status = status;
        this.slug = slug;
        this.aboutCourse = aboutCourse;
        this.maximumStudents = maximumStudents;
        this.difficultyLevel = difficultyLevel;
        this.isPublicCourse = isPublicCourse;
        this.enableQA = enableQA;
        this.categories = categories;
        this.courseThumbnail = courseThumbnail;
        this.introVideoPath = introVideoPath;
        this.topics = topics;
        this.startDate = startDate;
        this.language = language;
        this.requirements = requirements;
        this.description = description;
        this.totalCourseDurationHours = totalCourseDurationHours;
        this.totalCourseDurationMinutes = totalCourseDurationMinutes;
        this.courseTags = courseTags;
        this.targetedAudience = targetedAudience;
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
    @JoinColumns({
            @JoinColumn(name = "instructor_id1", referencedColumnName = "id1"),
            @JoinColumn(name = "instructor_id2", referencedColumnName = "id2")
    })
    private Instructor instructor;



    // Course Info
    private String title;
    private String price;

    private String slug;

    private String aboutCourse;

    // Course Setting
    private int maximumStudents;

    private String difficultyLevel;

    private boolean isPublicCourse;

    private boolean enableQA;

    // Choose Categories
    private String categories;

    // Course Thumbnail
    @Lob
    @Column(name = "course_thumbnail")
    private byte[] courseThumbnail;

    // Course Intro Video
    private String introVideoPath; // Store local video path or video URL

    // Course Builder - Topic
    @ElementCollection
    @CollectionTable(name = "course_topics", joinColumns = @JoinColumn(name = "course_id"))
    private List<String> topics;

    // Additional Information
    private Date startDate;

    private String language;

    private String requirements;

    private String description;

    private int totalCourseDurationHours;

    private int totalCourseDurationMinutes;

    private String courseTags;

    private String targetedAudience;

    // Certificate Template
    @Lob
    @Column(name = "certificate_template")
    private byte[] certificateTemplate;


    // Getters and setters
}