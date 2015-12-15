import java.util.Random;

/**
 * Representa un vehiculo: coche
 */
public class Cotxe2 extends Thread{

    private int id;

    public Cotxe2(int numCotxe) {
        this.id = numCotxe;

    }

    /**
     * Tarea del coche:
     * entrar en el parking y ocupar una plaza
     * durante un tiempo. Despues la abandona, sale del
     * parking y vuelve a repetir el proceso
     */
    @Override
    public void run() {
        Random rnd = new Random();

        while(true){
            try {
                Thread.sleep(rnd.nextInt(1000));
                Parking2.sem.acquire();
                System.out.println("ACQUIRE OK coche" + id);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(rnd.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Parking2.sem.release();
            System.out.println("RELEASE  OK");
        }


    }//run()

}
