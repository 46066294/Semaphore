import java.util.Scanner;
import java.util.concurrent.Semaphore;

/**
 * Parking con un semaforo para controlar entradas
 * y salidas de vehiculos
 */
class Parking2 {

    private static int numPlazas = 0;
    private static int numCoches = 0;
    private static boolean[] arrayBool;// plazas
    public static Semaphore sem;

    public Parking2(){
    }

    //getters -- setters
    public static int getNumPlazas() {
        return numPlazas;
    }


    public void setNumCoches(int numCoches) {
        this.numCoches = numCoches;
    }


    public void setNumPlazas(int numPlazas) {
        this.numPlazas = numPlazas;
        this.arrayBool = new boolean[numPlazas];// plazas
    }

    /**
     * Se crea el array que representa
     * las plazas del parking
     */
    public void crearParking(){
        for(int i = 0; i < numPlazas; i++){
            arrayBool[i] = false;
        }
    }

    /**
     * Se crea el semaforo que llevara la cuenta de
     * los vehiculos que usaran el parking
     */
    public void crearSemaforo() {
        this.sem = new Semaphore(this.getNumPlazas());
    }

    /**
     * Procedimiento donde se crean los vehiculos
     * y se ejecutan
     */
    public void on(){
        int contVehiculos = 0;
        for(int i = 0; i < numCoches; i++){
            if(contVehiculos < numCoches){
                contVehiculos++;
                Cotxe2 cotxe = new Cotxe2(i);
                cotxe.start();

            }
        }
    }


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Numero de plazas:");
        int p = input.nextInt();
        System.out.println("Numero de coches:");
        int c = input.nextInt();

        input.close();

        Parking2 parking = new Parking2();
        parking.setNumPlazas(p);
        parking.setNumCoches(c);
        parking.crearParking();
        parking.crearSemaforo();
        parking.on();

    }


}