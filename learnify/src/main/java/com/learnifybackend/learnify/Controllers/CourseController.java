package com.learnifybackend.learnify.Controllers;
import com.learnifybackend.learnify.Entities.Course;
import com.learnifybackend.learnify.Entities.User;
import com.learnifybackend.learnify.Service.CourseService;
import com.learnifybackend.learnify.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;




@RestController
@RequestMapping({"/courses"})
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

   /* @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    */

    @PostMapping
    public Course createCourse(@RequestBody Course course) {

        return courseService.createCourse(course);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course updatedCourse) {
        return courseService.updateCourse(id, updatedCourse);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }
    @GetMapping("/instructor/{instructorId}")
    public List<Course> getCoursesByInstructor(@PathVariable Long instructorId) {
        // Assuming you have a method in CourseService to get courses by instructor
       // return courseService.getCoursesByInstructor(instructorId);
        return null;
    }

    /*@GetMapping("/earnings/{instructorId}")
    public double getTotalEarningsByInstructor(@PathVariable Long instructorId) {
        // Assuming you have a method in CourseService to fetch user details by ID
        User instructor = UserService.getUserById(instructorId);
        if (instructor == null) {
            throw new RuntimeException("Instructor not found");
        }
        return courseService.calculateTotalEarningsByInstructor(instructor);
    }*/
    /*
    public User getUserById(Long id) {

        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }*/

    private Long instructorId   ;
    //User instructor = userService.getUserById(instructorId);



    // Additional endpoints for course-related operations
}