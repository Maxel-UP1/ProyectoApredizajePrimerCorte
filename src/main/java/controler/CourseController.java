package controler;

import model.Course;

import java.util.ArrayList;

public class CourseController {

    private ArrayList<Course> courseList;

    public CourseController() {
        courseList = new ArrayList<>();
    }

    // Cursos precargados en memoria
    public void loadCourses() {
        // Calculus Courses
        addCourse(1, "Precalculus", 100, 3, 1, 1, "This course covers the basic concepts of algebra and trigonometry needed for calculus.", "MATH");
        addCourse(2, "Calculus I", 101, 4, 1, 2, "This course introduces the concepts of limits, derivatives, and integrals.","MATH");
        addCourse(3, "Calculus II", 102, 4, 2, 3, "This course covers techniques of integration, infinite series, and basic differential equations.","MATH");
        addCourse(4, "Calculus III", 103, 4, 3, 4, "This course includes multivariable calculus, multiple integrals, and vector theorems.","MATH");
        addCourse(5, "Calculus IV", 401, 4, 4, 5, "This course addresses advanced topics in calculus, such as Fourier analysis and partial differential equations.","MATH");
        addCourse(6, "Numerical Methods", 402, 4, 6, 90, "This course teaches numerical techniques for solving equations and calculus problems.","MATH");

        // Programming Courses
        addCourse(7, "Introduction to Programming", 200, 3, 1, 1, "Basic programming concepts using an easy-to-learn programming language.", "PROGRAMMING");
        addCourse(8, "Programming Fundamentals", 201, 3, 1, 2, "Introduction to programming logic and basic algorithms.","PROGRAMMING");
        addCourse(9, "Object-Oriented Programming", 202, 4, 2, 3, "Programming using object-oriented concepts.","PROGRAMMING");
        addCourse(10, "Data Structures", 203, 4, 2, 4, "Study of fundamental data structures and their applications.","PROGRAMMING");
        addCourse(11, "Web Application Development", 204, 4, 3, 5, "Development of web applications using modern technologies.","PROGRAMMING");
        addCourse(12, "Artificial Intelligence", 205, 4, 3, 6, "Introduction to concepts and techniques of artificial intelligence.","PROGRAMMING");
    }

    public void addCourse(int id_Course, String name_Course, int code_Curse, int credits, int cluster, int score, String description, String science) {
        Course course = new Course(id_Course, name_Course, code_Curse, credits, cluster, score, description, science);
        courseList.add(course);
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }
}
