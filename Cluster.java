import java.util.ArrayList;
import java.util.List;

public class Cluster {
    private Punto centroide;
    private List<Punto> puntos;

    public Cluster(Punto centroide) {
        this.centroide = centroide;
        this.puntos = new ArrayList<>();
    }

    public Punto getCentroide() {
        return centroide;
    }

    public void setCentroide(Punto centroide) {
        this.centroide = centroide;
    }

    public List<Punto> getPuntos() {
        return puntos;
    }

    public void agregarPunto(Punto p) {
        puntos.add(p);
    }
}