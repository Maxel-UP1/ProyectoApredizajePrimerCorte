package controler;

import com.google.gson.reflect.TypeToken;
import model.Course;
import persistence.JsonStorageUtilities;

import java.lang.reflect.Type;
import java.util.*;

public class CourseController {


    private JsonStorageUtilities jsonStorageUtilities;
    private ArrayList<Course> courseList;

    private static  final Type COUSERTYPE   = new TypeToken<List<Course>>(){}.getType();

    public CourseController() {
        courseList = new ArrayList<>();
        jsonStorageUtilities = new JsonStorageUtilities();
    }


    // metodo de carga creditos a los cursosssss////////////////////////////////////////////
    // Método para asignar créditos a una lista de cursos combinando score e interés y evitando repeticiones por science
    public void assignCredits() {
        HashMap<String, HashSet<Integer>> assignedCredits = new HashMap<>();

        for (Course course : courseList) {
            String science = course.getScience();
            int score = course.getScore();
            int interest = course.getInterest();
            int credits = calculateCredits(score, interest, assignedCredits.getOrDefault(science, new HashSet<>()));

            // Ensure no duplicate credits within the same science
            while (assignedCredits.getOrDefault(science, new HashSet<>()).contains(credits)) {
                credits++;
            }

            course.setCredits(credits);
            writeFile("courses");

            assignedCredits.computeIfAbsent(science, k -> new HashSet<>()).add(credits);
        }
    }


    public void modifyCourseByCourse(Course course, int interes) {
        for (Course coourse : courseList) {
            if (coourse.getId() == course.getId()) {
                coourse.setInterest(interes);
                writeFile("courses");
                break;
            }
        }

    }




    private int calculateCredits(int score, int interest, HashSet<Integer> existingCredits) {
        // Base credits influenced by both score and interest
        int baseCredits = score * 2;  // Higher score gives a higher base

        // Adjust credits more significantly based on interest
        int adjustment = 0;
        if (interest == 5) {
            adjustment = -5; // High interest, decrease credits significantly
        } else if (interest == 3) {
            adjustment = -2;  // Medium interest, no adjustment
        } else if (interest == 1) {
            adjustment = 5;  // Low interest, increase credits significantly
        }

        int credits = baseCredits + adjustment;

        // Adjust if already assigned, ensuring we cover a broader range
        while (existingCredits.contains(credits)) {
            credits++;
        }

        return credits;
}
    /////
    // Cursos precargados en memoria
    public void loadCoursesReadFile(String nameFile) {

        List<Course> coursesList = jsonStorageUtilities.readContentFromFile(nameFile , COUSERTYPE);
        //Convertir la lista de cursos  a un ArrayList<Course>, nuevo array poruqe se llama una vez
        this.courseList = new ArrayList<>(coursesList);


    }

    public void readCourses(String nameFile) {
        List<Course> coursesList = jsonStorageUtilities.readContentFromFile(nameFile , COUSERTYPE);
        this.courseList = (java.util.ArrayList<Course>) coursesList;
    }

    public void writeFileReading(String nameFile, Course course){
        List<Course> courseListTEMP = jsonStorageUtilities.readContentFromFile(nameFile , COUSERTYPE);
        courseListTEMP.add(course);
        jsonStorageUtilities.saveDataToFile(courseListTEMP, nameFile, COUSERTYPE);

    }



    public void addCourse(int id_Course, String name_Course, int code_Curse, int credits, int cluster, int score, String description, String science) {
        Course course = new Course(id_Course, name_Course, code_Curse, credits, cluster, score, description, science);
        writeFileReading("courses", course);

    }
    public String addCourseByView(int id_Course, String name_Course,  int credits,  int score, String description, String science){
        Course course = new Course(id_Course, name_Course, science, description, credits, score);
        writeFileReading("courses", course);
        return  course.toString();

    }

    public void deleteCourseById(int id_Course) {
        List<Course> courseListTEMP = jsonStorageUtilities.readContentFromFile("courses" , COUSERTYPE);
        for (Course course : courseListTEMP) {
            if (course.getId() == id_Course) {
                courseListTEMP.remove(course);
                break;
            }
        }
        //elimina, luego escribe en el archivo
        jsonStorageUtilities.saveDataToFile(courseListTEMP, "courses", COUSERTYPE);
    }

    public  void deleteCourseByName(String name_Course){
        List<Course> courseListTEMP = jsonStorageUtilities.readContentFromFile("courses" , COUSERTYPE);
        for (Course course : courseListTEMP) {
            if (course.getName().equalsIgnoreCase(name_Course)) {
                courseListTEMP.remove(course);
                break;
            }
        }
        //elimina, luego escribe en el archivo
        jsonStorageUtilities.saveDataToFile(courseListTEMP, "courses", COUSERTYPE);
    }

    public void updateCourseById(int id_Course, String name_Course, int code_Curse, int credits, int cluster, int score, String description, String science) {
        List<Course> courseListTEMP = jsonStorageUtilities.readContentFromFile("courses" , COUSERTYPE);
        for (Course course : courseListTEMP) {
            if (course.getId() == id_Course) {
                course.setName(name_Course);
                course.setCode(code_Curse);
                course.setCredits(credits);
                course.setCluster(cluster);
                course.setScore(score);
                course.setDescription(description);
                course.setScience(science);
                break;
            }
        }
        //actualiza, luego escribe en el archivo
        jsonStorageUtilities.saveDataToFile(courseListTEMP, "courses", COUSERTYPE);
    }


    public ArrayList<Course> getCourseList() {
        readCourses("courses");
        return courseList;
    }

    public void setCourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }

    public boolean validaNameCourse(String nameValidate){
        List<Course> courseListTEMP = jsonStorageUtilities.readContentFromFile("courses" , COUSERTYPE);
        for (Course course : courseListTEMP) {
            if (course.getName().equalsIgnoreCase(nameValidate)){
                //el nombre es igual
                return true;
            }
        }
        return false;

    }

    public boolean validaIdCourse(int idValidate){
        for (Course course : courseList) {
            if (course.getId() == idValidate){
                //el ID es igual
                return true;
            }
        }
        return false;
    }

    public void writeFile(String nameFile){

        jsonStorageUtilities.saveDataToFile(courseList, nameFile, COUSERTYPE);
    }

}
