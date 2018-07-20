package mga.edu.activitytracker.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import mga.edu.activitytracker.constants.Constants;
import mga.edu.activitytracker.model.Activity;
import mga.edu.activitytracker.model.Report;

public class ReportUtil {
	private ReportUtil() {

	}

	public static Report generateReport(String reportType, Collection<Activity> activities) {
		Report report = new Report();
		Date firstPeriodDate = null;
		Date secondPeriodDate = null;
		Date thirdPeriodDate = null;
		Date fourthPeriodDate = null;
		Date fifthPeriodDate = null;
		Calendar now = Calendar.getInstance();

		if (reportType.equalsIgnoreCase(Constants.HOURLY_REPORT_TYPE)) {
			now.add(Calendar.HOUR, -1);
			firstPeriodDate = now.getTime();
			now.add(Calendar.HOUR, -1);
			secondPeriodDate = now.getTime();
			now.add(Calendar.HOUR, -1);
			thirdPeriodDate = now.getTime();
			now.add(Calendar.HOUR, -1);
			fourthPeriodDate = now.getTime();
			now.add(Calendar.HOUR, -1);
			fifthPeriodDate = now.getTime();
		} else if (reportType.equalsIgnoreCase(Constants.DAILY_REPORT_TYPE)) {
			now.add(Calendar.DATE, -1);
			firstPeriodDate = now.getTime();
			now.add(Calendar.DATE, -1);
			secondPeriodDate = now.getTime();
			now.add(Calendar.DATE, -1);
			thirdPeriodDate = now.getTime();
			now.add(Calendar.DATE, -1);
			fourthPeriodDate = now.getTime();
			now.add(Calendar.DATE, -1);
			fifthPeriodDate = now.getTime();
		} else if (reportType.equalsIgnoreCase(Constants.WEEKLY_REPORT_TYPE)) {
			now.add(Calendar.DATE, -7);
			firstPeriodDate = now.getTime();
			now.add(Calendar.DATE, -7);
			secondPeriodDate = now.getTime();
			now.add(Calendar.DATE, -7);
			thirdPeriodDate = now.getTime();
			now.add(Calendar.DATE, -7);
			fourthPeriodDate = now.getTime();
			now.add(Calendar.DATE, -7);
			fifthPeriodDate = now.getTime();
		} else if (reportType.equalsIgnoreCase(Constants.MONTHLY_REPORT_TYPE)) {
			now.add(Calendar.MONTH, -1);
			firstPeriodDate = now.getTime();
			now.add(Calendar.MONTH, -1);
			secondPeriodDate = now.getTime();
			now.add(Calendar.MONTH, -1);
			thirdPeriodDate = now.getTime();
			now.add(Calendar.MONTH, -1);
			fourthPeriodDate = now.getTime();
			now.add(Calendar.MONTH, -1);
			fifthPeriodDate = now.getTime();
		} else {
			return report;
		}
		List<Activity> firstPeriodActivities = new ArrayList<>();
		List<Activity> secondPeriodActivities = new ArrayList<>();
		List<Activity> thirdPeriodActivities = new ArrayList<>();
		List<Activity> fourthPeriodActivities = new ArrayList<>();
		List<Activity> fifthPeriodActivities = new ArrayList<>();
		for (Activity current : activities) {
			if (current.getActivityTime().after(firstPeriodDate)) {
				firstPeriodActivities.add(current);
			} else if (current.getActivityTime().after(secondPeriodDate)) {
				secondPeriodActivities.add(current);
			} else if (current.getActivityTime().after(thirdPeriodDate)) {
				thirdPeriodActivities.add(current);
			} else if (current.getActivityTime().after(fourthPeriodDate)) {
				fourthPeriodActivities.add(current);
			} else if (current.getActivityTime().after(fifthPeriodDate)) {
				fifthPeriodActivities.add(current);
			}
		}
		report.setFirstPeriodSteps(ReportUtil.countSteps(firstPeriodActivities));
		report.setSecondPeriodSteps(ReportUtil.countSteps(secondPeriodActivities));
		report.setThirdPeriodSteps(ReportUtil.countSteps(thirdPeriodActivities));
		report.setFourthPeriodSteps(ReportUtil.countSteps(fourthPeriodActivities));
		report.setFifthPeriodSteps(ReportUtil.countSteps(fifthPeriodActivities));

		return report;
	}

	public static List<Activity> getFirstPeriodActivities(String reportType, Collection<Activity> activities) {
		List<Activity> firstPeriodActivities = new ArrayList<>();
		Date firstPeriodDate = null;

		Calendar now = Calendar.getInstance();

		if (reportType.equalsIgnoreCase(Constants.HOURLY_REPORT_TYPE)) {
			now.add(Calendar.HOUR, -1);
			firstPeriodDate = now.getTime();
		} else if (reportType.equalsIgnoreCase(Constants.DAILY_REPORT_TYPE)) {
			now.add(Calendar.DATE, -1);
			firstPeriodDate = now.getTime();
		} else if (reportType.equalsIgnoreCase(Constants.WEEKLY_REPORT_TYPE)) {
			now.add(Calendar.DATE, -7);
			firstPeriodDate = now.getTime();
		} else if (reportType.equalsIgnoreCase(Constants.MONTHLY_REPORT_TYPE)) {
			now.add(Calendar.MONTH, -1);
			firstPeriodDate = now.getTime();
		} else {
			return firstPeriodActivities;
		}
		for (Activity current : activities) {
			if (current.getActivityTime().after(firstPeriodDate)) {
				firstPeriodActivities.add(current);
			}
		}
		return firstPeriodActivities;
	}
	public static List<Activity> getActivitiesExcludingFirstPeriod(String reportType, Collection<Activity> activities) {
		List<Activity> oldActivities = new ArrayList<>();
		Date firstPeriodDate = null;

		Calendar now = Calendar.getInstance();

		if (reportType.equalsIgnoreCase(Constants.HOURLY_REPORT_TYPE)) {
			now.add(Calendar.HOUR, -1);
			firstPeriodDate = now.getTime();
		} else if (reportType.equalsIgnoreCase(Constants.DAILY_REPORT_TYPE)) {
			now.add(Calendar.DATE, -1);
			firstPeriodDate = now.getTime();
		} else if (reportType.equalsIgnoreCase(Constants.WEEKLY_REPORT_TYPE)) {
			now.add(Calendar.DATE, -7);
			firstPeriodDate = now.getTime();
		} else if (reportType.equalsIgnoreCase(Constants.MONTHLY_REPORT_TYPE)) {
			now.add(Calendar.MONTH, -1);
			firstPeriodDate = now.getTime();
		} else {
			return oldActivities;
		}
		for (Activity current : activities) {
			if (current.getActivityTime().before(firstPeriodDate)) {
				oldActivities.add(current);
			}
		}
		return oldActivities;
	}
	private static int countSteps(List<Activity> activities) {
		int steps = 0;
		for (Activity current : activities) {
			steps += current.getNumberOfSteps();
		}
		return steps;
	}
}
