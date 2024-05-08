package com.learnifybackend.learnify.Service;

import com.learnifybackend.learnify.Entities.Course;
import com.learnifybackend.learnify.Entities.User;
import com.learnifybackend.learnify.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {

        this.courseRepository = courseRepository;
    }
    public double calculateTotalEarningsByInstructor(User instructor) {
        return courseRepository.sumOfEarningsByInstructor(instructor.getId());
    }

    public List<Course> getCoursesByInstructor(Long instructor) {
        return courseRepository.findByInstructor(instructor);
    }

    public Course updateCourseStatus(Long courseId, String status) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        course.setStatus(status);
        return courseRepository.save(course);
    }





    // Methods for course-related operations

    public Course createCourse(Course course) {
        // Perform any necessary validation on the course object

        // Save the course to the database using the courseRepository
        return courseRepository.save(course);
    }

    public Course updateCourse(Long courseId, Course updatedCourse) {
        // Find the course by ID using the courseRepository
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        // Update the course fields with the values from the updatedCourse object

        // Save the updated course to the database using the courseRepository
        return courseRepository.save(course);
    }

    public void deleteCourse(Long courseId) {
        // Find the course by ID using the courseRepository
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        // Delete the course from the database using the courseRepository
        courseRepository.delete(course);
    }
    public int countByInstructorId(Long instructorId) {
        return courseRepository.countByInstructorId(instructorId);

    }


    // Additional methods for course-related operations
}
