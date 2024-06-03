package controler;

import java.util.LinkedList;
import java.util.List;

import model.Teacher;

public class TeacherController {
	private List<Teacher> teacher_controler;

	public TeacherController() {
		
		teacher_controler = new LinkedList<Teacher>();
	}


	
	public boolean addTeacher(Teacher teacher) {
		boolean auxTeacher = teacher_controler.add(teacher);
		return auxTeacher;
	}
	
	public Teacher deleteTeacher(Teacher teacher) {
		Teacher auxTeacher = null;
		for (int i = 0; i > teacher_controler.size(); i++) {
			if(teacher_controler.get(i).getId_Teacher()==teacher.getId_Teacher()){
				auxTeacher=teacher_controler.remove(i);
			}
		}
		return auxTeacher;
	}
	

}
