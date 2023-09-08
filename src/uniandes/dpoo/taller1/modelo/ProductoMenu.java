package uniandes.dpoo.taller1.modelo;

public class ProductoMenu implements Producto{
	
	// ************************************************************************
	// Atributos
	// ************************************************************************

	/**
	 * El nombre del producto
	 */
	private String nombre;

	/**
	 * El precio del producto
	 */
	private int precioBase;
	

	// ************************************************************************
		// Constructores
	// ************************************************************************

	public ProductoMenu(String nombre, int precioBase)
	
	{
		this.nombre = nombre;
		this.precioBase = precioBase;
	}
	
	public String getNombre() 
	{
		return nombre;
	}
	
	public int getPrecio() 
	{
		return precioBase;
	}

	@Override
	public String generarTextoFactura() {
		// TODO Auto-generated method stub
		String factura = "Nombre producto: "+ nombre + "/n"+
				"Precio Base; " + precioBase;
		
		return factura;
	}
	

	
}
