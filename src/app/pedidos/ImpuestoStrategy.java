
package app.pedidos;


public interface ImpuestoStrategy {
    double calcular(double subtotal);
    String getNombre();
}
