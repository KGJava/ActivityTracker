package mga.edu.activitytracker.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Activity {
	@Id
	@GeneratedValue
	private Long id;

	private String userName;
	private Date activityTime;
	private int numberOfSteps;

	private Activity() {
	}

	public Activity(String userName, Date activityTime, int numberOfSteps) {
		super();
		this.userName = userName;
		this.activityTime = activityTime;
		this.numberOfSteps = numberOfSteps;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getActivityTime() {
		return activityTime;
	}

	public void setActivityTime(Date activityTime) {
		this.activityTime = activityTime;
	}

	public int getNumberOfSteps() {
		return numberOfSteps;
	}

	public void setNumberOfSteps(int numberOfSteps) {
		this.numberOfSteps = numberOfSteps;
	}

}
