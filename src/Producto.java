import java.util.ArrayList;

/**
 * The type Producto.
 */
public class Producto {
    private ArrayList<Integer> listaProductos = new ArrayList<>();
    private int capacidad = 3;
    private boolean salir = false; //Usamos la variable salir como bandera para que salga de los bucles.

    /**
     * Producir.
     *
     * @param producto the producto
     */
    public synchronized void producir(int producto) {

        while (this.listaProductos.size() == this.capacidad) {
            System.out.println("La lista esta COMPLETA");

            for (int i = 0; i < this.listaProductos.size(); i++) {
                System.out.println("Elementos de la lista " + this.listaProductos.get(i));

                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }


        }
        this.listaProductos.add(producto);
        System.out.println("Tienda produce " + producto);
        notify();

    }


    /**
     * Consumir.
     *
     * @param producto the producto
     */
    public synchronized void consumir(int producto) {

        try {
            while (this.listaProductos.isEmpty()) {
                System.out.println("Lista Vacia , esperando a que produzca");
                wait();
            }

            this.listaProductos.remove(0);
            System.out.println("Persona consume: " + "PRODUCTO " + producto);
            notify();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();

        }
    }

    /**
     * Gets lista productos.
     *
     * @return the lista productos
     */
    public ArrayList<Integer> getListaProductos() {
        return listaProductos;
    }

    /**
     * Sets lista productos.
     *
     * @param listaProductos the lista productos
     */
    public void setListaProductos(ArrayList<Integer> listaProductos) {
        this.listaProductos = listaProductos;
    }

    /**
     * Gets capacidad.
     *
     * @return the capacidad
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Sets capacidad.
     *
     * @param capacidad the capacidad
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Is salir boolean.
     *
     * @return the boolean
     */
    public boolean isSalir() {
        return salir;
    }

    /**
     * Sets salir.
     *
     * @param salir the salir
     */
    public void setSalir(boolean salir) {
        this.salir = salir;
    }
}