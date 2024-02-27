package unam.ciencias.computoconcurrente;

class Productor implements Runnable {
    private Buffer buffer;
    private static int idCounter = 0;
    private int id;

    public Productor(Buffer buffer) {
        this.buffer = buffer;
        this.id = idCounter++;
    }

    public void run() {
        try {
            while (true) {
                // Genera un elemento
                int item = (int) (Math.random() * 100); // Genera un elemento aleatorio
                // Intenta producir el elemento en el buffer
                buffer.producir(item, id);
                // Simula un tiempo de producción
                Thread.sleep(1500); // Puede ser distinto chicos, aquí son 1500 ms
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
}
