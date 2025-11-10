
package app.pedidos;


public class CalculoService {

private static final double PRECIO_UNITARIO = 50;

public double calcularSubtotal(String producto, int cantidad) {
      double subtotal = PRECIO_UNITARIO * cantidad;
        return subtotal;  
    }

    double calcularIGV(double subtotal) {
     return subtotal * IGV_RATE;
    }

    double calcularTotal(double subtotal, double igv) {
     return subtotal + igv;
    }
    
}