
package app.pedidos;

import java.util.List;


public class Main {


    public static void main(String[] args) {
      System.out.println("=== SISTEMA DE PROCESAMIENTO DE PEDIDOS V.2 ===\n");
    
    PedidoRepository pedidoRepository = new PedidoRepository();
    LegacyBillingSystem legacySystem = new LegacyBillingSystem();
    FacturaService facturaService = new FacturaAdapter(legacySystem);
    PedidoFacade pedidoFacade = new PedidoFacade(facturaService, pedidoRepository);
   ImpuestoStrategy estrategiaIGV = new IGV18Strategy();
   ImpuestoStrategy estrategiaExonerado = new ExoneradoStrategy();   
   
        System.out.println("Sistema inicializado correctamente\n");
        System.out.println("=".repeat(70) + "\n");
        System.out.println("Pedido normal con IGV 18%");
        System.out.println("-".repeat(70)); 
        
        pedidoFacade.setImpuestoStrategy(estrategiaIGV);
        String resultado1 = pedidoFacade.procesarPedido("Steve Quispe", "Laptop HP", 2);
        System.out.println(resultado1);
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        //CASO 2
        System.out.println("Pedido exonerado (producto de canasta basica)");
        System.out.println("-".repeat(70));
        
        pedidoFacade.setImpuestoStrategy(estrategiaExonerado);
        String resultado2 = pedidoFacade.procesarPedido("Maria Garcia", "Libro Educativo", 3);
        System.out.println(resultado2);
        
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        // CASO 3: OTRO PEDIDO CON IGV 
        System.out.println("Pedido con IGV 18%");
        System.out.println("-".repeat(70));
        
        pedidoFacade.setImpuestoStrategy(estrategiaIGV);
        String resultado3 = pedidoFacade.procesarPedido("Carlos Lopez", "Mouse Logitech", 5);
        System.out.println(resultado3);
        
        System.out.println("\n" + "=".repeat(70) + "\n"); 
        
        //CASO 4
        System.out.println("Error - Stock insuficiente");
        System.out.println("-".repeat(70));
        
        String resultado4 = pedidoFacade.procesarPedido("Ana Torres", "Teclado", 20);
        System.out.println(resultado4);
        
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        
        System.out.println("=== CONSULTA DE PEDIDOS (Patron Repository)  ===\n");
        System.out.println("TODOS LOS PEDIDOS REGISTRADOS:");
        System.out.println("-".repeat(70));
        List<Pedido> todosPedidos = pedidoFacade.listarPedidos();
        if (todosPedidos.isEmpty()) {
            System.out.println("   No hay pedidos registrados");
        } else {
            for (Pedido p : todosPedidos) {
                System.out.println("   " + p);
            }
        }
        System.out.println("\n" + "-".repeat(70) + "\n");
        System.out.println("PEDIDOS DE 'Steve Quispe':");
        System.out.println("-".repeat(70));
        List<Pedido> pedidosSteve = pedidoFacade.obtenerPedidosPorCliente("Steve Quispe");
        if (pedidosSteve.isEmpty()) {
            System.out.println("   No se encontraron pedidos");
        } else {
            for (Pedido p : pedidosSteve) {
                System.out.println("   " + p);
            }
        }
        

    }
    
}
