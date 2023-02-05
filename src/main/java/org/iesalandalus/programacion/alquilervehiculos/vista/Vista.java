package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.time.LocalDate;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

public class Vista {

	private Controlador controlador;
	
	
	public void setControlador(Controlador controlador) {
		if (controlador == null) {throw new NullPointerException("ERROR: El controlador no puede ser nulo.");}
		this.controlador = controlador;
	}
	
	
	public void comenzar() {
		Opcion opcion = null;
		
		do {					
			Consola.mostrarMenu();
		while (opcion==null) {
			try {opcion = Consola.elegirOpcion();} catch (OperationNotSupportedException e){e.getMessage();}
			
				if(opcion!=null) {
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
			}
		
		
		
		
		
		} while (opcion != Opcion.SALIR);
		terminar();
		
	}
	
	public void terminar() {System.out.println("Hasta aqui la ejecucion del programa");}
	
	private void insertarCliente() {
		
		Consola.mostrarCabecera("Opcion insertar cliente");
		Cliente cliente = Consola.leerCliente();
	
		try{controlador.insertar(cliente);}catch(Exception e) {e.getMessage();}
	}
	
	private void insertarTurismo() {		
		Consola.mostrarCabecera("Opcion insertar turismo");
		Turismo turismo = Consola.leerTurismo();
	
		try{controlador.insertar(turismo);}catch(Exception e) {e.getMessage();}}
	
	private void insertarAlquiler() {
		Consola.mostrarCabecera("Opcion insertar alquiler");
		Alquiler alquiler = Consola.leerAlquiler();
	
		try{controlador.insertar(alquiler);}catch(Exception e) {e.getMessage();}}
	
	private Cliente buscarCliente() {
		Consola.mostrarCabecera("Opcion buscar cliente");
		Cliente cliente = Consola.leerCliente();
		try{cliente=controlador.buscar(cliente);return cliente;}catch(Exception e) {e.getMessage();return null;}

	
	}
	
	private Turismo buscarTurismo() {
		Consola.mostrarCabecera("Opcion buscar turismo");
		Turismo turismo = Consola.leerTurismo();
		try{turismo = controlador.buscar(turismo);return turismo;}catch(Exception e) {e.getMessage();return null;}
	}
	
	private Alquiler buscarAlquiler() {
		Consola.mostrarCabecera("Opcion buscar alquiler");	
		Alquiler alquiler = Consola.leerAlquiler();
		try{alquiler = controlador.buscar(alquiler);return alquiler;}catch(Exception e) {e.getMessage();return null;}

	}
	
	private void modificarCliente() {
		Consola.mostrarCabecera("Opcion modificar cliente");
		Cliente cliente = Consola.leerCliente();
		String nombre = Consola.leerNombre();
		String telefono = Consola.leerTelefono();
		try{controlador.modificar(cliente, nombre, telefono);}catch(Exception e) {e.getMessage();}
	}
	
	private void devolverAlquiler() {
		Consola.mostrarCabecera("Opcion devolver alquiler");
		Alquiler alquiler = Consola.leerAlquiler();
		LocalDate fechaDevolucion = Consola.leerFechaDevolucion();
		try{controlador.devolver(alquiler, fechaDevolucion);}catch(Exception e) {e.getMessage();}		

	}
	
	private void borrarCliente() {
		Consola.mostrarCabecera("Opcion borrar cliente");
		Cliente cliente = Consola.leerCliente();
		try{controlador.borrar(cliente);}catch(Exception e) {e.getMessage();}
	}
	
	private void borrarTurismo() {
		Consola.mostrarCabecera("Opcion borrar turismo");
		Turismo turismo = Consola.leerTurismo();
		try{controlador.borrar(turismo);}catch(Exception e) {e.getMessage();}
	}
	
	private void borrarAlquiler() {
		Consola.mostrarCabecera("Opcion borrar alquiler");
		Alquiler alquiler = Consola.leerAlquiler();
		try{controlador.borrar(alquiler);}catch(Exception e) {e.getMessage();}

	}
	
	private void listarCliente() {
		Consola.mostrarCabecera("Opcion listar clientes");
		Cliente cliente = Consola.leerCliente();
		try{System.out.println(controlador.getClientes(cliente).toString());}catch(Exception e) {e.getMessage();}
	}
	
	private void listarTurismo() {
		Consola.mostrarCabecera("Opcion listar todos los turismos");
		Turismo turismo = Consola.leerTurismo();
		try{System.out.println(controlador.getTurismos(turismo).toString());}catch(Exception e) {e.getMessage();}
	}
	
	private void listarAlquiler() {
		Consola.mostrarCabecera("Opcion listar alquileres");
		Alquiler alquiler = Consola.leerAlquiler();
		try{System.out.println(controlador.getAlquileres(alquiler).toString());}catch(Exception e) {e.getMessage();}

	}
	
	private void listarAlquileresCliente() {
		Consola.mostrarCabecera("Opcion listar alquileres de un cliente");
		Cliente cliente = Consola.leerCliente();
		try{System.out.println(controlador.getAlquileres(cliente).toString());}catch(Exception e) {e.getMessage();}
	}
	
	private void listarAlquileresTurismo() {
		Consola.mostrarCabecera("Opcion listar alquileres de un turismo");
		Turismo turismo = Consola.leerTurismo();
		try{System.out.println(controlador.getAlquileres(turismo).toString());}catch(Exception e) {e.getMessage();}
	}

	
	
	
	
	
	
	
	
	
	
	
}
