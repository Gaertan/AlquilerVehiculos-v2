package org.iesalandalus.programacion.alquilervehiculos.modelo;

import java.time.LocalDate;
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
	public Cliente buscar(Cliente cliente)throws OperationNotSupportedException {Cliente clienteR = new Cliente(clientes.buscar(cliente));return clienteR;}

	public Turismo buscar(Turismo turismo) throws OperationNotSupportedException{Turismo turismoR = new Turismo(turismos.buscar(turismo));return turismoR;}

	public Alquiler buscar(Alquiler alquiler)throws OperationNotSupportedException {Alquiler alquilerR = new Alquiler(alquileres.buscar(alquiler));return alquilerR;}

	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {clientes.modificar(cliente, nombre, telefono);}

	public void devolver(Alquiler alquiler,	LocalDate fechaDevolucion) {alquileres.devolver(alquiler.getCliente(), fechaDevolucion);}



	public void Borrar(Cliente cliente) throws OperationNotSupportedException {

		//borramos todos los alquileres pertenecientes al cliente
		for(Alquiler alq:getAlquileres(cliente)) {
			if(alq.getCliente().equals(cliente)) {alquileres.borrar(alq);}

		}
		for(Cliente clie:getClientes()) {
			if(clie.equals(cliente)) {clientes.borrar(clie);}

		}
	}

	public void Borrar(Turismo turismo) throws OperationNotSupportedException {		//borramos todos los alquileres pertenecientes al cliente
		for(Alquiler alq:getAlquileres(turismo)) {
			if(alq.getTurismo().equals(turismo)) {alquileres.borrar(alq);}

		}
		for(Turismo turi:getTurismos()) {
			if(turi.equals(turismo)) {turismos.borrar(turismo);}

		}}

	public void Borrar(Alquiler alquiler) throws OperationNotSupportedException {alquileres.borrar(alquiler);}


	public List<Cliente> getClientes(){return clientes.get();}

	public List<Turismo> getTurismos(){return turismos.get();}

	public List<Alquiler> getAlquileres(){return alquileres.get();}

	public List<Alquiler> getAlquileres(Cliente cliente){return alquileres.get(cliente);}

	public List<Alquiler> getAlquileres(Turismo turismo){return alquileres.get(turismo);}


}
