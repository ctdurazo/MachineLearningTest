public class Datapoint {
	private String yearly;
	private String monthly;
	private String weekly;
	private String daily;
	private String result;

	public Datapoint() {
		this.yearly = "no";
		this.monthly = "no";
		this.weekly = "no";
		this.daily = "no";
		this.result = "Live";
	}

	public Datapoint(String yearly, String monthly, String weekly, String daily, String result) {
		this.yearly = yearly;
		this.monthly = monthly;
		this.weekly = weekly;
		this.daily = daily;
		this.result = result;
	}

	public String getYearly() {
		return yearly;
	}

	public void setYearly(String yearly) {
		this.yearly = yearly;
	}

	public String getMonthly() {
		return monthly;
	}

	public void setMonthly(String monthly) {
		this.monthly = monthly;
	}

	public String getWeekly() {
		return weekly;
	}

	public void setWeekly(String weekly) {
		this.weekly = weekly;
	}

	public String getDaily() {
		return daily;
	}

	public void setDaily(String daily) {
		this.daily = daily;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
