# Proyecto K-Means: Clasificación de Diabetes

**Autor:** Ximena Carolina Fernandez Cardenas  
**Materia:** Machine Learning  
**Fecha:** Octubre 2024

## Descripción

Este proyecto implementa el algoritmo de K-Means para clasificar datos relacionados con la diabetes. Utiliza un conjunto de datos que incluye diferentes características de pacientes para identificar grupos (clusters) de personas con diferentes niveles de riesgo de diabetes.

## Objetivos

- Implementar el algoritmo K-Means para la clasificación de datos.
- Leer un conjunto de datos de un archivo CSV.
- Agrupar puntos en clusters y calcular los centroides de cada cluster.
- Proporcionar una salida que indique el número de puntos en cada cluster y sus centroides.

## Requisitos

- **Java 8 o superior**: Asegúrate de tener instalado Java en tu máquina.
- **Editor de texto o IDE**: Puedes usar cualquier editor de texto o un IDE como IntelliJ IDEA o Eclipse.

## Estructura del Proyecto

El proyecto está organizado en los siguientes archivos:

- **Main.java**: Clase principal que contiene el punto de entrada del programa y maneja la lectura de datos desde un archivo CSV.
- **KMeans.java**: Implementación del algoritmo K-Means.
- **Punto.java**: Clase que representa un punto en el espacio multidimensional, con atributos como embarazos, glucosa, presión arterial, etc.
- **Cluster.java**: Clase que representa un cluster y su centroide.

## Uso

1. Clona el repositorio en tu máquina local.
2. Abre el proyecto en tu IDE o editor de texto.
3. Asegúrate de que el archivo CSV (`health_care_diabetes.csv`) esté en la ubicación correcta.
4. Compila el proyecto:

   ```bash
   javac Main.java KMeans.java Punto.java Cluster.java

## Resultados

El programa leerá los datos del archivo y mostrará:

	•	El número total de puntos cargados.
	•	El número de clusters creados.
	•	Detalles de cada cluster, incluyendo la cantidad de puntos y sus centroides.
