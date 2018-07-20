package mga.edu.activitytracker.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mga.edu.activitytracker.model.Activity;
import mga.edu.activitytracker.model.Report;
import mga.edu.activitytracker.repository.ActivityRepository;
import mga.edu.activitytracker.util.ReportUtil;

@RestController
@RequestMapping("/report/{reportType}/{userName}")
public class ReportController {
	private final ActivityRepository activityRepository;

	@Autowired
	ReportController(ActivityRepository activityRepository) {
		this.activityRepository = activityRepository;
	}

	@GetMapping
	Report getReport(@PathVariable String reportType, @PathVariable String userName) {
		Collection<Activity> activities = this.activityRepository.findByUserName(userName);
		return ReportUtil.generateReport(reportType, activities);
	}

	@DeleteMapping
	Report delteActivitiesFromPeriod(@PathVariable String reportType, @PathVariable String userName) {
		Collection<Activity> activities = this.activityRepository.findByUserName(userName);
		List<Activity> filteredActivities = ReportUtil.getActivitiesExcludingFirstPeriod(reportType, activities);
		if (!CollectionUtils.isEmpty(filteredActivities)) {
			for (Activity current : filteredActivities) {
				this.activityRepository.delete(current);
			}
		}
		activities = this.activityRepository.findByUserName(userName);
		return ReportUtil.generateReport(reportType, activities);
	}
}
