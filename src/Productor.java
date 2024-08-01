import javax.swing.plaf.TableHeaderUI;

/**
 * The type Productor.
 */
public class Productor extends Thread {

    private Producto producto;
    private int contadorComun = 1;

    /**
     * Instantiates a new Productor.
     *
     * @param producto the producto
     */
    public Productor(Producto producto) {
        this.producto = producto;
    }
    @Override
    public void run() {


        try {
            while (!Thread.interrupted()) {
                this.producto.producir(contadorComun);
                this.contadorComun++;
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.err.println("Productor interrumpido");
        }
    }

    /**
     * Gets producto.
     *
     * @return the producto
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Sets producto.
     *
     * @param producto the producto
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

}
