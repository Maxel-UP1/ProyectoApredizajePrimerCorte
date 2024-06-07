package persistence;

import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.MutableGraph;
import guru.nidi.graphviz.parse.Parser;
import model.BinarySearchTree;
import utilities.Utilities;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileStorageUtilities {

    private static final String FILEPATH = "src/main/java/persistence/";
    private static final String EXTENSION = ".dot";
    private static final String FILEPATHTREE = "src/resources/TreeGeneratedGraph/";
    private static final String EXTENSIONTREE = ".png";
    private Utilities utilities = new Utilities();

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


    //recibe el nombre del archivo y el arbol para escribir el archivo dot
    public void writeGrapht(String fileName, BinarySearchTree tree) {
        try {
            writeFile(fileName, tree.getCodeGraphviz());
            //hola es el nombre del archivo
            ProcessBuilder proces = new ProcessBuilder("dot", "-Tpng", "-o", "arbol.png", FILEPATH + "ABEL123" + EXTENSION);
            //ProcessBuilder proces = new ProcessBuilder("dot", "-Tpng", FILEPATH + "graph" + EXTENSION, "-o", FILEPATH + "graph.png");
            proces.redirectErrorStream(true);
            proces.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //retorna los valores del archivo dot
    public String readDotFile(String fileName) {
        // Ruta del archivo DOT
        String filePath = FILEPATH + fileName + EXTENSION;
        String dotContent = "";
        try {
            // Leer el contenido del archivo DOT
            dotContent = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dotContent;
    }
    //Segun lo leido en readDotFile grafica el arbol.
    public String drawGrapht(String dotContent){
        try {
            // Crear una instancia de Parser
            Parser parser = new Parser();

            // Parsear el contenido DOT
            MutableGraph g = parser.read(dotContent);

            // Renderizar el gráfico a un archivo PNG
            String outputFilePath = FILEPATHTREE + utilities.generateUniqueFilename() + EXTENSIONTREE;
            Graphviz.fromGraph(g).width(900).render(Format.PNG).toFile(new File(outputFilePath));
            return "Imagen generada con éxito ";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Error al generar la imagen";
    }



}

