/**
 * 
 */
package tienda;

/**
 * @author sjgui
 *
 */
public class Producto {

	private String codigo;
	private String nombre;
	private String descripcion;
	private double precio;
	private double iva;
	private Categoria categoria;
	
		
	/**
	 * @param nombre
	 * @param descripcion
	 * @param precio
	 * @param iva
	 */
	public Producto(String nombre, String descripcion, double precio, double iva) {
		super();
		this.codigo = generarCodigo(nombre);
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.iva = iva;
	}

	/**
	 * @param nombre
	 * @param descripcion
	 * @param precio
	 * @param iva
	 * @param categoria
	 */
	public Producto(String nombre, String descripcion, double precio, double iva, Categoria categoria) {
		super();
		this.codigo = generarCodigo(nombre);
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.iva = iva;
		this.categoria = categoria;
	}

	
	private String generarCodigo(String nombreprod) {
		StringBuilder cod = new StringBuilder();
		for(int i=0; i<4; i++)
			cod.append(nombreprod.charAt(i));
		
		for(int i=0; i<4; i++) {
			int num = (int) (Math.random() * 9);
			cod.append(num);
		}
		return cod.toString();
	}
	

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * @return the iva
	 */
	public double getIva() {
		return iva;
	}

	/**
	 * @param iva the iva to set
	 */
	public void setIva(double iva) {
		this.iva = iva;
	}

	/**
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Producto))
			return false;
		Producto other = (Producto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Producto [codigo=");
		builder.append(codigo);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append(", precio=");
		builder.append(precio);
		builder.append(", iva=");
		builder.append(iva);
		builder.append(", categoria=");
		builder.append(categoria);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
