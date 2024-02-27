package unam.ciencias.computoconcurrente;

public class PrimeNumberCalculator implements Runnable {
    private int threads;
    private int numero;
    private int inicioSegmento;
    private int finalSegmento;
    private boolean resultado;

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
        try {
            resultado = isPrime(numero);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return;
    }

    /**
    * Metodo para saber si el número dado es primo.
    * @param n Número que queremos ver si es primo.
    * @throws InterruptedException
    * @return Si es primo o no es primo.
    */
    public boolean isPrime(int n) throws InterruptedException {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        int i = 5;
        while (i * i <= n) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
            i += 6;
        }
        return true;
    }

}
