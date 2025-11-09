
package app.pedidos;


public class Main {


    public static void main(String[] args) {
      System.out.println("=== SISTEMA DE PROCESAMIENTO DE PEDIDOS ===\n");
    
   LegacyBillingSystem legacySystem = new LegacyBillingSystem();
   FacturaService facturaService = new FacturaAdapter(legacySystem);
   PedidoFacade pedidoFacade = new PedidoFacade(facturaService);
   
   System.out.println(" Pedido con stock suficiente");
        String resultado1 = pedidoFacade.procesarPedido(
            "Juan Velarde", 
            "Laptop HP", 
            2
       );
        System.out.println("Comprobante generado:");
            System.out.println(resultado1);
            
            System.out.println("\n" + "=".repeat(60) + "\n");
            
    }
}
