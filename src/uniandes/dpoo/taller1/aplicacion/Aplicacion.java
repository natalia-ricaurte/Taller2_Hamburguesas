package uniandes.dpoo.taller1.aplicacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import uniandes.dpoo.taller1.modelo.Pedido;
import uniandes.dpoo.taller1.modelo.ProductoMenu;
import uniandes.dpoo.taller1.procesamiento.Restaurante;
public class Aplicacion {
	
	private Restaurante restaurante;
	
	
	public static void main(String[] args)
	{
		
		Aplicacion aplicacion = new Aplicacion();
		aplicacion.restaurante = new Restaurante();
		aplicacion.ejecutarAplicacion();
		
	}
	
	public void mostrarMenu()
	{
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Mostrar el menú");
		System.out.println("2. Iniciar un nuevo pedido");
		System.out.println("3. Agregar un elemento a un pedido");
		System.out.println("4. Cerrar un pedido y guardar la factura");
		System.out.println("5. Consultar la información de un pedido dado su id");
		System.out.println("6. Salir de la aplicación\n");
	}
	
	public void ejecutarAplicacion()
	{
		System.out.println("Bienvenido al restaurante\n");

		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
			int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción "));
				
				if (opcion_seleccionada == 1)
				{
					ArrayList<ProductoMenu> menuBase = restaurante.getMenuBase();
					System.out.println("\n El menu del restaurante es: \n");
					
					int i = 1;
					for (ProductoMenu producto: menuBase) 
					{
						String nombre = producto.getNombre();
						int precio = producto.getPrecio();
						System.out.println(i + "-> " + nombre + " - $" + precio);	
						i++;

					}
				}
					
				else if(opcion_seleccionada == 2 && restaurante != null)
				{	
					String nombreCliente = input("Ingrese nombre del cliente ");
					String direcciónCliente = input("Ingrese dirección del cliente ");
					restaurante.iniciarPedido(nombreCliente, direcciónCliente);
					
				}
				else if(opcion_seleccionada == 3 && restaurante != null)
				{
					
					if(restaurante.getPedidoEnCurso() == null)
					{
						System.out.println("No ha realizado un pedio");
					}
					int opcion = Integer.parseInt(input("Seleccione un elemento del menú: "));
					
					ArrayList<ProductoMenu> menuBase = restaurante.getMenuBase();
					if (opcion >= 1 & opcion <= menuBase.size())
					{
						ProductoMenu productoAgregado = menuBase.get(opcion -1);
						restaurante.getPedidoEnCurso().agregarProducto(productoAgregado);
					}
					else
					{
						System.out.println("opción no válida");
					}
				
				}
				else if(opcion_seleccionada == 4 && restaurante != null)
				{
					Pedido pedidoEnCurso = restaurante.getPedidoEnCurso();
					if(pedidoEnCurso == null)
					{
						System.out.println("No ha realizado un pedio");
					}
					
					restaurante.cerrarYGuardarPedido();
					
				}
				
				else if(opcion_seleccionada == 5 && restaurante != null)
				{
					int idPedido = Integer.parseInt(input("Ingrese el ID del pedido de interés: "));
					Pedido pedido = restaurante.getPedidoEnCurso();
					
					if (pedido.idPedido() == idPedido)
					{
						
						System.out.println("Pedido:");
						System.out.println("Pedido consultado:" +idPedido);
					}
					
				}
				else if (opcion_seleccionada == 6)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				
				

			}
			
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}
	
	
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
}





