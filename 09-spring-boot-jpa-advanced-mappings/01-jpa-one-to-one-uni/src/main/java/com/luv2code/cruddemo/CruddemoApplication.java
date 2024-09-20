package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			//createInstructor(appDAO);
			findInstructor(appDAO);
		};
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
