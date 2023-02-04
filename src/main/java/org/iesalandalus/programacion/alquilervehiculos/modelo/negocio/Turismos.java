package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquileres;



public class Turismos {

	private List<Alquileres> coleccionTurismos;
	
	public Turismos() {coleccionTurismos = new ArrayList<>();}
	
	public List<Alquileres> get(){return coleccionTurismos;}
	
	public int getCantidad() {
		int cantidad = 0;
	try {cantidad = coleccionTurismos.size();}catch(Exception e) {}
		return cantidad;
	}
	
	public void insertar(Alquileres turismo) throws OperationNotSupportedException {
		if (turismo == null) {
			throw new NullPointerException("ERROR: No se puede insertar un turismo nulo.");
		}
		if (coleccionTurismos.indexOf(turismo) == -1) {
			coleccionTurismos.add(turismo);
		} else {
			throw new OperationNotSupportedException("ERROR: Ya existe un turismo con esa matrícula.");
		}		
		

	}
	
	public Alquileres buscar(Alquileres turismo) {
		if (turismo == null) {
			throw new NullPointerException("ERROR: No se puede buscar un turismo nulo.");
		}
		Alquileres turismoB = null;
		if(coleccionTurismos.contains(turismo)) {
			turismoB = new Alquileres(coleccionTurismos.get(coleccionTurismos.indexOf(turismo)));}
		return turismoB;}
	
	public void borrar(Alquileres turismo) throws OperationNotSupportedException {
		if (turismo == null) {
			throw new NullPointerException("ERROR: No se puede borrar un turismo nulo.");
		}
		
		if(coleccionTurismos.contains(turismo)) {coleccionTurismos.remove(turismo);}
		else throw new OperationNotSupportedException("ERROR: No existe ningún turismo con esa matrícula.");
	}
}
