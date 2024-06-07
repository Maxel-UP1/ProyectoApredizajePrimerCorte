package model;
import java.util.ArrayList;

public class BinarySearchTree<V extends Comparable<V>> {

    Node<V> raiz = null;
    private int numeroElementos = 0;
    private int numeroBusquedas = 0;
    private int numeroIteracionesTotal = 0;
    private int numeroIteracionesUltimaBusqueda = 0;

    public BinarySearchTree() {

    }

    public void insertarElemento(V value) {
        Node<V> nuevoNodo = new Node<V>(value, null, null);

        if (raiz == null) {
            raiz = nuevoNodo;
            System.out.println("Inserto la raiz");
        } else {
            // Necesitamos encontrar en que posición debemos insertar el nodo
            Node<V> aux = raiz;

            while (aux != null) {
                // Comprobamos si tenemos que insertarlo ya
                // Comprobamos si nodo hoja
                if (aux.getDer() == null && aux.getIzq() == null) {
                    if (value.compare(aux.getValue()) == 1) {
                        // Derecha
                        System.out.println(value + " Lo insertamos a la derecha de: " + aux.getValue());
                        aux.setDer(nuevoNodo);
                        aux = null;
                    } else {
                        // Izquierda
                        System.out.println(value + " Lo insertamos a la izquierda de: " + aux.getValue());
                        aux.setIzq(nuevoNodo);
                        aux = null;
                    }
                } else if (value.compare(aux.getValue()) == 1 && aux.getDer() == null) {
                    // Lo insertamos a la derecha
                    System.out.println(value + " Lo insertamos a la derecha de: " + aux.getValue());
                    aux.setDer(nuevoNodo);
                    aux = null;
                } else if (value.compare(aux.getValue()) == -1 && aux.getIzq() == null) {
                    // Lo insertamos a la izquierda
                    System.out.println(value + " Lo insertamos a la izquierda de: " + aux.getValue());
                    aux.setIzq(nuevoNodo);
                    aux = null;
                } else {
                    // Pasamos de nodo
                    if (value.compare(aux.getValue()) == 1) {
                        aux = aux.getDer();
                    } else {
                        aux = aux.getIzq();
                    }
                }

            }

        }

        // Incrementamos el número de elementos en 1
        numeroElementos++;
    }

    public V buscarElemento(V value) {
        Node<V> aux = raiz;
        Node<V> resultado = null;
        numeroIteracionesUltimaBusqueda = 0;

        while (aux != null) {
            // Comprobamos si es el valor
            if (value.compare(aux.getValue()) == 0) {
                // Hemos encontrado el elemento
                resultado = aux;
                aux = null;
            } else if (aux.getDer() == null && aux.getIzq() == null) {
                // Si hemos llegado a un nodo hoja el elemento no está en el ABB
                // El elemento no está
                aux = null;
            } else if (value.compare(aux.getValue()) == 1 && aux.getDer() != null) {
                // Si el valor es mayor y tenemos nodo a la derecha, vamos a la derecha
                aux = aux.getDer();
            } else if (value.compare(aux.getValue()) == -1 && aux.getIzq() != null) {
                // Si el valor es menos y tenemos nodo a la izquierda, vamos a la izquierda
                aux = aux.getIzq();
            } else {
                // Si el nodo es mayor y no tenemos nodo a la derecha o es menor y no tenemos
                // nodo a la izquierda
                // El elemento no está
                aux = null;
            }

            numeroIteracionesUltimaBusqueda++;
        }

        numeroIteracionesTotal += numeroIteracionesUltimaBusqueda;
        numeroBusquedas++;

        if (resultado != null) {
            return resultado.getValue();
        }else {
            return null;
        }
    }

    public boolean eliminarElemento(V value) {
        boolean resultado = false;
        Node<V> aux = raiz;

        while (aux != null) {
            // Si es la raiz
            if (aux.getValue().compare(value) == 0) {
                Node<V> nodoAEliminar = aux;

                if (aux.getDer() != null) {
                    raiz = aux.getDer();
                    if (nodoAEliminar.getIzq() != null) {
                        insertarNodo(nodoAEliminar.getIzq());
                        nodoAEliminar.setIzq(null);
                        nodoAEliminar.setDer(null);
                    }
                } else if (aux.getIzq() != null) {
                    raiz = aux.getIzq();
                    if (nodoAEliminar.getDer() != null) {
                        insertarNodo(nodoAEliminar.getDer());
                        nodoAEliminar.setIzq(null);
                        nodoAEliminar.setDer(null);
                    }
                } else {
                    raiz = null;
                }

                resultado = true;
                aux = null;
            } else if (aux.getIzq() != null && aux.getIzq().getValue().compare(value) == 0) {
                Node<V> nodoAEliminar = aux.getIzq();
                // Si el valor está a la izquierda del nodo que estamos recorriendo
                // Miramos si tenemos izquierda en el nodo a eliminar

                if (aux.getIzq().getIzq() != null) {
                    // Tenemos Nodo a la izquierda
                    // Apuntamos el nodo que estamos recorriendo al siguiente del nodo a eliminar
                    aux.setIzq(aux.getIzq().getIzq());
                    // Reposicionamos sus hijos
                    if (nodoAEliminar.getDer() != null) {
                        insertarNodo(nodoAEliminar.getDer());
                    }
                    nodoAEliminar.setDer(null);
                    nodoAEliminar.setIzq(null);
                    resultado = true;
                    aux = null;
                } else {
                    // No tenemos nodo a la izquierda del elemento a eliminar
                    // Miramos si es nodo hoja

                    if (aux.getIzq() == null && aux.getDer() == null) {
                        aux.setIzq(null);
                    } else {
                        aux.setIzq(null);
                        if (nodoAEliminar.getDer() != null) {
                            insertarNodo(nodoAEliminar.getDer());
                        }
                    }

                    resultado = true;
                    aux = null;
                }

            } else if (aux.getDer() != null && aux.getDer().getValue().compare(value) == 0) {
                Node<V> nodoAEliminar = aux.getDer();
                // Si el valor está a la derecha del nodo que estamos recorriendo
                // Miramos si tenemos derecha en el nodo a eliminar

                if (aux.getDer().getDer() != null) {
                    // Tenemos Nodo a la izquierda
                    // Apuntamos el nodo que estamos recorriendo al siguiente del nodo a eliminar
                    aux.setDer(aux.getDer().getDer());
                    // Reposicionamos sus hijos
                    if (nodoAEliminar.getIzq() != null) {
                        insertarNodo(nodoAEliminar.getIzq());
                    }
                    nodoAEliminar.setDer(null);
                    nodoAEliminar.setIzq(null);
                    resultado = true;
                    aux = null;
                } else {
                    // No tenemos nodo a la izquierda del elemento a eliminar
                    // Miramos si es nodo hoja

                    if (aux.getIzq().getIzq() == null && aux.getDer().getDer() == null) {
                        aux.setDer(null);
                    } else {
                        aux.setDer(null);
                        if (nodoAEliminar.getIzq() != null) {
                            insertarNodo(nodoAEliminar.getIzq());
                        }

                    }

                    resultado = true;
                    aux = null;
                }
            } else {
                if (value.compare(aux.getValue()) == 1) {
                    aux = aux.getDer();
                } else {
                    aux = aux.getIzq();
                }
            }
        }

        // En caso de borrar el nodo disminuimos la cantidad de nodos en 1
        if (resultado) {
            numeroElementos--;
        }

        return resultado;

    }

    private void insertarNodo(Node<V> nodo) {
        if (raiz == null) {
            raiz = nodo;
            System.out.println("Inserto la raiz");
        } else {
            // Necesitamos encontrar en que posición debemos insertar el nodo
            Node<V> aux = raiz;

            while (aux != null) {
                // Comprobamos si tenemos que insertarlo ya
                // Comprobamos si nodo hoja
                if (aux.getDer() == null && aux.getIzq() == null) {
                    if (nodo.getValue().compare(aux.getValue()) == 1) {
                        // Derecha
                        System.out.println(nodo.getValue() + " Lo insertamos a la derecha de: " + aux.getValue());
                        aux.setDer(nodo);
                        aux = null;
                    } else {
                        // Izquierda
                        System.out.println(nodo.getValue() + " Lo insertamos a la izquierda de: " + aux.getValue());
                        aux.setIzq(nodo);
                        aux = null;
                    }
                } else if (nodo.getValue().compare(aux.getValue()) == 1 && aux.getDer() == null) {
                    // Lo insertamos a la derecha
                    System.out.println(nodo.getValue() + " Lo insertamos a la derecha de: " + aux.getValue());
                    aux.setDer(nodo);
                    aux = null;
                } else if (nodo.getValue().compare(aux.getValue()) == -1 && aux.getIzq() == null) {
                    // Lo insertamos a la izquierda
                    System.out.println(nodo.getValue() + " Lo insertamos a la izquierda de: " + aux.getValue());
                    aux.setIzq(nodo);
                    aux = null;
                } else {
                    // Pasamos de nodo
                    if (nodo.getValue().compare(aux.getValue()) == 1) {
                        aux = aux.getDer();
                    } else {
                        aux = aux.getIzq();
                    }
                }

            }
        }
    }

    public int size() {
        return this.numeroElementos;
    }

    public int getNumeroIteracionesMedioEnBusquedas() {
        return (int) Math.ceil(numeroIteracionesTotal / (double) this.numeroBusquedas);
    }

    public int getNumeroIteracionesUltimaBusqueda() {
        return this.numeroIteracionesUltimaBusqueda;
    }

    public ArrayList<V> obtenerElementosOrdenadosAscendentemente() {
        ArrayList<V> elementosOrdenados = new ArrayList<>();
        recorrerAscendente(raiz, elementosOrdenados);
        return elementosOrdenados;
    }

    public ArrayList<V> obtenerElementosOrdenadosDescendentemente() {
        ArrayList<V> elementosOrdenados = new ArrayList<>();
        recorrerDescendente(raiz, elementosOrdenados);
        return elementosOrdenados;
    }

    private void recorrerAscendente(Node<V> nodo, ArrayList<V> elementos) {
        if (nodo != null) {
            if (nodo.getIzq() == null && nodo.getDer() == null) {
                elementos.add(nodo.getValue());
            } else {
                recorrerAscendente(nodo.getIzq(), elementos);
                elementos.add(nodo.getValue());
                recorrerAscendente(nodo.getDer(), elementos);
            }
        }

    }

    private void recorrerDescendente(Node<V> nodo, ArrayList<V> elementos) {
        if (nodo != null) {
            if (nodo.getIzq() == null && nodo.getDer() == null) {
                elementos.add(nodo.getValue());
            } else {
                recorrerDescendente(nodo.getDer(), elementos);
                elementos.add(nodo.getValue());
                recorrerDescendente(nodo.getIzq(), elementos);
            }
        }

    }

    public String getCodeGraphviz() {
        String text = "digraph G {\n"
                //+ "{\n"
                +"node [shape=circle];\n"
                + "node [style=filled];\n"
                + "node [fillcolor=\"#EEEEEE\"];\n"
                + "node [color=\"#8C8C8C\"];\n"
                + "edge [color=\"#31CEF0\"];\n";
        if (raiz != null) {
            text += raiz.textGraphviz();
        }
        text += "\n}";
        return text;

    }



    public void prettyPrint() {
        ArrayList<ArrayList<String>> lines = new ArrayList<>();
        ArrayList<Node> level = new ArrayList<>();
        ArrayList<Node> next = new ArrayList<>();

        level.add(raiz);
        int nn = 1;

        int widest = 0;

        while (nn != 0) {
            ArrayList<String> line = new ArrayList<>();
            nn = 0;

            for (Node n : level) {
                if (n == null) {
                    line.add(null);
                    next.add(null);
                    next.add(null);
                } else {
                    String aa = n.getValue().toString();
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();

                    next.add(n.getIzq());
                    next.add(n.getDer());

                    if (n.getIzq() != null) nn++;
                    if (n.getDer() != null) nn++;
                }
            }

            if (widest % 2 == 1) widest++;

            lines.add(line);

            ArrayList<Node> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perpiece = lines.get(lines.size() - 1).size() * (widest + 1);
        for (int i = 0; i < lines.size(); i++) {
            ArrayList<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {
                    // split node
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '┴' : '┘';
                        } else {
                            if (j < line.size() && line.get(j) != null) c = '└';
                        }
                    }
                    System.out.print(c);

                    // lines and spaces
                    if (line.get(j) == null) {
                        for (int k = 0; k < perpiece - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? " " : "─");
                        }
                        System.out.print(j % 2 == 0 ? "┌" : "┐");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "─" : " ");
                        }
                    }
                }
                System.out.println();
            }

            for (int j = 0; j < line.size(); j++) {
                String f = line.get(j);
                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

                // a number
                for (int k = 0; k < gap1; k++) {
                    System.out.print(" ");
                }
                System.out.print(f);
                for (int k = 0; k < gap2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            perpiece /= 2;
        }
    }
}
