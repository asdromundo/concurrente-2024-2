package unam.ciencias.computoconcurrente;

class Consumidor implements Runnable {
    private Buffer buffer;
    private static int idCounter = 0;
    private int id;

    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
        this.id = idCounter++;
    }

    public void run() {
        try {
            while (true) {
                // Intenta consumir un elemento del buffer
                buffer.consumir(id);
                // Simula un tiempo de consumo
                Thread.sleep(1000); // 1000 ms
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
