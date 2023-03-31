package org.iesalandalus.programacion.alquilervehiculos.vista.texto;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IClientes;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;
import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.vista.texto.Accion;
import org.iesalandalus.programacion.alquilervehiculos.vista.texto.Consola;

public class VistaTexto extends Vista {
	

	 public void comenzar() {
		Accion accion = null;
	
		do {
	
		while (accion==null) {
			Consola.mostrarMenu();
			try {accion = Consola.elegirOpcion();} catch (OperationNotSupportedException e){e.getMessage();}
	
				if(accion!=null) {
					switch(accion) {
					  case INSERTAR_CLIENTE:
					    insertarCliente();
						  accion = null;break;
					  case INSERTAR_TURISMO:
						 insertarVehiculo();
							  accion = null;break;
	
					  case INSERTAR_ALQUILER:
						    insertarAlquiler();
							  accion = null;break;
	
					  case BUSCAR_CLIENTE:
						   buscarCliente();
							  accion = null;break;
	
					  case BUSCAR_TURISMO:
						    buscarTurismo();
							  accion = null;break;
	
					  case BUSCAR_ALQUILER:
						   	buscarAlquiler();
							  accion = null;break;
	
					  case MODIFICAR_CLIENTE:
						    modificarCliente();
							  accion = null;break;
	
					  case DEVOLVER_ALQUILER:
						   	devolverAlquiler();
							  accion = null;break;
	
					  case BORRAR_CLIENTE:
						    borrarCliente();
							  accion = null;break;
	
					  case BORRAR_TURISMO:
						    borrarTurismo();
							  accion = null;break;
	
					  case BORRAR_ALQUILER:
						    borrarAlquiler();
							  accion = null;break;
					  case LISTAR_CLIENTES:
						    listarCliente();
							  accion = null;break;
					  case LISTAR_TURISMOS:
						    listarTurismo();
							  accion = null;break;
					  case LISTAR_ALQUILERES:
						    listarAlquiler();
							  accion = null;break;
					  case LISTAR_ALQUILERES_CLIENTES:
						    listarAlquileresCliente();
							  accion = null;break;
					  case LISTAR_ALQUILERES_TURISMO:
						    listarAlquileresTurismo();
							  accion = null;break;
	
					  default:
					   accion = Accion.SALIR;
					}
				}
			}
	
	
	
	
	
		} while (accion != Accion.SALIR);
		terminar();
	
	}

	public void terminar() {System.out.println("Hasta aqui la ejecucion del programa");}


	protected void insertarCliente() {

		Consola.mostrarCabecera("Accion insertar cliente");
		Cliente cliente = Consola.leerCliente();

		try{controlador.insertar(cliente);}catch(Exception e) {System.out.println(e.getMessage());}
	}

	protected void insertarVehiculo() {
		Consola.mostrarCabecera("Accion insertar vehiculo");
		Vehiculo vehiculo = Consola.leerVehiculo();

		try{controlador.insertar(vehiculo);}catch(Exception e) {System.out.println(e.getMessage());}}

	protected void insertarAlquiler() {
		Consola.mostrarCabecera("Accion insertar alquiler");
		Alquiler alquiler = Consola.leerAlquiler();

		try{controlador.insertar(alquiler);}catch(Exception e) {System.out.println(e.getMessage());}}

	protected void buscarCliente() {
		Consola.mostrarCabecera("Accion buscar cliente");
		Cliente cliente = Consola.leerClienteDni();
		try{cliente=controlador.buscar(cliente);System.out.println(cliente);}catch(Exception e) {System.out.println(e.getMessage());}

	}

	protected void buscarTurismo() {
		Consola.mostrarCabecera("Accion buscar vehiculo");
		Vehiculo turismo = Consola.leerTurismoMatricula();
		try{turismo = controlador.buscar(turismo);System.out.println(turismo); }catch(Exception e) {System.out.println(e.getMessage());}
	}

	protected void buscarAlquiler() {
		Consola.mostrarCabecera("Accion buscar alquiler");
		Alquiler alquiler = Consola.leerAlquiler();
		try{alquiler = controlador.buscar(alquiler);System.out.println(alquiler);}catch(Exception e) {System.out.println(e.getMessage());}

	}

	protected void modificarCliente() {
		Consola.mostrarCabecera("Accion modificar cliente");
		Cliente cliente = Consola.leerClienteDni();
		String nombre = Consola.leerNombre();
		String telefono = Consola.leerTelefono();
		try{controlador.modificar(cliente, nombre, telefono);}catch(Exception e) {System.out.println(e.getMessage());}
	}

	protected void devolverAlquiler() {
		Consola.mostrarCabecera("Accion devolver alquiler");
		Alquiler alquiler = Consola.leerAlquiler();
		LocalDate fechaDevolucion = Consola.leerFechaDevolucion();
		try{controlador.devolver(alquiler, fechaDevolucion);}catch(Exception e) {System.out.println(e.getMessage());}

	}

	protected void borrarCliente() {
		Consola.mostrarCabecera("Accion borrar cliente");
		Cliente cliente = Consola.leerClienteDni();
		try{controlador.borrar(cliente);}catch(Exception e) {System.out.println(e.getMessage());}
	}

	protected void borrarTurismo() {
		Consola.mostrarCabecera("Accion borrar vehiculo");
		Vehiculo turismo = Consola.leerTurismoMatricula();
		try{controlador.borrar(turismo);}catch(Exception e) {System.out.println(e.getMessage());}
	}

	protected void borrarAlquiler() {
		Consola.mostrarCabecera("Accion borrar alquiler");
		Alquiler alquiler = Consola.leerAlquiler();
		try{controlador.borrar(alquiler);}catch(Exception e) {System.out.println(e.getMessage());}

	}

	protected void listarCliente() {
		Consola.mostrarCabecera("Accion listar clientes");
		//Cliente cliente = Consola.leerCliente();
		
		
		
		List<Cliente> clientes = controlador.getClientes();	
		Collections.sort(clientes);
		Iterator<Cliente> itListaClientes=clientes.iterator();

        while (itListaClientes.hasNext()) {
            Cliente cliente=itListaClientes.next();
            System.out.println(cliente); }
		
		//try{System.out.println(controlador.getClientes());}catch(Exception e) {System.out.println(e.getMessage());}
	}

	protected void listarTurismo() {
		Consola.mostrarCabecera("Accion listar todos los vehiculos");
		//Turismo turismo = Consola.leerTurismo();
		
		List<Vehiculo> vehiculos = controlador.getVehiculos();
		Collections.sort(vehiculos);
		Iterator<Vehiculo> itListaVehiculos=vehiculos.iterator();

        while (itListaVehiculos.hasNext()) {
            Vehiculo vehiculo=itListaVehiculos.next();
            System.out.println(vehiculo); }
		
		
		//try{System.out.println(controlador.getVehiculos());}catch(Exception e) {System.out.println(e.getMessage());}
	}

	protected void listarAlquiler() {
		Consola.mostrarCabecera("Accion listar alquileres");

		List<Alquiler> alquileres = controlador.getAlquileres();
		Collections.sort(alquileres);
		Iterator<Alquiler> itListaAlquileres=alquileres.iterator();

        while (itListaAlquileres.hasNext()) {
        	Alquiler alquiler=itListaAlquileres.next();
            System.out.println(alquiler); }
		
		
		//try{System.out.println(controlador.getAlquileres());}catch(Exception e) {System.out.println(e.getMessage());}

	}

	protected void listarAlquileresCliente() {
		Consola.mostrarCabecera("Accion listar alquileres de un cliente");
		Cliente cliente = Consola.leerClienteDni();
		

		List<Alquiler> alquileres = controlador.getAlquileres(cliente);
		Collections.sort(alquileres);
		Iterator<Alquiler> itListaAlquileres=alquileres.iterator();

        while (itListaAlquileres.hasNext()) {
        	Alquiler alquiler=itListaAlquileres.next();
            System.out.println(alquiler); }
		
	//	try{System.out.println(controlador.getAlquileres(cliente));}catch(Exception e) {System.out.println(e.getMessage());}
	}

	protected void listarAlquileresTurismo() {
		Consola.mostrarCabecera("Accion listar alquileres de un vehiculo");
		Vehiculo turismo = Consola.leerTurismoMatricula();
		

		List<Alquiler> alquileres = controlador.getAlquileres(turismo);
		Collections.sort(alquileres);
		Iterator<Alquiler> itListaAlquileres=alquileres.iterator();

        while (itListaAlquileres.hasNext()) {
        	Alquiler alquiler=itListaAlquileres.next();
            System.out.println(alquiler); }
        
        
		//try{System.out.println(controlador.getAlquileres(turismo));}catch(Exception e) {System.out.println(e.getMessage());}
	}












}
