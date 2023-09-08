package uniandes.dpoo.taller1.modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Pedido {
	
	// ************************************************************************
	// Atributos
	// ************************************************************************
	
	/**
	 * cantidad de pedidos
	 */
	private static int numeroPedidos = 0;
	/**
	 * El ID del pedido
	 */
	private int idPedido;
	
	/**
	 * El nombre del cliente
	 */
	private String nombreCliente;

	/**
	 * Dirección cliente
	 */
	private String direccionCliente;
	
	/**
	 * Producto el comportamiento de todos los elementos que pueden hacer parte de un
		pedido.
	 */
	
	private ArrayList<Producto> productos; 
	

	// ************************************************************************
		// Constructores
	// ************************************************************************

	public Pedido(String nombreCliente, String direccionCliente)
	
	{
		this.idPedido = ++numeroPedidos;
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
		this.productos = new ArrayList<>();
		
	}	
	
	public int idPedido() 
	{
		return idPedido;
	}
	
	public void agregarProducto(Producto nuevoItem)
	
	{
		productos.add(nuevoItem);
		
	}
	
	private int getPrecioNetoPedido() 
	{
		int precioNetoPedido = 0;
		
		for (Producto producto: productos) 
		{
			
			precioNetoPedido += producto.getPrecio();
			
		}
		
		return precioNetoPedido;
	}
	
	private int getPrecioTotalPedido() 
	{
		int precioTotalPedido = getPrecioNetoPedido() + getPrecioIvaPedido() ;
		return precioTotalPedido;
	}
	
	private int getPrecioIvaPedido() 
	{
		int precioNetoPedido = getPrecioNetoPedido();
		double iva = 0.19;
		int precioIvaPedido = (int) (precioNetoPedido * iva);
		
		return precioIvaPedido;
		
	}
	
	private String generarTextoFactura()
	{
		String textoFactura = "Factura del pedido" + idPedido + "\n";
		textoFactura += "Cliente:" + nombreCliente + "/n";
		textoFactura += "Dirección cliente:" + direccionCliente + "/n";
		textoFactura += "Pedido: /n";
		for (Producto producto: productos)
		{
			textoFactura += producto.getNombre()+ " $" +producto.getPrecio() + "/n";
		}
		
		textoFactura += "Precio neto: $" + getPrecioNetoPedido() + "/n";
		textoFactura += "IVA (19%): $" + getPrecioIvaPedido() + "/n";
		textoFactura += "Precio total: $" + getPrecioTotalPedido() + "/n";
		
		return textoFactura;
	}
	
	public void guardarFactura(File archivo) throws IOException 
	{
		FileWriter writer = new FileWriter(archivo);
		String factura = generarTextoFactura();
		writer.write(factura);
		writer.close();
		System.out.println("El archivo esta" + archivo.getAbsolutePath());
			
		
	}
}
