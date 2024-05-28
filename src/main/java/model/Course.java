package model;

public class Course {

	private int id_Course;
	private String name_Course;
	private int code_Curse;
	private int id_Teacher;
	private int credits;
	private int cluster;

	public Course(int id_Course, String name_Course, int code_Curse, int id_Teacher, int credits, int cluster) {
		this.id_Course = id_Course;
		this.name_Course = name_Course;
		this.code_Curse = code_Curse;
		this.id_Teacher = id_Teacher;
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

	public int getId_Teacher() {
		return id_Teacher;
	}

	public void setId_Teacher(int id_Teacher) {
		this.id_Teacher = id_Teacher;
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

	@Override
	public String toString() {
		return "Course{" + "id_Course=" + id_Course + ", name_Course='" + name_Course + '\'' + ", code_Curse="
				+ code_Curse + ", id_Teacher=" + id_Teacher + ", credits=" + credits + ", cluster=" + cluster + '}';
	}

}
