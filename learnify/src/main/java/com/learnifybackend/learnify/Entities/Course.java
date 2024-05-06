package com.learnifybackend.learnify.Entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    private String status;

    public Long getId() {
        return id;
    }
    public String getCourseStatus() {
        // Implementation logic goes here
        return "Active"; // Example return value
    }


    public Long getInstructorId() {
        return instructor.getId();
    }


    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getSlug() {
        return slug;
    }

    public String getAboutCourse() {
        return aboutCourse;
    }

    public int getMaximumStudents() {
        return maximumStudents;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public boolean isPublicCourse() {
        return isPublicCourse;
    }

    public boolean isEnableQA() {
        return enableQA;
    }

    public String getCategories() {
        return categories;
    }

    public byte[] getCourseThumbnail() {
        return courseThumbnail;
    }

    public String getIntroVideoPath() {
        return introVideoPath;
    }

    public List<String> getTopics() {
        return topics;
    }

    public Date getStartDate() {
        return startDate;
    }

    public String getLanguage() {
        return language;
    }

    public String getRequirements() {
        return requirements;
    }

    public String getDescription() {
        return description;
    }

    public int getTotalCourseDurationHours() {
        return totalCourseDurationHours;
    }

    public int getTotalCourseDurationMinutes() {
        return totalCourseDurationMinutes;
    }

    public String getCourseTags() {
        return courseTags;
    }

    public String getTargetedAudience() {
        return targetedAudience;
    }

    public byte[] getCertificateTemplate() {
        return certificateTemplate;
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