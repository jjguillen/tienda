package tienda;

public interface Descontable {

	/**
	 * Devuelve una cantidad fija que se resta al pedido del cliente, como un cupón
	 * @return
	 */
	public double descuento();
}
