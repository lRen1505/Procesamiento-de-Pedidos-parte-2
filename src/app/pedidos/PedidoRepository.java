
package app.pedidos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class PedidoRepository {
    
    
    private List<Pedido> pedidos;
    
    public PedidoRepository() {
        this.pedidos = new ArrayList<>();
        System.out.println("Repositorio de pedidos inicializado");

    }
public void guardar(Pedido pedido) {
        pedidos.add(pedido);
        System.out.println("Pedido guardado: " + pedido.getId());
    }
public List<Pedido> obtenerTodos() {
        System.out.println("Consultando todos los pedidos. Total: " + pedidos.size());
        return new ArrayList<>(pedidos);
    }
public Pedido obtenerPorId(String id) {
        System.out.println("Buscando pedido por ID: " + id);
        return pedidos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

public List<Pedido> obtenerPorCliente(String cliente) {
        System.out.println("Buscando pedidos del cliente: " + cliente);
        return pedidos.stream()
                .filter(p -> p.getCliente().equalsIgnoreCase(cliente))
                .collect(Collectors.toList());
    }
    
    public int contarPedidos() {
        return pedidos.size();
    }
}