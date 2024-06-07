package controlerView;

public class CourseDisplay {
    private String cursoVisto;
    private String cursoPorVer;
    private String cursoSiguiente;

    public CourseDisplay(String cursoVisto, String cursoPorVer, String cursoSiguiente) {
        this.cursoVisto = cursoVisto;
        this.cursoPorVer = cursoPorVer;
        this.cursoSiguiente = cursoSiguiente;
    }

    public String getCursoVisto() {
        return cursoVisto;
    }

    public void setCursoVisto(String cursoVisto) {
        this.cursoVisto = cursoVisto;
    }

    public String getCursoPorVer() {
        return cursoPorVer;
    }

    public void setCursoPorVer(String cursoPorVer) {
        this.cursoPorVer = cursoPorVer;
    }

    public String getCursoSiguiente() {
        return cursoSiguiente;
    }

    public void setCursoSiguiente(String cursoSiguiente) {
        this.cursoSiguiente = cursoSiguiente;
    }
}