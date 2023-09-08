package uniandes.dpoo.taller1.modelo;

public class Ingrediente {

	// ************************************************************************
	// Atributos
	// ************************************************************************

	/**
	 * El nombre del ingrediente
	 */
	private String nombre;

	/**
	 * costo ingrediente
	 */
	private int costoAdicional;

	// ************************************************************************
		// Constructores
	// ************************************************************************

	public Ingrediente(String nombre, int costoAdicional) 
	
	{
		this.nombre = nombre;
		
		this.costoAdicional = costoAdicional;
	}

	public String getNombre() 
	{
		return nombre;
	}
	
	public int getCostoAdicional() 
	{
		return costoAdicional;
	}
}
