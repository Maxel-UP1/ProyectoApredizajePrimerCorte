package model;

public class Course {

	private int id_Course;
	private String name_Course;
	private int code_Curse;
	private int credits;
	private int cluster;
	private int score;
	private String description;
	private String science;

	public Course(int id_Course, String name_Course, int code_Curse, int credits, int cluster, int score, String description, String science) {
		this.id_Course = id_Course;
		this.name_Course = name_Course;
		this.code_Curse = code_Curse;
		this.credits = credits;
		this.cluster = cluster;
		this.score = score;
		this.description = description;
		this.science = science;
	}

	public int getId_Course() {
		return id_Course;
	}

	public String getName_Course() {
		return name_Course;
	}

	public int getCode_Curse() {
		return code_Curse;
	}

	public int getCredits() {
		return credits;
	}

	public int getCluster() {
		return cluster;
	}

	public int getScore() {
		return score;
	}

	public String getDescription() {
		return description;
	}

	public String getScience() {
		return science;
	}

	@Override
	public String toString() {
		return "Course{" +
				"id_Course=" + id_Course +
				", name_Course='" + name_Course + '\'' +
				", code_Curse=" + code_Curse +
				", credits=" + credits +
				", cluster=" + cluster +
				", score=" + score +
				", description='" + description + '\'' +
				", science='" + science + '\'' +
				'}';
	}
}