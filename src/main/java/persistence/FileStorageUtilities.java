package persistence;

import model.BinarySearchTree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileStorageUtilities {

    private static final String FILEPATH = "src/main/java/persistence/";
    private static final String EXTENSION = ".dot";

    public void writeFile(String fileName, String content) {
        FileWriter ficher = null;
        PrintWriter pw = null;

        try {
            //revisr lo del append
            ficher = new FileWriter(FILEPATH + fileName + EXTENSION);
            pw = new PrintWriter(ficher);
            pw.write(content);
            pw.close();
            ficher.close();




        }catch (IOException e) {
            e.printStackTrace();

        }finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    public void drawGrapht(BinarySearchTree tree) {
        try {
            writeFile("graph", tree.getCodeGraphviz());
            //hola es el nombre del archivo
            ProcessBuilder proces = new ProcessBuilder("dot", "-Tpng", "-o", "arbol.png", FILEPATH + "ABEL123" + EXTENSION);
            //ProcessBuilder proces = new ProcessBuilder("dot", "-Tpng", FILEPATH + "graph" + EXTENSION, "-o", FILEPATH + "graph.png");
            proces.redirectErrorStream(true);
            proces.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*
    public static void writeFile(String filePath, String content) {
        // Utiliza try-with-resources para asegurar el cierre de los recursos
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
            writer.newLine();  // Agrega una nueva línea si deseas escribir más contenido después
            System.out.println("Contenido agregado al archivo con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/


}

