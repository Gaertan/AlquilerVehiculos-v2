

package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;



public class Turismos {

	private List<Turismo> coleccionTurismos;

	public Turismos() {coleccionTurismos = new ArrayList<>();}

	public List<Turismo> get(){
		ArrayList<Turismo> turismosR = new ArrayList<>(coleccionTurismos);
		return turismosR;
		}

	public int getCantidad() {
		int cantidad = 0;
	try {cantidad = coleccionTurismos.size();}catch(Exception e) {}
		return cantidad;
	}

	public void insertar(Turismo turismo) throws OperationNotSupportedException {
		if (turismo == null) {
			throw new NullPointerException("ERROR: No se puede insertar un turismo nulo.");
		}
		if (coleccionTurismos.indexOf(turismo) == -1) {
			coleccionTurismos.add(turismo);
		} else {
			throw new OperationNotSupportedException("ERROR: Ya existe un turismo con esa matrícula.");
		}


	}

	public Turismo buscar(Turismo turismo) {
		if (turismo == null) {
			throw new NullPointerException("ERROR: No se puede buscar un turismo nulo.");
		}
		Turismo turismoB = null;
		if(coleccionTurismos.contains(turismo)) {
			turismoB =(coleccionTurismos.get(coleccionTurismos.indexOf(turismo)));}
		return turismoB;}

	public void borrar(Turismo turismo) throws OperationNotSupportedException {
		if (turismo == null) {
			throw new NullPointerException("ERROR: No se puede borrar un turismo nulo.");
		}

		if(coleccionTurismos.contains(turismo)) {coleccionTurismos.remove(turismo);}
		else throw new OperationNotSupportedException("ERROR: No existe ningún turismo con esa matrícula.");
	}
}
