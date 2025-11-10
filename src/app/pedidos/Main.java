
package app.pedidos;


public class Main {


    public static void main(String[] args) {
      System.out.println("=== SISTEMA DE PROCESAMIENTO DE PEDIDOS V.2 ===\n");
    
    PedidoRepository pedidoRepository = new PedidoRepository();
    LegacyBillingSystem legacySystem = new LegacyBillingSystem();
    FacturaService facturaService = new FacturaAdapter(legacySystem);
    PedidoFacade pedidoFacade = new PedidoFacade(facturaService, pedidoRepository);
   ImpuestoStrategy estrategiaIGV = new IGV18Strategy();
   ImpuestoStrategy estrategiaExonerado = new ExoneradoStrategy();   
   
        System.out.println("✓ Sistema inicializado correctamente\n");
        System.out.println("=".repeat(70) + "\n");
        
    }
}
