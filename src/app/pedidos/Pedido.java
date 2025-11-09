
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pedido {
    private String id;
    private String cliente;
    private String producto;
    private int cantidad;
    private double subtotal;
    private double igv;
    private double total;
    private LocalDateTime fecha;
    
    /**
     * Constructor completo de Pedido
     */
    public Pedido(String cliente, String producto, int cantidad, 
                  double subtotal, double igv, double total) {
        this.id = "PED-" + System.currentTimeMillis();
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.igv = igv;
        this.total = total;
        this.fecha = LocalDateTime.now();
    }
    
    // Getters
    public String getId() {
        return id;
    }
    
    public String getCliente() {
        return cliente;
    }
    
    public String getProducto() {
        return producto;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    public double getSubtotal() {
        return subtotal;
    }
    
    public double getIgv() {
        return igv;
    }
    
    public double getTotal() {
        return total;
    }
    
    public LocalDateTime getFecha() {
        return fecha;
    }
    
    /**
     * Representación en texto del pedido
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return String.format(
            "Pedido[ID=%s, Cliente=%s, Producto=%s, Cantidad=%d, Total=S/.%.2f, Fecha=%s]",
            id, cliente, producto, cantidad, total, fecha.format(formatter)
        );
    }
}