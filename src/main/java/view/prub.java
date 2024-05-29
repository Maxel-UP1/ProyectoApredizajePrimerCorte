package view;
import model.BinarySearchTree;
import model.Course;

public class prub {
    public static void main(String[] args) {
        //el arbol funciona, los elementos con mayor valor se encuentran a la derecha
        // y por ende se imprimen de ultimas
        Course c1 = new Course(01, "Samuel", 20, 3, 1, 6);
        Course c2 = new Course(02, "Jaime", 25, 3, 1, 5);
        Course c3 = new Course(03, "Sonia", 45, 3, 1, 8);
        Course c4 = new Course(04, "Messi", 50, 3, 1, 3);


        BinarySearchTree tree = new BinarySearchTree();


        tree.add(c1);
        tree.add(c2);
        tree.add(c3);
        tree.add(c4);

        System.out.println(tree.inorder());

        //System.out.println(tree.preOrder());}
    }

}
