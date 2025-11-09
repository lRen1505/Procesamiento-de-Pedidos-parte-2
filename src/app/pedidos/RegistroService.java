
package app.pedidos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class RegistroService {

 public void registrarPedido(String cliente, String producto, int cantidad) {
      LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String fechaHora = ahora.format(formatter);
        
        System.out.println(" Guardando pedido en la base de datos...");
        System.out.println("   Fecha/Hora: " + fechaHora);
        System.out.println("   Cliente: " + cliente);
        System.out.println("   Producto: " + producto);
        System.out.println("   Cantidad: " + cantidad);
        System.out.println("Pedido registrado exitosamente con ID: PED-" + 
                         System.currentTimeMillis());  
    }
    
}
