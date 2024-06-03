package model;

public class Course {

	private int id;
	private String name;
	private int code;
	private int credits;
	private int cluster;
	private int score;
	private String description;
	private String science;
	private int interest;


	public Course(int id, String name, int code, int credits, int cluster, int score, String description, String science) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.credits = credits;
		this.cluster = cluster;
		this.score = score;
		this.description = description;
		this.science = science;

	}

	public Course(int id, String name, String science, String description, int credits, int score) {
		this.id = id;
		this.name = name;
		this.science = science;
		this.description = description;
		this.credits = credits;
		this.score = score;
		this.interest = 0;
		this.cluster = 0;
		this.code = 0;
	}

	public int getInterest() {
		return interest;
	}

	public void setInterest(int interest) {
		this.interest = interest;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public int getCluster() {
		return cluster;
	}

	public void setCluster(int cluster) {
		this.cluster = cluster;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getScience() {
		return science;
	}

	public void setScience(String science) {
		this.science = science;
	}

	@Override
	public String toString() {
		return "Course{" +
				"id_Course=" + id +
				", name_Course='" + name + '\'' +
				", code_Curse=" + code +
				", credits=" + credits +
				", cluster=" + cluster +
				", score=" + score +
				", description='" + description + '\'' +
				", science='" + science + '\'' +
				'}';
	}
}