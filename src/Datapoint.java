public class Datapoint {
	private double yearly;
	private double monthly;
	private double weekly;
	private double daily;
	private String result;

	public Datapoint() {
		this.yearly = 0;
		this.monthly = 0;
		this.weekly = 0;
		this.daily = 0;
		this.result = "Live";
	}

	public Datapoint(double yearly, double monthly, double weekly, double daily, String result) {
		this.yearly = yearly;
		this.monthly = monthly;
		this.weekly = weekly;
		this.daily = daily;
		this.result = result;
	}

	public double getYearly() {
		return yearly;
	}

	public void setYearly(double yearly) {
		this.yearly = yearly;
	}

	public double getMonthly() {
		return monthly;
	}

	public void setMonthly(double monthly) {
		this.monthly = monthly;
	}

	public double getWeekly() {
		return weekly;
	}

	public void setWeekly(double weekly) {
		this.weekly = weekly;
	}

	public double getDaily() {
		return daily;
	}

	public void setDaily(double daily) {
		this.daily = daily;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
