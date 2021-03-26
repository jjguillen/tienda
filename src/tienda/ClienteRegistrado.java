/**
 * 
 */
package tienda;

import java.time.LocalDate;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author sjgui
 *
 */
public class ClienteRegistrado extends Cliente {

	private String email;
	private String password;
	private LocalDate fechaNacimiento;
	private LocalDate fechaRegistro;
	private double descuento=5;
	
	

	/**
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 * @param localidad
	 * @param direccion
	 */
	public ClienteRegistrado(String nombre, String apellidos, String dni, String localidad, String direccion,
							 String email, String password, LocalDate fechaNacimiento) {
		super(nombre, apellidos, dni, localidad, direccion);
		this.email = email;
		this.password = DigestUtils.sha256Hex(password);
		this.fechaNacimiento = fechaNacimiento;
		this.fechaRegistro = LocalDate.now();
		this.descuento = 5;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = DigestUtils.sha256Hex(password);
	}

	/**
	 * @return the fechaNacimiento
	 */
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the descuento
	 */
	public double getDescuento() {
		return descuento;
	}

	/**
	 * @param descuento the descuento to set
	 */
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	/**
	 * @return the fechaRegistro
	 */
	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * Comprueba que la contraseña pasada como parámetro coincide con la guardada aplicándole sha256
	 * @param pass
	 * @return Si coincide o no con la contraseña guardada
	 */
	public boolean checkPassword(String pass) {
		if (DigestUtils.sha256Hex(pass).equals(password))
			return true;
		
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClienteRegistrado [dni=");
		builder.append(dni);
		builder.append(", email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append(", fechaNacimiento=");
		builder.append(fechaNacimiento);
		builder.append(", fechaRegistro=");
		builder.append(fechaRegistro);
		builder.append(", descuento=");
		builder.append(descuento);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", apellidos=");
		builder.append(apellidos);
		builder.append(", localidad=");
		builder.append(localidad);
		builder.append(", direccion=");
		builder.append(direccion);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public double descuento() {
		
		return this.descuento;
	}

}
