

package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;



public class Vehiculos {

	private List<Vehiculo> coleccionVehiculos;

	public Vehiculos() {coleccionVehiculos = new ArrayList<>();}

	public List<Vehiculo> get(){
		ArrayList<Vehiculo> vehiculosR = new ArrayList<>(coleccionVehiculos);
		return vehiculosR;
		}

	public int getCantidad() {
		int cantidad = 0;
	try {cantidad = coleccionVehiculos.size();}catch(Exception e) {}
		return cantidad;
	}

	public void insertar(Vehiculo vehiculo) throws OperationNotSupportedException {
		if (vehiculo == null) {
			throw new NullPointerException("ERROR: No se puede insertar un vehiculo nulo.");
		}
		if (coleccionVehiculos.indexOf(vehiculo) == -1) {
			coleccionVehiculos.add(vehiculo);
		} else {
			throw new OperationNotSupportedException("ERROR: Ya existe un vehiculo con esa matrícula.");
		}


	}

	public Vehiculo buscar(Vehiculo vehiculo) {
		if (vehiculo == null) {
			throw new NullPointerException("ERROR: No se puede buscar un vehiculo nulo.");
		}
		Vehiculo vehiculoB = null;
		if(coleccionVehiculos.contains(vehiculo)) {
			vehiculoB =(coleccionVehiculos.get(coleccionVehiculos.indexOf(vehiculo)));}
		return vehiculoB;}

	public void borrar(Vehiculo vehiculo) throws OperationNotSupportedException {
		if (vehiculo == null) {
			throw new NullPointerException("ERROR: No se puede borrar un vehiculo nulo.");
		}

		if(coleccionVehiculos.contains(vehiculo)) {coleccionVehiculos.remove(vehiculo);}
		else throw new OperationNotSupportedException("ERROR: No existe ningún vehiculo con esa matrícula.");
	}
}
