package model;

public class Student {

	private int id_student;
	private String name_student;
	private String mail_student;
	private int phone_student;
	private String address_student;
	
	public Student(){
	super();
	}

	public Student(int id_student, String name_student, String mail_student, int phone_student,
			String address_student) {
		this.id_student = id_student;
		this.name_student = name_student;
		this.mail_student = mail_student;
		this.phone_student = phone_student;
		this.address_student = address_student;
	}

	public int getId_student() {
		return id_student;
	}

	public void setId_student(int id_student) {
		this.id_student = id_student;
	}

	public String getName_student() {
		return name_student;
	}

	public void setName_student(String name_student) {
		this.name_student = name_student;
	}

	public String getMail_student() {
		return mail_student;
	}

	public void setMail_student(String mail_student) {
		this.mail_student = mail_student;
	}

	public int getPhone_student() {
		return phone_student;
	}

	public void setPhone_student(int phone_student) {
		this.phone_student = phone_student;
	}

	public String getAddress_student() {
		return address_student;
	}

	public void setAddress_student(String address_student) {
		this.address_student = address_student;
	}

	@Override
	public String toString() {
		return "Student{" + "id_student=" + id_student + ", name_student='" + name_student + '\'' + ", mail_student='"
				+ mail_student + '\'' + ", phone_student=" + phone_student + ", address_student='" + address_student
				+ '\'' + '}';
	}

}
