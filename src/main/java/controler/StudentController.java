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
		studentActual = new Student(id_student, name_student, mail_student, phone_student);

	}

	public Student getStudent() {
		 return this.studentActual;
	}

	
	public void deleteStudent() {
		studentActual = null;
	}



}
