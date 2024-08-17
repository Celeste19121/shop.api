package com.methaporce.shop.app.controllers;

import com.methaporce.shop.app.entities.DetalleOrden;
import com.methaporce.shop.app.entities.Orden;
import com.methaporce.shop.app.entities.Producto;
import com.methaporce.shop.app.entities.Usuario;
import com.methaporce.shop.app.service.DetalleOrdenServiceI;
import com.methaporce.shop.app.service.OrdenServiceI;
import com.methaporce.shop.app.service.ProductoServiceI;
import com.methaporce.shop.app.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carritos")
public class OrdenController {
    private final Logger log = LoggerFactory.getLogger(OrdenController.class);

    @Autowired
    private ProductoServiceI productoService;

    @Autowired
    private UsuarioService usuarioServiceI;

    @Autowired
    private OrdenServiceI ordenServiceI;

    @Autowired
    private DetalleOrdenServiceI detalleOrdenServiceI;

    private List<DetalleOrden> detalles = new ArrayList<>();
    private Orden orden = new Orden();

    @GetMapping("/")
    public ResponseEntity<?> home(HttpSession session) {
        log.info("Sesión usuario: {}", session.getAttribute("id_usuario"));
        List<Producto> productos = productoService.findAll();
        return ResponseEntity.ok().body(productos);
    }

    @GetMapping("/producto/{id}")
    public ResponseEntity<?> productoHome(@PathVariable Long id) {
        log.info("Id producto enviado como parámetro {}", id);
        Optional<Producto> productoOptional = productoService.obtenerProductoById(id);
        if (productoOptional.isPresent()) {
            return ResponseEntity.ok(productoOptional.get());
        } else {
            return ResponseEntity.notFound().build(); // Producto no encontrado
        }
    }

    @PostMapping("/cart")
    public ResponseEntity<?> addCart(@RequestParam Long id, @RequestParam Integer cantidad) {
        Optional<Producto> optionalProducto = productoService.obtenerProductoById(id);
        if (!optionalProducto.isPresent()) {
            return ResponseEntity.notFound().build(); // Producto no encontrado
        }

        Producto producto = optionalProducto.get();
        log.info("Producto añadido: {}", producto);
        log.info("Cantidad: {}", cantidad);

        DetalleOrden detalleOrden = new DetalleOrden();
        detalleOrden.setCantidad(cantidad);
        detalleOrden.setPrecio(producto.getPrecio());
        detalleOrden.setProducto(producto);

        Long id_producto = producto.getId_producto();
        boolean ingresado = detalles.stream().anyMatch(p -> p.getProducto().getId_producto().equals(id_producto));

        if (!ingresado) {
            detalles.add(detalleOrden);
        }

        double sumaTotal = detalles.stream().mapToDouble(DetalleOrden::getPrecio).sum();
        orden.setTotal(sumaTotal);

        return ResponseEntity.ok(detalles);
    }

    @DeleteMapping("/cart/{id}")
    public ResponseEntity<?> deleteProductoCart(@PathVariable Long id) {
        detalles = detalles.stream()
                .filter(detalle -> !detalle.getProducto().getId_producto().equals(id))
                .collect(Collectors.toList());

        double sumaTotal = detalles.stream().mapToDouble(DetalleOrden::getPrecio).sum();
        orden.setTotal(sumaTotal);

        return ResponseEntity.ok(detalles);
    }

    @GetMapping("/getCart")
    public ResponseEntity<?> getCart(HttpSession session) {
        return ResponseEntity.ok(detalles);
    }

    @PostMapping("/order")
    public ResponseEntity<?> order(HttpSession session) {
        Long id_usuario = (Long) session.getAttribute("id_usuario");
        if (id_usuario == null) {
            return ResponseEntity.status(401).body("Usuario no autenticado"); // Usuario no autenticado
        }

        Optional<Usuario> usuarioOptional = usuarioServiceI.obtenerUsuarioById(id_usuario);
        if (usuarioOptional.isPresent()) {
            orden.setComprador(usuarioOptional.get());
        } else {
            return ResponseEntity.notFound().build(); // Usuario no encontrado
        }

        return ResponseEntity.ok(orden);
    }

    @PostMapping("/saveOrder")
    public ResponseEntity<?> saveOrder(HttpSession session) {
        Long id_usuario = (Long) session.getAttribute("id_usuario");
        if (id_usuario == null) {
            return ResponseEntity.status(401).body("Usuario no autenticado"); // Usuario no autenticado
        }

        Optional<Usuario> usuarioOptional = usuarioServiceI.obtenerUsuarioById(id_usuario);
        if (!usuarioOptional.isPresent()) {
            return ResponseEntity.notFound().build(); // Usuario no encontrado
        }

        orden.setComprador(usuarioOptional.get());
        ordenServiceI.save(orden);

        for (DetalleOrden dt : detalles) {
            dt.setOrden(orden);
            detalleOrdenServiceI.save(dt);
        }

        orden = new Orden();
        detalles.clear();

        return ResponseEntity.ok("Orden guardada exitosamente");
    }

    @PostMapping("/search")
    public ResponseEntity<?> searchProduct(@RequestParam String nombre) {
        log.info("Nombre del producto: {}", nombre);
        List<Producto> productos = productoService.findAll()
                .stream()
                .filter(p -> p.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(productos);
    }
}

