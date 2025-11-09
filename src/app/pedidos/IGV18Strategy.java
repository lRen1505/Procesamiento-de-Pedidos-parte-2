
package app.pedidos;


public class IGV18Strategy implements ImpuestoStrategy {
    
    private static final double IGV_RATE = 0.18;
    
    @Override
    public double calcular(double subtotal) {
        return subtotal * IGV_RATE;
    }
    
   
    @Override
    public String getNombre() {
        return "IGV 18%";
    }
}