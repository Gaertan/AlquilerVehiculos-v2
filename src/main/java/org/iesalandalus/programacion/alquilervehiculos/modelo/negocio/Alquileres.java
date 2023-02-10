package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

public class Alquileres {

	private List<Alquiler> coleccionAlquileres;

	public Alquileres() {coleccionAlquileres = new ArrayList<>();}

	public List<Alquiler> get(){return coleccionAlquileres;}

	public List<Alquiler> get(Cliente cliente){
		if(cliente==null) {throw new NullPointerException("ERROR: No se puede buscar un cliente nulo.");}
		List<Alquiler> coleccionCliente = new ArrayList<>() ;
		for (Alquiler alquiler : coleccionAlquileres) {
				if(alquiler.getCliente().equals(cliente)) {
					coleccionCliente.add(alquiler);}
			}
		return coleccionCliente;
		}

	public List<Alquiler> get(Turismo turismo){
		if(turismo==null) {throw new NullPointerException("ERROR: No se puede buscar un turismo nulo.");}
		List<Alquiler> coleccionTurismo = new ArrayList<>() ;
		for (Alquiler alquiler : coleccionAlquileres) {
				if(alquiler.getTurismo().equals(turismo)) {
					coleccionTurismo.add(alquiler);}
			}
		return coleccionTurismo;
		}

	public int getCantidad() {
		try{int cantidad = coleccionAlquileres.size();return cantidad;}
		catch(Exception e) {int cantidad=0;return cantidad;}}
	//GOTTA DO THIS ONE
	//GOTTA DO THIS ONE
	//GOTTA DO THIS ONE
	//GOTTA DO THIS ONE
	//GOTTA DO THIS ONE
	private boolean comprobarAlquiler(Cliente cliente,Turismo turismo,LocalDate fechaAlquiler) throws OperationNotSupportedException {
		//como llevaba desde las 3 am haciendo cosas hice el codigo para insertarle alquiler como parametros,oops
		//el codigo es optimizable/algo redundante por ello pero bueno, pasas que cosan
		Alquiler alquiler = new Alquiler(cliente,turismo,fechaAlquiler);

		boolean status = true;
		Cliente clienteB = alquiler.getCliente();
		Turismo turismoB = alquiler.getTurismo();

		for (Alquiler alquilerB : coleccionAlquileres) {

			if(clienteB.equals(alquilerB.getCliente())&&alquilerB.getFechaDevolucion()==null) {
					status = false;throw new OperationNotSupportedException("ERROR: El cliente tiene otro alquiler sin devolver.");
			}

			if(turismoB.equals(alquilerB.getTurismo())&&alquilerB.getFechaDevolucion()==null) {
				status = false;throw new OperationNotSupportedException("ERROR: El turismo está actualmente alquilado.");
			}



			if(clienteB.equals(alquilerB.getCliente())&&alquilerB.getFechaDevolucion().isAfter(alquiler.getFechaDevolucion())) {
					status = false;throw new OperationNotSupportedException("ERROR: El cliente tiene un alquiler posterior.");
			}

			if(turismoB.equals(alquilerB.getTurismo())&&alquilerB.getFechaDevolucion().isAfter(alquiler.getFechaDevolucion())) {
					status = false;throw new OperationNotSupportedException("ERROR: El turismo tiene un alquiler posterior.");
			}

		}


		return status;}

	public void insertar(Alquiler alquiler) {
		if(alquiler==null) {throw new NullPointerException("ERROR: No se puede insertar un alquiler nulo.");}
		try {
			if(comprobarAlquiler(alquiler.getCliente(),alquiler.getTurismo(),alquiler.getFechaAlquiler())) {coleccionAlquileres.add(alquiler);}
		} catch (OperationNotSupportedException e) {

			e.getMessage();
		}
	}

	public void devolver(Cliente cliente,LocalDate fechaDevolucion) {
		if(cliente==null||fechaDevolucion==null) {throw new NullPointerException("ERROR: No se puede devolver un alquiler nulo.");}

		for (Alquiler alquilerB : coleccionAlquileres) {

			if(alquilerB.getCliente().equals(cliente)) {
				try {alquilerB.devolver(fechaDevolucion);}
				catch (OperationNotSupportedException e) {e.getMessage();}}

		}
	}

	public Alquiler buscar(Alquiler alquiler) {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede buscar un alquiler nulo.");
		}

		if(coleccionAlquileres.contains(alquiler)) {
			Alquiler alquilerB = coleccionAlquileres.get(coleccionAlquileres.indexOf(alquiler));return alquilerB;}
		else {return null;}
		}

	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede borrar un alquiler nulo.");
		}

		if(coleccionAlquileres.contains(alquiler)) {coleccionAlquileres.remove(alquiler);}
		else throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual.");
		}





	}
