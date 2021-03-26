/**
 * 
 */
package tienda;

import java.time.LocalDateTime;
import java.util.ArrayList;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

/**
 * @author sjgui
 *
 */
public class Pedido {

	private int codigo;
	private ArrayList<LineaPedido> lineas;
	private double total;
	private LocalDateTime fecha;
	private Cliente cliente;
	
	private static int autoincremento=1;

	/**
	 * 
	 */
	public Pedido() {
		super();
		this.codigo = Pedido.autoincremento;
		Pedido.autoincremento++;
		this.lineas = new ArrayList<>();
		this.fecha = LocalDateTime.now();
		this.cliente = null;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}


	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	/**
	 * @return the lineas
	 */
	public ArrayList<LineaPedido> getLineas() {
		return lineas;
	}
	
	/**
	 * Calcula el total del precio del pedido multiplicando el precio de cada producto por su cantidad
	 * Y luego multiplicando eso por el iva del producto (suponemos que se almacena como 1.10 para un 10%)
	 * @return precio total del pedido
	 */
	public double total() {
		double total=0;
		
		for(LineaPedido lp : lineas) {
			total += (lp.getProducto().getPrecio() * lp.getCantidad()) * lp.getProducto().getIva();
		}
		
		//Restamos el descuento del Cliente si lo tiene
		if (cliente != null)
			total = total - cliente.descuento();
		
		return total;
	}

	/**
	 * Añade una nueva LineaPedido al Pedido
	 * @param lp
	 */
	public void nuevaLinea(LineaPedido lp) {
		lineas.add(lp);
		this.total = total();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pedido ");
		builder.append(codigo);
		if (cliente != null) //Si tiene cliente asociado pintamos los datos
			builder.append("  - Cliente: " + cliente.getDni() + " " + cliente.getApellidos() + ", " + cliente.getNombre() + "\n");
		
		for(LineaPedido lp: lineas) {
			builder.append("Producto: " + lp.getProducto().getCodigo());
			builder.append(" - Precio: " + lp.getProducto().getPrecio());
			builder.append(" euros - Cantidad: " + lp.getCantidad());
			builder.append(" =  " + lp.subtotal() + " euros\n");
		}
		builder.append("Total = " + total + " euros");
		
		//Si hay descuento por ser cliente registrado lo indicamos
		if ( (cliente != null) && (cliente.descuento() > 0) )
			builder.append("  (descuento incluido de " + cliente.descuento() + " euros)");
		
		return builder.toString();
	}
	
	/**
	 * Genera pdf con los datos del pedido
	 */
	public void toPDF() {
		try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Text
            contentStream.beginText();
            contentStream.setFont(PDType1Font.TIMES_BOLD, 32);
            contentStream.newLineAtOffset( 20, page.getMediaBox().getHeight() - 52);
            contentStream.showText("Pedido " + this.codigo);
            contentStream.endText();
            
            if (cliente != null) { //Si tiene cliente asociado pintamos los datos
            	contentStream.beginText();
                contentStream.setFont(PDType1Font.TIMES_BOLD, 12);
                contentStream.newLineAtOffset( 20, page.getMediaBox().getHeight() - 80);
                contentStream.showText("Cliente: " + cliente.getDni() + " " + cliente.getApellidos() + ", " + cliente.getNombre());
                contentStream.newLineAtOffset(0, -15);
                contentStream.showText("Direccion: " + cliente.getDireccion() + ", " + cliente.getLocalidad());
                contentStream.endText();
            }
            
            //Mejorar usando setLeading() el espaciado, y newline()
            contentStream.beginText();
            contentStream.setFont(PDType1Font.COURIER, 14);
            contentStream.newLineAtOffset( 20, 700);
            StringBuilder texto = new StringBuilder();
            for(LineaPedido lp: lineas) { 
            	texto.setLength(0); //Vaciar StringBuilder

            	texto.append("Producto: " + lp.getProducto().getCodigo() );
                texto.append(" - Precio: " + lp.getProducto().getPrecio());
                texto.append("€ - Cantidad: " + lp.getCantidad());
                texto.append(" =  " + lp.subtotal() + "€");
                contentStream.showText(texto.toString());
                contentStream.newLineAtOffset( 0, -25);
            }
            contentStream.showText("Total = "+total()+"€");
            if ( (cliente != null) && (cliente.descuento() > 0) )
            	contentStream.showText("  (descuento incluido de " + cliente.descuento() + " euros)");
            
            contentStream.endText();

            contentStream.close();

            document.save("pedido"+ this.codigo +".pdf");
        } catch (Exception ex) {
        	System.out.println("Error: "+ex.getMessage());
        }
	}
	
	
	
	
	
}
