
package app.pedidos;

import java.util.List;

public class PedidoFacade {
    private ValidacionService validacionService;
    private CalculoService calculoService;
    private RegistroService registroService;
    private ComprobanteService comprobanteService;
    private FacturaService facturaService;
    private PedidoRepository pedidoRepository;
    private ImpuestoStrategy impuestoStrategy;
    
    public PedidoFacade(FacturaService facturaService, PedidoRepository pedidoRepository) {
        this.validacionService = new ValidacionService();
        this.calculoService = new CalculoService();
        this.registroService = new RegistroService();
        this.comprobanteService = new ComprobanteService();
        this.facturaService = facturaService;
        this.pedidoRepository = pedidoRepository;
        this.impuestoStrategy = new IGV18Strategy();
    }
    public void setImpuestoStrategy(ImpuestoStrategy impuestoStrategy) {
        this.impuestoStrategy = impuestoStrategy;
        System.out.println(" Estrategia de impuesto cambiada a: " + 
                         impuestoStrategy.getNombre());
    }
    public String procesarPedido(String cliente, String producto, int cantidad) {
        System.out.println("\n===== INICIANDO PROCESO DE PEDIDO =====\n");
        
        
        if (!validacionService.validarCantidad(cantidad)) {
            return "ERROR: La cantidad debe ser positiva";
        }
        
        
        if (!validacionService.validarStock(producto, cantidad)) {
            return "ERROR: No hay suficiente stock para el producto";
        }
        // 2) Cálculos
        double subtotal = calculoService.calcularSubtotal(producto, cantidad);
        double igv = impuestoStrategy.calcular(subtotal);
        double total = calculoService.calcularTotal(subtotal, igv);

        System.out.println(" Subtotal: S/. " + String.format("%.2f", subtotal));
        System.out.println(" IGV (18%): S/. " + String.format("%.2f", igv));
        System.out.println(" Total: S/. " + String.format("%.2f", total));
        System.out.println();

       Pedido pedido = new Pedido(cliente, producto, cantidad, subtotal, igv, total);
       pedidoRepository.guardar(pedido);
        System.out.println();
        registroService.registrarPedido(cliente, producto, cantidad);
        System.out.println();
        String comprobante = comprobanteService.generarComprobante(
            cliente, producto, subtotal, igv, total
        );
    return comprobante;
    }  
    public List<Pedido> listarPedidos() {
        return pedidoRepository.obtenerTodos();
    }
    public List<Pedido> obtenerPedidosPorCliente(String cliente) {
        return pedidoRepository.obtenerPorCliente(cliente);
    }
}
