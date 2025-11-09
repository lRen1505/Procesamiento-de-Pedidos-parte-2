
package app.pedidos;


public class LegacyBillingSystem {

    void createInvoice(String customerName, double amount) {
        System.out.println("Factura creada correctamente");
        System.out.println("   Cliente: " + customerName);
        System.out.println("   Monto: S/." + String.format("%.2f", amount));
        System.out.println("   Estado: Emitido");   
    }
    
}
