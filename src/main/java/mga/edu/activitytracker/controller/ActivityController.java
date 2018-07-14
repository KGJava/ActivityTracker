package mga.edu.activitytracker.controller;

import java.net.URI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import mga.edu.activitytracker.model.Activity;
import mga.edu.activitytracker.repository.ActivityRepository;

@RestController
@RequestMapping("/activities/{userName}")
public class ActivityController {
	private final ActivityRepository activityRepository;

	@Autowired
	ActivityController(ActivityRepository activityRepository) {
		this.activityRepository = activityRepository;
	}

	@GetMapping
	Collection<Activity> readActivities(@PathVariable String userName) {
		return this.activityRepository.findByUserName(userName);
	}

	@PostMapping
	ResponseEntity<?> add(@PathVariable String userName, @RequestBody Activity activity) {
		Activity createdActivity = this.activityRepository.save(activity);
		if (createdActivity != null) {
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(createdActivity.getId()).toUri();
			return ResponseEntity.created(location).build();
		} else {
			return ResponseEntity.noContent().build();
		}
	}
}
