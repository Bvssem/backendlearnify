package com.learnifybackend.learnify.Repository;
import com.learnifybackend.learnify.Entities.Course;
import com.learnifybackend.learnify.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByInstructorId(Long instructor);


    int countByInstructorIdAndStatus(Long instructorId, String status);

    @Query("SELECT COUNT(DISTINCT c.enrolledStudents) FROM Course c WHERE c.instructor.id = :instructorId")
    int countDistinctEnrolledStudentsByInstructorId(@Param("instructorId") Long id);

    @Query("SELECT SUM(c.price) FROM Course c WHERE c.instructor = :instructor")
    double sumOfEarningsByInstructor(Long instructor);



    @Service
    public class CourseService {
        @Autowired
        private CourseRepository courseRepository;

        public double calculateSumOfEarningsByInstructor(User instructor) {
            List<Course> courses = courseRepository.findByInstructor(instructor.getId());
            double sum = 0.0;
            for (Course course : courses) {
                sum += Double.parseDouble(course.getPrice()); // Assuming getPrice() returns the earnings for a course
            }
            return sum;
        }
    }

    List<Course> findByInstructor(Long instructor);


    int countByInstructorId(long instructorId);





    @Query
    ("SELECT COUNT(c) FROM Course c WHERE c.instructor.id = :instructorId")
    int countByInstructorId(@Param("instructorId") Long instructorId);




    // Add any other methods related to courses and instructors

}