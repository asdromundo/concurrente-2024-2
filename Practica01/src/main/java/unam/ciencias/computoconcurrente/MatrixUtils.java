package unam.ciencias.computoconcurrente;

import java.util.ArrayList;
import java.util.List;

public class MatrixUtils implements Runnable {
    private int threads;
    private double promedioSegmento;
    private int[] matrizDividida;
    private static List<Double> resultados;

    public MatrixUtils() {
        this.threads = 1;
    }

    public MatrixUtils(int threads) {
        this.threads = threads > 1 ? threads : 1;
    }

    public MatrixUtils(int[] matrizDividida) {
        this.matrizDividida = matrizDividida;
        this.promedioSegmento = 0;
    }

    @Override
    public void run() {
        // Calcula el promedio del segmento de la matriz
        double sum = 0;
        for (int num : matrizDividida) {
            sum += num;
        }
        promedioSegmento = sum / matrizDividida.length;

        synchronized (resultados){
            resultados.add(promedioSegmento);
        }
    }

    public double findAverage(int[][] matrix) throws InterruptedException {
        resultados = new ArrayList<>();
        // Dividir la matriz en submatrices
        int totalThreads = Math.min(threads, matrix.length);
        Thread[] threadPool = new Thread[totalThreads];
        int segmento = matrix.length / totalThreads;
        int filas = matrix[0].length;
        int inicio_m = 0;
        int final_m = inicio_m+segmento;

        // Crear y ejecutar hilos para calcular el promedio de cada submatriz
        for (int i = 0; i < totalThreads; i++) {
            if (i == totalThreads-1) {
                final_m = matrix.length;
            }

            int cols = final_m - inicio_m;
            int[] submatriz = new int[cols * filas];
            int index = 0;
            for (int j = inicio_m; j < final_m; j++) {
                for (int k = 0; k < filas; k++) {
                    submatriz[index++] = matrix[j][k];
                }
            }
            threadPool[i] = new Thread(new MatrixUtils(submatriz));
            threadPool[i].start();
            inicio_m += segmento;
            final_m += segmento;
        }

        // Esperar a que todos los hilos terminen
        for (Thread thread : threadPool) {
            thread.join();
        }

        double resultado = 0.0;
        for (Double res : resultados) {
            resultado += res;
        }

        return resultado / resultados.size();
    }
}
