/**
 * 
 */
package tienda;

/**
 * @author sjgui
 *
 */
public class LineaPedido {

	private Producto producto;
	private int cantidad;
	
	/**
	 * @param producto
	 * @param cantidad
	 */
	public LineaPedido(Producto producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}

	/**
	 * @return the producto
	 */
	public Producto getProducto() {
		return producto;
	}

	/**
	 * @param producto the producto to set
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	/**
	 * Calcula el subtotal de esta linea multiplicando el precio por la cantidad y aplicando el iva
	 * @return El subtotal calculado para esta línea
	 */
	public double subtotal() {
		return (getProducto().getPrecio() * getCantidad()) * getProducto().getIva();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LineaPedido [producto=");
		builder.append(producto);
		builder.append(", cantidad=");
		builder.append(cantidad);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
