package model;

//import  model.Node;



public class BinarySearchTree {

    Node<Course> root;

    /*
    private int numeroElementos = 0;
    private int numeroBusquedas = 0;
    private int numeroIteracionesTotal = 0;
    private int numeroIteracionesUltimaBusqueda = 0;
    */


    public BinarySearchTree() {
        Node<Course> root = null;
    }

    public void add(Course course) {
        root = addRecursive(root, course);
    }

    private Node<Course> addRecursive(Node<Course> current, Course course) {
        if (current == null) {
            return new Node<>(course);
        }

        if (course.getScore() < current.getValue().getScore()) {
            current.setLeft(addRecursive(current.getLeft(), course));
        } else if (course.getScore() > current.getValue().getScore()) {
            current.setRight(addRecursive(current.getRight(), course));
        } else {
            // value already exists
            return current;
        }

        return current;
    }





}
