package tienda;

import java.time.LocalDate;

public class TestPedido {

	public static void main(String[] args) {
		
		Categoria c1 = new Categoria("Móviles");
		Categoria c2 = new Categoria("Videojuegos");
		Categoria c3 = new Categoria("IoT");
		
		Producto p1 = new Producto("OnePlus 9", "Pepinaco de móvil", 700, 1.21, c1);
		Producto p2 = new Producto("Iphone 12", "Pepinaco de móvil diseño", 900, 1.21, c1);
		Producto p3 = new Producto("Xiaomi Mi 11", "Móvil mejor relación calidad/precio", 600, 1.21, c1);
		Producto p4 = new Producto("CyberPunk", "Mundo libre futurista", 70, 1.21, c2);
		Producto p5 = new Producto("Desperados III", "Oeste a lo Commandos", 30, 1.21, c2);
		Producto p6 = new Producto("Assassins Creed Vikings", "Más de lo mismo", 59, 1.21, c2);
		Producto p7 = new Producto("Raspberry Pi zero", "Para toquetear", 20, 1.21, c3);
		
		ClienteRegistrado cr = new ClienteRegistrado("Javier", "Guillén Benavente", "48416409L", "Mojácar", "Calle Vetealbar 1",
				 "jjavierguillen@gmail.com", "12345678", LocalDate.of(1977, 10, 10));
		
		Pedido pedido = new Pedido();
		pedido.nuevaLinea(new LineaPedido(p1, 2));
		pedido.nuevaLinea(new LineaPedido(p2, 1));
		pedido.nuevaLinea(new LineaPedido(p3, 2));
		pedido.nuevaLinea(new LineaPedido(p4, 1));
		pedido.nuevaLinea(new LineaPedido(p5, 5));
		pedido.nuevaLinea(new LineaPedido(p6, 1));
		pedido.nuevaLinea(new LineaPedido(p7, 10));
		pedido.setCliente(cr);
		
		System.out.println(pedido);
		
		////////////////////////////////////////////////////////////////
		//Pasar a PDF
		////////////////////////////////////////////////////////////////
		if (cr.checkPassword("12345678")) {
			pedido.toPDF();
			System.out.println(cr.getPassword());
		} else
			System.out.println("La contraseña suministrada no coincide con la almacenada");
		
		
		

	}

}
