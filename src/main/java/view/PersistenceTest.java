package view;

import controler.CourseController;

import java.util.Scanner;

public class PersistenceTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CourseController courseController = new CourseController();

        if (courseController.getCourseList().isEmpty()){
            System.out.println("Esta Vacia");
        }
        //prueba de persistencia
        courseController.loadCoursesReadFile("courses");

        for (int i = 0; i < courseController.getCourseList().size(); i++) {
            System.out.println(courseController.getCourseList().get(i).toString());
        }

        //lectura  Funciona con normalidad

        System.out.println("Agregando un curso");
        courseController.addCourse(100, "PRUEBA", 101, 3, 1, 5, "DDD de matematicas", "Ciencias Exactas");

        courseController.loadCoursesReadFile("courses");

        for (int i = 0; i < courseController.getCourseList().size(); i++) {
            System.out.println(courseController.getCourseList().get(i).toString());
        }

        //Escritura funcioan con normalidad

        System.out.println("Eliminando un curso");

        sc.next();

        courseController.deleteCourseById(100);
        //Agregagar y Eliminar curso funciona con normalidad.


        //Prueba, modificar informacion de un curso
        System.out.println("MODIFCAR INFORMACION DE UN CURSO");
        courseController.addCourse(100, "PRUEBA", 101, 3, 1, 5, "DDD de matematicas", "Ciencias Exactas");
        for (int i = 0; i < courseController.getCourseList().size(); i++) {
            System.out.println(courseController.getCourseList().get(i).toString());
        }

        System.out.println("Ingrese el nuevo nombre");
        String name = sc.next();
        System.out.println("Ingrese el nuevo codigo");
        int code = sc.nextInt();
        System.out.println("Ingrese los nuevos creditos");
        int credits = sc.nextInt();
        System.out.println("Ingrese el nuevo cluster");
        int cluster = sc.nextInt();
        System.out.println("Ingrese el nuevo score");
        int score = sc.nextInt();
        System.out.println("Ingrese la nueva descripcion");
        String description = sc.next();
        System.out.println("Ingrese la nueva ciencia");
        String science = sc.next();

        courseController.updateCourseById(100, name, code, credits, cluster, score, description, science);
        System.out.println("IMPRESION MODIFCADAN \n");

        for (int i = 0; i < courseController.getCourseList().size(); i++) {
            System.out.println(courseController.getCourseList().get(i).toString());
        }





    }



}