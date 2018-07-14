package mga.edu.activitytracker.model;

public class Report {
	private int firstPeriodSteps;
	private int secondPeriodSteps;
	private int thirdPeriodSteps;
	private int fourthPeriodSteps;
	private int fifthPeriodSteps;

	public Report() {
		super();
	}

	public Report(int firstPeriodSteps, int secondPeriodSteps, int thirdPeriodSteps, int fourthPeriodSteps,
			int fifthPeriodSteps) {
		this();
		this.firstPeriodSteps = firstPeriodSteps;
		this.secondPeriodSteps = secondPeriodSteps;
		this.thirdPeriodSteps = thirdPeriodSteps;
		this.fourthPeriodSteps = fourthPeriodSteps;
		this.fifthPeriodSteps = fifthPeriodSteps;
	}

	public int getFirstPeriodSteps() {
		return firstPeriodSteps;
	}

	public void setFirstPeriodSteps(int firstPeriodSteps) {
		this.firstPeriodSteps = firstPeriodSteps;
	}

	public int getSecondPeriodSteps() {
		return secondPeriodSteps;
	}

	public void setSecondPeriodSteps(int secondPeriodSteps) {
		this.secondPeriodSteps = secondPeriodSteps;
	}

	public int getThirdPeriodSteps() {
		return thirdPeriodSteps;
	}

	public void setThirdPeriodSteps(int thirdPeriodSteps) {
		this.thirdPeriodSteps = thirdPeriodSteps;
	}

	public int getFourthPeriodSteps() {
		return fourthPeriodSteps;
	}

	public void setFourthPeriodSteps(int fourthPeriodSteps) {
		this.fourthPeriodSteps = fourthPeriodSteps;
	}

	public int getFifthPeriodSteps() {
		return fifthPeriodSteps;
	}

	public void setFifthPeriodSteps(int fifthPeriodSteps) {
		this.fifthPeriodSteps = fifthPeriodSteps;
	}

}
