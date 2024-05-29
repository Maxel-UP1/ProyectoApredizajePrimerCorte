package model;

public class Course {

	private int id_Course;
	private String name_Course;
	private int code_Curse;;
	private int credits;
	private int cluster;
	private int score;

	public Course(int id_Course, String name_Course, int code_Curse, int credits, int cluster, int score) {
		this.id_Course = id_Course;
		this.name_Course = name_Course;
		this.code_Curse = code_Curse;
		this.score = score;
		this.credits = credits;
		this.cluster = cluster;
	}

	public int getId_Course() {
		return id_Course;
	}

	public void setId_Course(int id_Course) {
		this.id_Course = id_Course;
	}

	public String getName_Course() {
		return name_Course;
	}

	public void setName_Course(String name_Course) {
		this.name_Course = name_Course;
	}

	public int getCode_Curse() {
		return code_Curse;
	}

	public void setCode_Curse(int code_Curse) {
		this.code_Curse = code_Curse;
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

	@Override
	public String toString() {
		return "Course: " + "id : " + id_Course + " Name : '" + name_Course + '\'' + ", Code: "
				+ code_Curse  + " credits: " + credits + " cluster: " + cluster  + "\n";
	}

}
