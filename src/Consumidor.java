/**
 * The type Consumidor.
 */
public class Consumidor extends Thread {

    private Producto producto;
    private int contadorComun = 1;

    /**
     * Instantiates a new Consumidor.
     *
     * @param producto the producto
     */
    public Consumidor(Producto producto) {
        this.producto = producto;
    }

    @Override
    public void run() {

        try {
            while (!Thread.interrupted()) {
                this.producto.consumir(contadorComun);
                this.contadorComun++;
                Thread.sleep(20);
            }
        } catch (InterruptedException e) {
            System.err.println("Consumidor interrumpido");
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

    /**
     * Gets contador comun.
     *
     * @return the contador comun
     */
    public int getContadorComun() {
        return contadorComun;
    }

    /**
     * Sets contador comun.
     *
     * @param contadorComun the contador comun
     */
    public void setContadorComun(int contadorComun) {
        this.contadorComun = contadorComun;
    }

}
