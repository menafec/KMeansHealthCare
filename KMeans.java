import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KMeans {
    private int k;
    private List<Cluster> clusters;
    private Random random;

    public KMeans(int k) {
        this.k = k;
        this.clusters = new ArrayList<>();
        this.random = new Random();
    }

    public List<Cluster> clasificar(List<Punto> puntos) {
        inicializarClusters(puntos);
        boolean cambios = true;

        while (cambios) {
            for (Cluster cluster : clusters) {
                cluster.getPuntos().clear(); // Limpiar puntos del cluster
            }

            // Clasificar puntos
            for (Punto p : puntos) {
                Cluster clusterCercano = encontrarClusterCercano(p);
                clusterCercano.agregarPunto(p);
            }

            cambios = actualizarCentroides();
        }

        return clusters;
    }

    private void inicializarClusters(List<Punto> puntos) {
        for (int i = 0; i < k; i++) {
            int indiceAleatorio = random.nextInt(puntos.size());
            clusters.add(new Cluster(puntos.get(indiceAleatorio)));
        }
    }

    private Cluster encontrarClusterCercano(Punto p) {
        Cluster clusterCercano = clusters.get(0);
        double menorDistancia = calcularDistancia(p, clusterCercano.getCentroide());

        for (Cluster cluster : clusters) {
            double distancia = calcularDistancia(p, cluster.getCentroide());
            if (distancia < menorDistancia) {
                menorDistancia = distancia;
                clusterCercano = cluster;
            }
        }

        return clusterCercano;
    }

    private boolean actualizarCentroides() {
        boolean cambios = false;

        for (Cluster cluster : clusters) {
            Punto nuevoCentroide = calcularCentroide(cluster.getPuntos());

            if (nuevoCentroide != null && !nuevoCentroide.equals(cluster.getCentroide())) {
                cluster.setCentroide(nuevoCentroide);
                cambios = true;
            }
        }

        return cambios;
    }

    private Punto calcularCentroide(List<Punto> puntos) {
        if (puntos.isEmpty()) return null;

        double sumPregnancies = 0;
        double sumGlucose = 0;
        double sumBloodPressure = 0;
        double sumSkinThickness = 0;
        double sumInsulin = 0;
        double sumBMI = 0;
        double sumDiabetesPedigreeFunction = 0;
        double sumAge = 0;

        for (Punto p : puntos) {
            sumPregnancies += p.getPregnancies();
            sumGlucose += p.getGlucose();
            sumBloodPressure += p.getBloodPressure();
            sumSkinThickness += p.getSkinThickness();
            sumInsulin += p.getInsulin();
            sumBMI += p.getBmi();
            sumDiabetesPedigreeFunction += p.getDiabetesPedigreeFunction();
            sumAge += p.getAge();
        }

        int n = puntos.size();
        return new Punto(sumPregnancies / n, sumGlucose / n, sumBloodPressure / n, sumSkinThickness / n,
                         sumInsulin / n, sumBMI / n, sumDiabetesPedigreeFunction / n, sumAge / n);
    }

    private double calcularDistancia(Punto p1, Punto p2) {
        double distancia = 0;
        distancia += Math.pow(p1.getPregnancies() - p2.getPregnancies(), 2);
        distancia += Math.pow(p1.getGlucose() - p2.getGlucose(), 2);
        distancia += Math.pow(p1.getBloodPressure() - p2.getBloodPressure(), 2);
        distancia += Math.pow(p1.getSkinThickness() - p2.getSkinThickness(), 2);
        distancia += Math.pow(p1.getInsulin() - p2.getInsulin(), 2);
        distancia += Math.pow(p1.getBmi() - p2.getBmi(), 2);
        distancia += Math.pow(p1.getDiabetesPedigreeFunction() - p2.getDiabetesPedigreeFunction(), 2);
        distancia += Math.pow(p1.getAge() - p2.getAge(), 2);
        return Math.sqrt(distancia);
    }
}