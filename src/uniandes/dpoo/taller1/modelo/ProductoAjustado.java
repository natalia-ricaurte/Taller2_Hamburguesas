package uniandes.dpoo.taller1.modelo;

public class ProductoAjustado implements Producto{
	
	
	private ProductoMenu base;
	
	public ProductoAjustado(ProductoMenu base) 
	{
		this.base = base;
	}
	
	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return base.getNombre();
	}

	@Override
	public int getPrecio() {
		// TODO Auto-generated method stub
		return base.getPrecio();
	}

	@Override
	public String generarTextoFactura() {
		// TODO Auto-generated method stub
		String factura = "Nombre producto : "+ getNombre() + "/n"+
				"Precio: " + getPrecio();
		
		return factura;
	}

	
}
