package controler;

import java.util.LinkedList;
import java.util.List;

import model.Student;

public class StudentController {

	private List<Student> student_controler;

	 public StudentController() {
		student_controler = new LinkedList<Student>();
	}


	
	public boolean addStudent(Student student) {
		boolean auxStudent = student_controler.add(student);
		return auxStudent;
	}
	
	
	public Student deleteStudent(Student student) {
		Student auxStudent = null;
		for (int i = 0; i > student_controler.size(); i++) {
			if(student_controler.get(i).getId_student()==student.getId_student()) {
				auxStudent=student_controler.remove(i);
			}
		}
		return auxStudent;
	}
	
}
