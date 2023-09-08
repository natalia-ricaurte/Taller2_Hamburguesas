package uniandes.dpoo.taller1.procesamiento;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import uniandes.dpoo.taller1.modelo.Combo;
import uniandes.dpoo.taller1.modelo.Ingrediente;
import uniandes.dpoo.taller1.modelo.Pedido;
import uniandes.dpoo.taller1.modelo.ProductoMenu;




public class Restaurante {

	private ArrayList<Ingrediente> ingredientes;
	private ArrayList<ProductoMenu> menuBase;
	private ArrayList<Combo> combos;
	private ArrayList <Pedido> pedidos;
	private Pedido pedidoEnCurso;
	
	public Restaurante()
	{
		ingredientes = new ArrayList<Ingrediente>();
		menuBase = new ArrayList<ProductoMenu>();
		pedidos = new ArrayList<Pedido>();
		combos = new ArrayList<Combo>();
		
		try
		{
		cargarInformacionRestaurante(new File("./data/ingredientes.txt"), new File("./data/menu.txt"), 
				new File("./data/combos.txt"));
									
		
		}
		catch (FileNotFoundException e)
		{
			System.out.println("ERROR: el archivo indicado no se encontró.");
		}
		catch (IOException e)
		{
			System.out.println("ERROR: hubo un problema leyendo el archivo.");
			System.out.println(e.getMessage());
		}
	}
	
	public void iniciarPedido(String nombreCliente, String direccionCliente)
	{
		pedidoEnCurso = new Pedido(nombreCliente, direccionCliente);
		
	}
	
	public void cerrarYGuardarPedido()
	{
		if (pedidoEnCurso == null)
		{
			System.out.println("No hay pedido");
		}
		else 
		{
			Pedido pedido = getPedidoEnCurso();
			pedidos.add(pedido);
			
		}
	}
	
	public Pedido getPedidoEnCurso()
	{
		return pedidoEnCurso;
	}
	
	public ArrayList<ProductoMenu> getMenuBase()
	{
		return menuBase;
	}
	
	public ArrayList<Ingrediente> getIngredientes()
	{
		return ingredientes;
	}
	
	public void cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu,File archivoCombos) throws FileNotFoundException, IOException
	{
		cargarIngredientes(archivoIngredientes);
		cargarMenu(archivoMenu);
		cargarCombos(archivoCombos);
		
	}

	private void cargarIngredientes(File archivoIngredientes) throws FileNotFoundException, IOException
	{
		
		BufferedReader br = new BufferedReader(new FileReader(archivoIngredientes));
		String linea;	
		
		linea = br.readLine();
		
		while(linea != null)
		{
			String[] partes = linea.split(";");
			
			String nombre = partes[0];
			int precioPro = Integer.parseInt(partes[1]);
			Ingrediente nuevo = new Ingrediente(nombre,precioPro); 
			ingredientes.add(nuevo);
			linea = br.readLine();
		}
			
		br.close();
	
	
	}
	
	private void cargarMenu(File archivoMenu) throws FileNotFoundException, IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(archivoMenu));
		String linea;	
		
		linea = br.readLine();
		
		while(linea != null)
		{
			String[] partes = linea.split(";");
			
			String nombre = partes[0];
			int precioPro = Integer.parseInt(partes[1]);
			ProductoMenu nuevo = new ProductoMenu(nombre,precioPro); 
			menuBase.add(nuevo);
			linea = br.readLine();
		}
			
		br.close();
		
		
	}
	private void cargarCombos(File archivoCombos)throws FileNotFoundException, IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(archivoCombos));
		String linea;	
		
		linea = br.readLine();
		
		while(linea != null)
		{
			String[] partes = linea.split(";");
			
			if (partes .length >= 2) 
			{
				String nombreCombo = partes[0];
				String descuentoTotal = partes[1].replaceAll("%","");
				System.out.println(descuentoTotal);
				Double descuento = Double.parseDouble(descuentoTotal);
				
				Combo nuevo = new Combo(descuento,nombreCombo); 
				combos.add(nuevo);
				linea = br.readLine();
			}
		}
			
			
		br.close();
	}
	
	
}
