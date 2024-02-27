package unam.ciencias.computoconcurrente;

import java.util.concurrent.Semaphore;

class Buffer {
    private int item;
    private Semaphore mutex = new Semaphore(1);
    private Semaphore empty = new Semaphore(2); // Tamaño máximo del buffer
    private Semaphore full = new Semaphore(0);

    public void producir(int item, int id) throws InterruptedException {
        empty.acquire();
        mutex.acquire();
        this.item = item;
        System.out.println("Productor " + id + " depositó el elemento " + item);
        mutex.release();
        full.release();
    }

    public void consumir(int id) throws InterruptedException {
        full.acquire();
        mutex.acquire();
        int consumedItem = item;
        System.out.println("Consumidor " + id + " consumió el elemento " + consumedItem);
        mutex.release();
        empty.release();
    }
}
