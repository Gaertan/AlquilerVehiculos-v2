

package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.ficheros;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IVehiculos;



public class Vehiculos implements IVehiculos {

	private static Vehiculos instance = new Vehiculos();
	private List<Vehiculo> coleccionVehiculos = new ArrayList<>();

	private Vehiculos() {}

	@Override
	public List<Vehiculo> get(){
		ArrayList<Vehiculo> vehiculosR = new ArrayList<>(coleccionVehiculos);
		return vehiculosR;
		}

	@Override
	public int getCantidad() {
		int cantidad = 0;
	try {cantidad = coleccionVehiculos.size();}catch(Exception e) {}
		return cantidad;
	}

	@Override
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

	@Override
	public Vehiculo buscar(Vehiculo vehiculo) {
		if (vehiculo == null) {
			throw new NullPointerException("ERROR: No se puede buscar un vehiculo nulo.");
		}
		Vehiculo vehiculoB = null;
		if(coleccionVehiculos.contains(vehiculo)) {
			vehiculoB =(coleccionVehiculos.get(coleccionVehiculos.indexOf(vehiculo)));}
		return vehiculoB;}

	@Override
	public void borrar(Vehiculo vehiculo) throws OperationNotSupportedException {
		if (vehiculo == null) {
			throw new NullPointerException("ERROR: No se puede borrar un vehiculo nulo.");
		}

		if(coleccionVehiculos.contains(vehiculo)) {coleccionVehiculos.remove(vehiculo);}
		else throw new OperationNotSupportedException("ERROR: No existe ningún vehiculo con esa matrícula.");
	}

	protected static IVehiculos getInstancia() {
	return instance ;
	}
}
