package com.methaporce.shop.app;

import com.methaporce.shop.app.controllers.ProductoController;
import com.methaporce.shop.app.entities.Producto;
import com.methaporce.shop.app.service.ProductoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ProductoControllerTest {
    @Mock
    private ProductoService productoService;

    @InjectMocks
    private ProductoController productoController;

    private Producto producto;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        producto = new Producto();
        producto.setId_producto(1L); // Asegúrate de que el nombre del campo coincide con el de tu entidad.
        producto.setNombre("Producto Test");
    }

    @Test
    void testAgregarProducto() {
        when(productoService.agregarProducto(producto)).thenReturn(producto);

        ResponseEntity<Producto> response = productoController.agregarProducto(producto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(producto, response.getBody());
    }

    @Test
    void testObtenerProductoPorId_Existente() {
        when(productoService.obtenerProductoById(1L)).thenReturn(Optional.of(producto));

        ResponseEntity<Producto> response = productoController.obtenerProductoPorId(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(producto, response.getBody());
    }

    @Test
    void testObtenerProductoPorId_NoExistente() {
        when(productoService.obtenerProductoById(1L)).thenReturn(Optional.empty());

        ResponseEntity<Producto> response = productoController.obtenerProductoPorId(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testObtenerTodosLosProductos() {
        when(productoService.obtenerTodosLosProductos()).thenReturn(List.of(producto, producto));

        ResponseEntity<List<Producto>> response = productoController.obtenerTodosLosProductos();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
    }
}
