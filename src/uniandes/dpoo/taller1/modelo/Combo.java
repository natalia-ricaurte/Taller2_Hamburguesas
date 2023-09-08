package uniandes.dpoo.taller1.modelo;

import java.util.ArrayList;

public class Combo implements Producto{
	
	// ************************************************************************
	// Atributos
	// ************************************************************************

	/**
	 * cantidad descuento
	 */
	private Double descuento;

	/**
	 * El nombre combo
	 */
	private String nombreCombo;
	
	private ArrayList<Producto> productos;
	

	// ************************************************************************
		// Constructores
	// ************************************************************************

	public Combo(Double descuento, String nombreCombo)
	
	{
		this.descuento = descuento;
		this.nombreCombo = nombreCombo;
		this.productos = new ArrayList<>();
	}

	public void agregarItemACombo(Producto itemCombo) 
	{
		productos.add(itemCombo);
	}
	
	
	public int getPrecio() 
	{
		int precio = 0;
		
		for (Producto producto: productos)
		{
		precio += producto.getPrecio();
				
		}
		
		precio -= (precio * descuento);
		
		return precio;
	}

	@Override
	public String generarTextoFactura() {
		// TODO Auto-generated method stub
		
		String textoFactura = "Nombre combo:" + nombreCombo + "/n";
		textoFactura += "Precio:" + getPrecio() + "/n";
		textoFactura += "Productos: /n";
		for (Producto producto: productos)
		{
			textoFactura += producto.getNombre()+ " $" +producto.getPrecio() + "/n";
		}
		
		return textoFactura;
	}
	
	public String getNombre() 
	{
		return nombreCombo;
	}
	
}
