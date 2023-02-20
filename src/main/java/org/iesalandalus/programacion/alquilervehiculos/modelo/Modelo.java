package org.iesalandalus.programacion.alquilervehiculos.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Alquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Clientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Turismos;


public class Modelo {

	private Alquileres alquileres;
	private Clientes clientes;
	private Turismos turismos;

	public Modelo(){
		comenzar();
	}

	public void comenzar(){
		alquileres = new Alquileres() ;
		clientes = new Clientes() ;
		turismos = new Turismos() ;
	}

	public void terminar() {System.out.println("la ejecucion del modelo ha terminado");}

	public void insertar(Cliente cliente) throws OperationNotSupportedException {
	/*	if(cliente==null) {throw new NullPointerException("ERROR: No existe el cliente del alquiler.");}
		if(buscar(cliente)!=null) {

			try {Cliente cliente2	=	 new Cliente(cliente);
				clientes.insertar(cliente2);
			} catch (OperationNotSupportedException e) {e.getMessage();}

		}*/
		Cliente cliente2	=	 new Cliente(cliente);
		clientes.insertar(cliente2);


	}
	public void insertar(Turismo turismo) throws OperationNotSupportedException {
	/*	if(turismo==null) {throw new NullPointerException("ERROR: No existe el turismo del alquiler.");}
		Turismo turismo2 = new Turismo(turismo);
		try {
			turismos.insertar(turismo2);
		} catch (OperationNotSupportedException e) {e.getMessage();}*/
		Turismo turismo2 = new Turismo(turismo);
		turismos.insertar(turismo2);
	}
	public void insertar(Alquiler alquiler) throws OperationNotSupportedException{/*
		if(alquiler==null) {throw new NullPointerException("ERROR: No se puede realizar un alquiler nulo.");}
		Alquiler alquiler2 = new Alquiler(alquileres.buscar(alquiler));
		try{alquileres.insertar(alquiler2);}catch(Exception e)	{e.getMessage();}*/

		//busca que existan clientes o turismos ya insertados(metodos buscar) y crea un nuevo alquiler a partir de estos y la fecha del alquiler dado

		Alquiler alquiler2 = new Alquiler(buscar(alquiler.getCliente()),buscar(alquiler.getTurismo()),alquiler.getFechaAlquiler());
		alquileres.insertar(alquiler2);

	}


	//metodos buscar, comprueban si existe una entidad en las listas y devuelven una copia(o nulo si no)
	public Cliente buscar(Cliente cliente) {Cliente clienteR = new Cliente(clientes.buscar(cliente));return clienteR;}

	public Turismo buscar(Turismo turismo) {Turismo turismoR = new Turismo(turismos.buscar(turismo));return turismoR;}

	public Alquiler buscar(Alquiler alquiler) {Alquiler alquilerR = new Alquiler(alquileres.buscar(alquiler));return alquilerR;}

	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {clientes.modificar(cliente, nombre, telefono);}

	public void devolver(Alquiler alquiler,	LocalDate fechaDevolucion) throws NullPointerException, OperationNotSupportedException {
		if(alquileres.buscar(alquiler)==null) {throw new OperationNotSupportedException("ERROR: No existe el alquiler a devolver.");}
		alquileres.devolver(alquiler, fechaDevolucion);
		/*try {
		alquileres.devolver(alquiler, fechaDevolucion);
	} catch (NullPointerException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (OperationNotSupportedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	*/
}



	public void borrar(Cliente cliente) throws OperationNotSupportedException {

		//borramos todos los alquileres pertenecientes al cliente
		for(Alquiler alq:getAlquileres(cliente)) {
			if(alq.getCliente().equals(cliente)) {alquileres.borrar(alq);}

		}
		for(Cliente clie:getClientes()) {
			if(clie.equals(cliente)) {clientes.borrar(clie);}

		}
	}

	public void borrar(Turismo turismo) throws OperationNotSupportedException {		//borramos todos los alquileres pertenecientes al cliente
		for(Alquiler alq:getAlquileres(turismo)) {
			if(alq.getTurismo().equals(turismo)) {alquileres.borrar(alq);}

		}
		for(Turismo turi:getTurismos()) {
			if(turi.equals(turismo)) {turismos.borrar(turismo);}

		}}

	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {alquileres.borrar(alquiler);}


	public List<Cliente> getClientes( ){

		List<Cliente> clientesR = new ArrayList<>();
		for (Cliente cliente : clientes.get()) {
			if (cliente != null ) {
				clientesR.add	(new Cliente	(cliente));
			}
			}
		return clientesR;	
	
	}

	public List<Turismo> getTurismos(){

		List<Turismo> turismosR = new ArrayList<>();
		for (Turismo turismo : turismos.get()) {
			if (turismo != null ) {
				turismosR.add	(new Turismo	(turismo));
			}
			}
		return turismosR;}

	public List<Alquiler> getAlquileres(){	
			List<Alquiler> alquilerR = new ArrayList<>();
		for (Alquiler alquiler : alquileres.get()) {
			if (alquiler != null ) {
				alquilerR.add	(new Alquiler	(alquiler));
		}
			}
		return alquilerR;
	}

	public List<Alquiler> getAlquileres(Cliente cliente){
		List<Alquiler> alquilerR = new ArrayList<>();
	for (Alquiler alquiler : alquileres.get(cliente)) {
		if (alquiler != null ) {
			alquilerR.add	(new Alquiler	(alquiler));
		}
	}
	return alquilerR;
		
		
	}

	public List<Alquiler> getAlquileres(Turismo turismo){	
		List<Alquiler> alquilerR = new ArrayList<>();
	for (Alquiler alquiler : alquileres.get(turismo)) {
		if (alquiler != null ) {
			alquilerR.add	(new Alquiler	(alquiler));
		}
	}
	return alquilerR;
		
		}


}
