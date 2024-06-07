package model;

public class Student {

	private int id;
	private String name;
	private String mail;
	private int phone;
	
	public Student(){
	}

	public Student(int id, String name, String mail, int phone) {
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.phone = phone;

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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Student{" + "id_student=" + id + ", name_student='" + name + '\'' + ", mail_student='"
				+ mail + '\'' + ", phone_student=" + phone
				+ '\'' + '}';
	}


}
