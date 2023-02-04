package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.util.ArrayList;
import java.util.List;

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
	
}
