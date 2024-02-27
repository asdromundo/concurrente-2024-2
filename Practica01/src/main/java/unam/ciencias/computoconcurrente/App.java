package unam.ciencias.computoconcurrente;

public class App {

    public static void main(String[] a) throws InterruptedException {
        int numero = 2147483647;
        // Numeros primos secuencial
        long iniSec = System.currentTimeMillis();
        PrimeNumberCalculator secuencial = new PrimeNumberCalculator(1);
        System.out.println(secuencial.isPrime(numero));
        long finSec = System.currentTimeMillis();
        long tiempo01 = finSec - iniSec;
        // Numeros primos paralelo/concurrente
        long iniPar = System.currentTimeMillis();
        PrimeNumberCalculator paralelo = new PrimeNumberCalculator(8);
        System.out.println(paralelo.isPrime(numero));
        long finPar = System.currentTimeMillis();
        long tiempo02 = finPar - iniPar;

        System.out.println("Comparacion ejercicio 01");
        System.out.println("El primo a comparar es el numero: " + numero);
        System.out.println("El tiempo en el algoritmo secuencial tarda: " + tiempo01);
        System.out.println("El tiempo en el algoritmo paralelo tarda: " + tiempo02);

        int[][] matrix = {
            {4, 29, -6, 0},
            {15, 6, 0, 4},
            {25, 41, -10, 4},
            {0, 0, -1, 39},
        };

        // Promedio matriz secuencial
        long iniSec2 = System.currentTimeMillis();
        MatrixUtils secuencial2 = new MatrixUtils();
        secuencial2.findAverage(matrix);
        long finSec2 = System.currentTimeMillis();
        long tiempo011 = finSec2 - iniSec2;

        // Promedio matriz paralelo/concurrente        
        long iniPar2 = System.currentTimeMillis();
        MatrixUtils paralelo2 = new MatrixUtils(4);
        paralelo2.findAverage(matrix);
        long finPar2 = System.currentTimeMillis();
        long tiempo022 = finPar2 - iniPar2;

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Comparacion ejercicio 02");
        System.out.println("Se uso una matriz de:  ");
        System.out.println("El tiempo en el algoritmo secuencial tarda: " + tiempo011);
        System.out.println("El tiempo en el algoritmo paralelo tarda: " + tiempo022);

    }
}
