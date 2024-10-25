import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Punto> puntos = new ArrayList<>();

        // Leer el archivo CSV
        String csvFile = "/Users/ximenafernandez/Desktop/Machine Learning/KMeans Health care diabetes/health_care_diabetes.csv";
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Saltar la cabecera
            br.readLine();
            System.out.println("Leyendo datos del archivo..."); // Mensaje de depuración
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(csvSplitBy);
                // Asegúrate de convertir los datos a los tipos correctos
                double pregnancies = Double.parseDouble(datos[0]);
                double glucose = Double.parseDouble(datos[1]);
                double bloodPressure = Double.parseDouble(datos[2]);
                double skinThickness = Double.parseDouble(datos[3]);
                double insulin = Double.parseDouble(datos[4]);
                double bmi = Double.parseDouble(datos[5]);
                double diabetesPedigreeFunction = Double.parseDouble(datos[6]);
                double age = Double.parseDouble(datos[7]);

                // Crear un nuevo Punto y añadirlo a la lista
                puntos.add(new Punto(pregnancies, glucose, bloodPressure, skinThickness, insulin, bmi, diabetesPedigreeFunction, age));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Total de puntos cargados: " + puntos.size()); // Total de puntos

        // Crear el clasificador KMeans con un número de clusters deseado (k)
        int k = 2; // Por ejemplo, 2 clusters para clasificar en diabéticos y no diabéticos
        KMeans kMeans = new KMeans(k);
        List<Cluster> clusters = kMeans.clasificar(puntos);

        System.out.println("Clusters creados: " + clusters.size()); // Mensaje sobre los clusters creados

        // Mostrar los resultados
        for (int i = 0; i < clusters.size(); i++) {
            System.out.println("Cluster " + (i + 1) + ": Total de puntos: " + clusters.get(i).getPuntos().size());
            System.out.println("Centroide: " + clusters.get(i).getCentroide());
        }
    }
}