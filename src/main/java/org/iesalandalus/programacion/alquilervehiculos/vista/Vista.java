package org.iesalandalus.programacion.alquilervehiculos.vista;



public class Vista {

	private Controlador controlador;
	
	
	public void setControlador(Controlador controlador) {
		if (controlador == null) {throw new NullPointerException("ERROR: El controlador no puede ser nulo.");}
		this.controlador = controlador;
	}
	
	
	public void comenzar() {
		Opcion opcion;
		
		do {					
			Consola.mostrarMenu();
		while (opcion==null) {
			opcion = Consola.elegirOpcion();
			switch(opcion) {
			  case INSERTAR_CLIENTE:
			    insertarCliente();
				  opcion = null;break;
			  case INSERTAR_TURISMO:
				 insertarTurismo();
					  opcion = null;break;

			  case INSERTAR_ALQUILER:
				    insertarAlquiler();
					  opcion = null;break;
					  
			  case BUSCAR_CLIENTE:
				   buscarCliente();
					  opcion = null;break;
					  
			  case BUSCAR_TURISMO:
				    buscarTurismo();
					  opcion = null;break;
					  
			  case BUSCAR_ALQUILER:
				   	buscarAlquiler();
					  opcion = null;break;
					  
			  case MODIFICAR_CLIENTE:
				    modificarCliente();
					  opcion = null;break;
					  
			  case DEVOLVER_ALQUILER:
				   	devolverAlquiler();
					  opcion = null;break;
					  
			  case BORRAR_CLIENTE:
				    borrarCliente();
					  opcion = null;break;
					  
			  case BORRAR_TURISMO:
				    borrarTurismo();
					  opcion = null;break;
					  
			  case BORRAR_ALQUILER:
				    borrarAlquiler();
					  opcion = null;break;
			  case LISTAR_CLIENTES:
				    listarCliente();
					  opcion = null;break;
			  case LISTAR_TURISMOS:
				    listarTurismo();
					  opcion = null;break;
			  case LISTAR_ALQUILERES:
				    listarAlquiler();
					  opcion = null;break;
			  case LISTAR_ALQUILERES_CLIENTES:
				    listarAlquileresCliente();
					  opcion = null;break;
			  case LISTAR_ALQUILERES_TURISMO:
				    listarAlquileresTurismo();
					  opcion = null;break;
					  
			  default:
			   opcion = null;
			}
			
			}
		
		
		
		
		
		} while (opcion != Opcion.SALIR);
	}
	
	public void terminar() {}
	
	private void insertarCliente() {}
	
	private void insertarTurismo() {}
	
	private void insertarAlquiler() {}
	
	private void buscarCliente() {}
	
	private void buscarTurismo() {}
	
	private void buscarAlquiler() {}
	
	private void modificarCliente() {}
	
	private void devolverAlquiler() {}
	
	private void borrarCliente() {}
	
	private void borrarTurismo() {}
	
	private void borrarAlquiler() {}
	
	private void listarCliente() {}
	
	private void listarTurismo() {}
	
	private void listarAlquiler() {}
	
	private void listarAlquileresCliente() {}
	
	private void listarAlquileresTurismo() {}

	
	
	
	
	
	
	
	
	
	
	
}
