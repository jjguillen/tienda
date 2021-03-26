/**
 * 
 */
package tienda;

/**
 * @author sjgui
 *
 */
public class ClienteNoRegistrado extends Cliente {

	/**
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 * @param localidad
	 * @param direccion
	 */
	public ClienteNoRegistrado(String nombre, String apellidos, String dni, String localidad, String direccion) {
		super(nombre, apellidos, dni, localidad, direccion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double descuento() {
		//No hay descuento
		return 0;
	}

	
}
