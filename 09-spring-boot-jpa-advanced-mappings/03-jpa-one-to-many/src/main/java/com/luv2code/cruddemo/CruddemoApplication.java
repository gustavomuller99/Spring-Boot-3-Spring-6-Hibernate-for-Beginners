package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//findInstructorDetail(appDAO);
			//deleteInstructorDetail(appDAO);
			//createInstructorWithCourses(appDAO);
			//findInstructorWithCourses(appDAO);
			//findCoursesForInstructor(appDAO);
			//findInstructorWithCoursesJoinFetch(appDAO);
			//updateInstructor(appDAO);
			//updateCourse(appDAO);
			//deleteInstructor(appDAO);
			deleteCourse(appDAO);
		};
	}

	private void deleteCourse(AppDAO appDAO) {
		int id = 10;
		System.out.println("Deleting course: " + id);
		appDAO.deleteCourseById(id);
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Deleting instructor: " + id);
		appDAO.deleteInstructorById(id);
	}

	private void updateCourse(AppDAO appDAO) {
		int id = 10;

		System.out.println("Finding course: " + id);
		Course course = appDAO.findCourseById(id);
		course.setTitle("New course");

		System.out.println("Updating...");
		appDAO.update(course);
	}

	private void updateInstructor(AppDAO appDAO) {
		int id = 1;

		System.out.println("Finding instructor: " + id);
		Instructor instructor = appDAO.findInstructorById(id);
		instructor.setEmail("nds@gmail.com");

		System.out.println("Updating...");
		appDAO.update(instructor);
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor: " + id);
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);

		System.out.println("Instructor: " + instructor);
		System.out.println("Courses: " + instructor.getCourses());
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor id: " + id);

		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Instructor: " + instructor);

		List<Course> courses = appDAO.findCoursesByInstructorId(id);
		instructor.setCourses(courses);

		System.out.println("Courses: " + instructor.getCourses());
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor id: " + id);

		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Instructor: " + instructor);
		System.out.println("Courses: " + instructor.getCourses());
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		// create
		Instructor tempInstructor =
				new Instructor("Gustavo", "Muller", "gu@muller.com");
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.youtube.com", "OK!!");

		// set
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// create courses
		Course course1 = new Course("Air Guitar");
		Course course2 = new Course("Spring Boot Class");

		tempInstructor.add(course1);
		tempInstructor.add(course2);

		System.out.println("Saving instructor: " + tempInstructor);
		System.out.println("Courses: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int id = 1; // change
		System.out.println("Deleting instructor detail: " + id);

		appDAO.deleteInstructorDetailById(id);

		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int id = 1;
		System.out.println("Find instructor detail: " + id);

		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);

		System.out.println("Found: " + instructorDetail);
		System.out.println("Instructor: " + instructorDetail.getInstructor());
	}

	private void findInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor: " + id);

		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Found: " + instructor);
		System.out.println("Details -> " + instructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {

		// create
		Instructor tempInstructor =
				new Instructor("Gustavo", "Muller", "gu@muller.com");
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.youtube.com", "OK!!");

		// set
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save -> Cascade.ALL
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}
}
