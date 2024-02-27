package unam.ciencias.computoconcurrente;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberCalculator implements Runnable {
    private int threads;
    private int numero;
    private int inicioSegmento;
    private int finalSegmento;
    private boolean resultado;
    private static List<Boolean> resultados;

    public PrimeNumberCalculator() {
        this.threads = 1;
    }

    public PrimeNumberCalculator(int threads) {
        this.threads = threads > 1 ? threads : 1;
    }

    public PrimeNumberCalculator(int numero, int inicioSegmento, int finalSegmento) {
        this.numero = numero;
        this.inicioSegmento = inicioSegmento;
        this.finalSegmento = finalSegmento;
    }

    @Override
    public void run() {
        resultado = true;
        for (int i = inicioSegmento; i <= finalSegmento; i++) {
            if (i <= 1)
                continue; // No necesitamos verificar divisibilidad por números menores o iguales a 1
            if (numero % i == 0) { // Si encontramos un divisor, actualizamos el resultado y salimos del ciclo
                resultado = false;
                break;
            }
        }
        synchronized (resultados) {
            resultados.add(resultado);
        }
    }

    /**
     * Metodo para saber si el número dado es primo.
     * 
     * @param n Número que queremos ver si es primo.
     * @throws InterruptedException
     * @return Si es primo o no es primo.
     */
    public boolean isPrime(int numero) throws InterruptedException {
        if (numero <= 1)
            return false; // 0 y 1 no son primos

        resultado = true;
        if (threads == 1) {
            for (int i = 2; i < numero; i++) {
                    if (numero % i == 0) { // Si encontramos un divisor, actualizamos el resultado y salimos del ciclo
                    resultado = false;
                    break;
                }
            }
            return resultado;
        }
    
        resultados = new ArrayList<>();
        int segmento = (numero - 2) / threads;
        int inicio = 2;
        int fin = inicio + segmento;
        Thread[] hilos = new Thread[threads];
    
    
        for (int i = 0; i < threads; i++) {
            if (i == threads - 1) {
                fin = numero - 1;
            }
            PrimeNumberCalculator pnc = new PrimeNumberCalculator(numero, inicio, fin);
            hilos[i] = new Thread(pnc); // Crear una nueva instancia de hilo
            hilos[i].start(); // Iniciar el hilo
            inicio = fin + 1;
            fin = inicio + segmento;
        }
    
        // Esperar a que todos los hilos terminen y recoger sus resultados
        for (Thread hilo : hilos) {
            hilo.join(); // Esperar a que el hilo termine
        }
    
        resultado = true;
        // Verificar si algún hilo encontró un número primo
        for (boolean res : resultados) {
            if (!res) {
                resultado = false; 
            }
        }
        

        return resultado;
    }
    

}