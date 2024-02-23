package unam.ciencias.computoconcurrente;

public class App {

    /**
     * Metodo principal encargado de obtener el número de filosofos y
     * de la creacion y ejecución de threads.
     * Parametros:
     * @param args Entrada estándar, numero de filosofos
     */
    public static void main(String[] args) throws InterruptedException {
        int numFilosofos = 0;

        while (numFilosofos <= 4) {
            System.out.println("Número de filósofos: ");
            numFilosofos = Integer.parseInt(System.console().readLine());
        }

        //Aqui va tu codigo

    }
}

/*

Ejemplo de ejecución

$ java -jar target/practica03-1.0.jar

Número de filósofos:
5
Filósofo 1 20016476188791: Pensando...
Filósofo 2 20016476229958: Pensando...
Filósofo 4 20016476435666: Pensando...
Filósofo 3 20016476380291: Pensando...
Filósofo 5 20016476544541: Pensando...
---> Sección crítica del filosofo 1
Filósofo 1 20016477090166: Agarraó el tenedor izquierdo.
---> Sección crítica del filosofo 2
Filósofo 2 20016508403500: Agarraó el tenedor izquierdo.
---> Sección crítica del filosofo 3
Filósofo 3 20016513125125: Agarraó el tenedor izquierdo.
Filósofo 3 20016532037958: Agarró el tenedor derecho y empieza a comer.
Filósofo 3 20016580994416: Puso en la mesa el tenedor derecho.
---> Sección crítica del filosofo 4
Filósofo 4 20016624882375: Agarraó el tenedor izquierdo.
Filósofo 3 20016624558458: Puso en la mesa el tenedor izquierdo y volvió a pensar.
Filósofo 3 20016660349541: Pensando...
Filósofo 2 20016660808208: Agarró el tenedor derecho y empieza a comer.
Filósofo 2 20016699404333: Puso en la mesa el tenedor derecho.
Filósofo 2 20016699814833: Puso en la mesa el tenedor izquierdo y volvió a pensar.
Filósofo 4 20016709113750: Agarró el tenedor derecho y empieza a comer.
---> Sección crítica del filosofo 3
Filósofo 3 20016754664250: Agarraó el tenedor izquierdo.
Filósofo 4 20016798166625: Puso en la mesa el tenedor derecho.
Filósofo 1 20016802129958: Agarró el tenedor derecho y empieza a comer.
Filósofo 2 20016802102833: Pensando...
Filósofo 1 20016840481791: Puso en la mesa el tenedor derecho.
Filósofo 4 20016847011375: Puso en la mesa el tenedor izquierdo y volvió a pensar.
---> Sección crítica del filosofo 2
Filósofo 2 20016904181000: Agarraó el tenedor izquierdo.
Filósofo 1 20016903858750: Puso en la mesa el tenedor izquierdo y volvió a pensar.
Filósofo 3 20016946640875: Agarró el tenedor derecho y empieza a comer.
Filósofo 4 20016946559333: Pensando...
Filósofo 3 20016957165458: Puso en la mesa el tenedor derecho.
Filósofo 1 20016957411541: Pensando...
---> Sección crítica del filosofo 5
Filósofo 5 20016957667916: Agarraó el tenedor izquierdo.
Filósofo 3 20017014655958: Puso en la mesa el tenedor izquierdo y volvió a pensar.
---> Sección crítica del filosofo 4
Filósofo 4 20017015014291: Agarraó el tenedor izquierdo.
Filósofo 4 20017028835750: Agarró el tenedor derecho y empieza a comer.
Filósofo 4 20017043413708: Puso en la mesa el tenedor derecho.
Filósofo 3 20017101937958: Pensando...
Filósofo 2 20017102308625: Agarró el tenedor derecho y empieza a comer.
Filósofo 2 20017123816708: Puso en la mesa el tenedor derecho.
Filósofo 4 20017143361625: Puso en la mesa el tenedor izquierdo y volvió a pensar.
Filósofo 5 20017144724708: Agarró el tenedor derecho y empieza a comer.
Filósofo 4 20017170512041: Pensando...
....

*/