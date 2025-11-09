
package app.pedidos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ComprobanteService {

 public String generarComprobante(String cliente, String producto, double subtotal, double igv, double total) {
      LocalDateTime ahora = LocalDateTime.now();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
      String fechaHora = ahora.format(formatter); 
      
StringBuilder comprobante = new StringBuilder();
        comprobante.append("\n");
        comprobante.append("================================================\n");
        comprobante.append("        COMPROBANTE DE PAGO ELECTRONICO        \n");
        comprobante.append("================================================\n");
        comprobante.append("  Fecha: ").append(fechaHora).append("\n");
        comprobante.append("------------------------------------------------\n");
        comprobante.append("  Cliente:  ").append(cliente).append("\n");
        comprobante.append("  Producto: ").append(producto).append("\n");
        comprobante.append("------------------------------------------------\n");
        comprobante.append("  Subtotal:       S/. ").append(String.format("%10.2f", subtotal)).append("\n");
        comprobante.append("  IGV (18%):      S/. ").append(String.format("%10.2f", igv)).append("\n");
        comprobante.append("================================================\n");
        comprobante.append("  TOTAL A PAGAR:  S/. ").append(String.format("%10.2f", total)).append("\n");
        comprobante.append("================================================\n");
        
        return comprobante.toString();
    
    }
    
}