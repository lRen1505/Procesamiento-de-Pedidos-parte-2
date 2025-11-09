
package app.pedidos;


public class ExoneradoStrategy implements ImpuestoStrategy {
    
    @Override
    public double calcular(double subtotal) {
        return 0.0;
    }
    
    @Override
    public String getNombre() {
        return "Exonerado (0%)";
    }
}