/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        Producto producto = new Producto();

        Productor productor = new Productor(producto);
        Consumidor consumidor = new Consumidor(producto);

        productor.start();
        consumidor.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        productor.interrupt();
        consumidor.interrupt();


    }
}