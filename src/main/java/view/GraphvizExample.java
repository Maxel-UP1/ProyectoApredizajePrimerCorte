package view;

import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.model.MutableGraph;
import guru.nidi.graphviz.parse.Parser;

import java.io.File;
import java.io.IOException;

public class GraphvizExample {
    public static void main(String[] args) {
        String dotContent = "digraph G {\n" +
                "    node [shape=circle];\n" +
                "    node [style=filled];\n" +
                "    node [fillcolor=\"#EEEEEE\"];\n" +
                "    node [color=\"#8C8C8C\"];\n" +
                "    edge [color=\"#31CEF0\"];\n" +
                "    CalculusIV -> Precalculus -> CalculusII -> CalculusIII;\n" +
                "    CalculusIV -> NumericalMethods -> CalculusI;\n" +
                "}\n";
        try {
            // Crear una instancia de Parser
            Parser parser = new Parser();

            // Parsear el contenido DOT
            MutableGraph g = parser.read(dotContent);

            // Renderizar el gráfico a un archivo PNG
            Graphviz.fromGraph(g).width(800).render(Format.PNG).toFile(new File("graph.png"));
            System.out.println("Imagen generada con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

