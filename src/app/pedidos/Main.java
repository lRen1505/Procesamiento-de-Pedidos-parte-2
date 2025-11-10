
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
   
        System.out.println("✓ Sistema inicializado correctamente\n");
        System.out.println("=".repeat(70) + "\n");
        System.out.println("CASO 1: Pedido normal con IGV 18%");
        System.out.println("-".repeat(70)); 
        
        pedidoFacade.setImpuestoStrategy(estrategiaIGV);
        String resultado1 = pedidoFacade.procesarPedido("Juan Pérez", "Laptop HP", 2);
        System.out.println(resultado1);
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        //CASO 2
        System.out.println("CASO 2: Pedido exonerado (producto de canasta básica)");
        System.out.println("-".repeat(70));
        
        pedidoFacade.setImpuestoStrategy(estrategiaExonerado);
        String resultado2 = pedidoFacade.procesarPedido("María García", "Libro Educativo", 3);
        System.out.println(resultado2);
        
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        // CASO 3: OTRO PEDIDO CON IGV 
        System.out.println("CASO 3: Cambio de estrategia de vuelta a IGV 18%");
        System.out.println("-".repeat(70));
        
        pedidoFacade.setImpuestoStrategy(estrategiaIGV);
        String resultado3 = pedidoFacade.procesarPedido("Carlos López", "Mouse Logitech", 5);
        System.out.println(resultado3);
        
        System.out.println("\n" + "=".repeat(70) + "\n"); 
        
        //CASO 4
        System.out.println("CASO 4: Error - Stock insuficiente");
        System.out.println("-".repeat(70));
        
        String resultado4 = pedidoFacade.procesarPedido("Ana Torres", "Teclado", 20);
        System.out.println(resultado4);
        
        System.out.println("\n" + "=".repeat(70) + "\n");
        
        
        System.out.println("=== CONSULTA DE PEDIDOS (Patrón Repository)  ===\n");
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
        System.out.println("🔍 PEDIDOS DE 'Juan Pérez':");
        System.out.println("-".repeat(70));
        List<Pedido> pedidosJuan = pedidoFacade.obtenerPedidosPorCliente("Juan Pérez");
        if (pedidosJuan.isEmpty()) {
            System.out.println("   No se encontraron pedidos");
        } else {
            for (Pedido p : pedidosJuan) {
                System.out.println("   " + p);
            }
        }
        
        System.out.println("\n" + "=".repeat(70) + "\n");
                System.out.println("╔════════════════════════════════════════════════════╗");
        System.out.println("║   RESUMEN DE PATRONES APLICADOS                   ║");
        System.out.println("╚════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.println("✓ FACADE: PedidoFacade coordina todos los servicios");
        System.out.println("✓ ADAPTER: FacturaAdapter integra el sistema legacy");
        System.out.println("✓ STRATEGY: Cambio dinámico entre IGV18 y Exonerado");
        System.out.println("✓ REPOSITORY: PedidoRepository gestiona la persistencia");
        System.out.println();
        System.out.println("Total de pedidos procesados: " + todosPedidos.size());
        System.out.println();
        System.out.println("=".repeat(70));
    }
    
}
