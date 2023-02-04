package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;



public class Clientes {
	
	private List<Cliente> coleccionClientes;
	public Clientes() {
		coleccionClientes = new ArrayList<>();
	}

	/*public Cliente[] get() {
		return (Cliente[]) coleccionClientes.toArray();
	}*/
	public List<Cliente> get(){return coleccionClientes;}
	
	public int getCantidad() {

		try{return coleccionClientes.size();}
		catch(Exception e) {
			int cantidad = 0;
			return  cantidad = 0;}
	}
	
	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede insertar un cliente nulo.");
		}
	//indexof devuelve -1 si no se encuentra, por tanto, si no devuelve -1 no inserta y lanza excepcion
		if (coleccionClientes.indexOf(cliente) == -1) {coleccionClientes.add(new Cliente(cliente));}
		else {throw new OperationNotSupportedException("ERROR: Ya existe un cliente con ese DNI.");}		
	}
	
	public Cliente buscar(Cliente cliente) {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede buscar un cliente nulo.");
		}
		if(coleccionClientes.indexOf(cliente)!=-1) {
			return new Cliente(coleccionClientes.get(coleccionClientes.indexOf(cliente)));
		}
		else return null;
	}
	
	public void borrar(Cliente cliente) throws OperationNotSupportedException {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede borrar un cliente nulo.");
		}
		
		if(coleccionClientes.indexOf(cliente)!=-1) {
			coleccionClientes.remove(coleccionClientes.indexOf(cliente));
		}
		else throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
	}
	
	public void modificar(Cliente cliente,String nombre,String telefono) throws OperationNotSupportedException {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede modificar un cliente nulo.");
		}
		
		if(coleccionClientes.contains(cliente)) {
			try {
				Cliente clienteInsert = new Cliente(nombre,cliente.getDni(),telefono);
				coleccionClientes.set(coleccionClientes.indexOf(cliente), clienteInsert);
			} catch (Exception e) {System.out.println("ERROR: No se pudo insertar el cliente");}
			
		}
		else throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
	}
	
	
}
