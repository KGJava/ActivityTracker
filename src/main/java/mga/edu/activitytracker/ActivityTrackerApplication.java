package mga.edu.activitytracker;

import java.util.Arrays;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import mga.edu.activitytracker.model.Activity;
import mga.edu.activitytracker.repository.ActivityRepository;

@SpringBootApplication
public class ActivityTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivityTrackerApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ActivityRepository activityRepository) {
		return args -> Arrays.asList("100", "1000").forEach(numberOfSteps -> {
			activityRepository.save(new Activity("testUser", new Date(), Integer.valueOf(numberOfSteps)));
		});
	}
}
