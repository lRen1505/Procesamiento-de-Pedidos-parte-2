
package app.pedidos;


public class CalculoService {

private static final double PRECIO_UNITARIO = 50;

public double calcularSubtotal(String producto, int cantidad) {
      double subtotal = PRECIO_UNITARIO * cantidad;
        return subtotal;  
    }

public double calcularTotal(double subtotal, double impuesto) {
        return subtotal + impuesto;
    }
}