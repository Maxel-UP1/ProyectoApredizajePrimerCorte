package controler;

import java.util.LinkedList;
import java.util.List;

import model.Student;

public class StudentController {

	private Student studentActual;

	 public StudentController() {
		studentActual = new Student();
	}


	
	public void createStudent(int id_student, String name_student, String mail_student, int phone_student  ) {
		studentActual.setId_student(id_student);
		studentActual.setName_student(name_student);
		studentActual.setMail_student(mail_student);
		studentActual.setPhone_student(phone_student);

	}
	
	
	public void deleteStudent() {
		studentActual = null;
	}



}
