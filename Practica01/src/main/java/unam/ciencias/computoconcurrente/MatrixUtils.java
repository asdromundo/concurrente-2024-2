package unam.ciencias.computoconcurrente;

public class MatrixUtils implements Runnable {
    private int threads;
    private double promedioSegmento;
    private int[] matrizDividida;

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
        try {
            promedioSegmento = findAverage(matrizDividida);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public double findAverage(int[][] matrix) throws InterruptedException {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException("La matriz no puede ser nula o vacía.");
        }

        long sum = 0;
        int count = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                sum += num;
                count++;
            }
        }

        return (double) sum / count;
    }
}
