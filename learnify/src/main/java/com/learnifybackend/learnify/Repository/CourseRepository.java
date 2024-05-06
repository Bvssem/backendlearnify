package com.learnifybackend.learnify.Repository;
import com.learnifybackend.learnify.Entities.Course;
import com.learnifybackend.learnify.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByInstructorId(Long instructor);

    int countByInstructorIdAndStatus(Long instructorId, String status);

    int countDistinctEnrolledStudentsByInstructorId(User instructor);



    double sumOfEarningsByInstructor(User instructor);

    double sumOfEarningsByInstructorId(Long id);



    int countByInstructorId(long instructorId);

    int countDistinctEnrolledStudentsByInstructorId(Long id);




    @Query
    ("SELECT COUNT(c) FROM Course c WHERE c.instructor.id = :instructorId")
    int countByInstructorId(@Param("instructorId") Long instructorId);

    int countby(Long id);


    // Add any other methods related to courses and instructors

}