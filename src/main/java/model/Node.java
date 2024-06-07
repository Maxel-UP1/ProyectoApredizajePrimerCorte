package model;
public class Node<V> {

    private V value;
    private Node<V> izq;
    private Node<V> der;

    public Node(V value, Node<V> izq, Node<V> der) {
        super();
        this.value = value;
        this.izq = izq;
        this.der = der;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node<V> getIzq() {
        return izq;
    }

    public void setIzq(Node<V> izq) {
        this.izq = izq;
    }

    public Node<V> getDer() {
        return der;
    }

    public void setDer(Node<V> der) {
        this.der = der;
    }
}
