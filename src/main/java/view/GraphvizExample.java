package view;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.model.MutableGraph;
import guru.nidi.graphviz.parse.Parser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GraphvizExample {
    public static void main(String[] args) {
        String dotContent34 = "digraph G {\n" +
                "node [shape=circle];\n" +
                "node [style=filled];\n" +
                "node [fillcolor=\"#EEEEEE\"];\n" +
                "node [color=\"#8C8C8C\"];\n" +
                "edge [color=\"#31CEF0\"];\n" +
                "CalculusIII -> Precalculus -> CalculusI -> CalculusII\n" +
                "CalculusIII -> CalculusIV -> NumericalMethods\n" +
                "}\n";
        System.out.println(dotContent34);

        // Ruta del archivo DOT
        String filePath = "G:/Ingeniería/5- Quinto Semestre 2024-I/Programación III/PROYECTO FINAL/Proyecto Aprendizaje/ProyectoApredizajePrimerCorte/src/main/java/persistence/graph.dot";

        String dotContent = "";
        try {
            // Leer el contenido del archivo DOT
            dotContent = new String(Files.readAllBytes(Paths.get(filePath)));

            // Imprimir el contenido del archivo DOT
            System.out.println("Contenido del archivo DOT:");
            System.out.println(dotContent);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            // Crear una instancia de Parser
            Parser parser = new Parser();

            // Parsear el contenido DOT
            MutableGraph g = parser.read(dotContent);

            // Renderizar el gráfico a un archivo PNG
            String outputFilePath = "G:/Ingeniería/5- Quinto Semestre 2024-I/Programación III/PROYECTO FINAL/Proyecto Aprendizaje/ProyectoApredizajePrimerCorte/src/main/resources/TreeGeneratedGraph/graph5.png";
            Graphviz.fromGraph(g).width(800).render(Format.PNG).toFile(new File(outputFilePath));
            System.out.println("Imagen generada con éxito en: " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

