package SelfLearnJuly2021.springboot;

import SelfLearnJuly2021.springboot.model.Address;
import SelfLearnJuly2021.springboot.model.Gender;
import SelfLearnJuly2021.springboot.model.Student;
import SelfLearnJuly2021.springboot.model.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository repository,
							 MongoTemplate mongoTemplate) {

		return args -> {
			String email = "piperpuple1@gmail.com";
			Address address = new Address("Vietnam", "Hanoi", "BK63");
			Student student = new Student(
					"Luudinh",
					"Vietan,",
					email,
					Gender.MALE,
					address,
					List.of("Data Structure & Algorithsm", "Analytics1&2&3"),
					BigDecimal.TEN,
					LocalDateTime.now()
			);

			Query query = new Query();
			query.addCriteria(Criteria.where("email").is(email));

			List<Student> students = mongoTemplate.find(query, Student.class);

			if (students.size() > 1) {
				throw new IllegalStateException("found many student with email:" + email);
			}

			if (students.isEmpty()) {
				System.out.println("Inserting student: " + student);
				repository.insert(students);
			} else {
				System.out.println(student + " already exists!");
			}

			//repository.insert(student);
		};
	}
}
