package org.iesalandalus.programacion.alquilervehiculos.controlador;

import java.time.LocalDate;
import java.util.List;

import org.iesalandalus.programacion.alquilervehiculos.modelo.Modelo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;

public class Controlador {

	private Vista vista;
	private Modelo modelo;
	public void controlador(Modelo modelo, Vista vista){
		if(modelo!=null&&vista!=null) {this.modelo=modelo;this.vista=vista;};}
	
	public void  comenzar(){}
	
	public void  terminar(){}
	
	public void  insertar(Cliente cliente){}
	
	public void insertar(Turismo turismo){}
	
	public void  insertar(Alquiler alquiler){}
	
	public Cliente buscar(Cliente cliente){}
	
	public Turismo buscar(Turismo turismo){}
	
	public Alquiler buscar(Alquiler alquiler){}
	
	public void  modificar(Cliente cliente, String nombre, String telefono){}
	
	public void  devolver(Alquiler alquiler, LocalDate fechaDevolucion){}
	
	public void  borrar(Cliente cliente){}
	
	public void  borrar(Turismo turismo){}
	
	public void  borrar(Alquiler alquiler){}
	
	public List<Cliente> getClientes(Cliente cliente){}
	
	public List<Turismo> getTurismos(Turismo turismo){}
	
	public List<Alquiler> getAlquileres(Alquiler alquiler){}
	
	public List<Alquiler> getAlquileres(Cliente cliente){}
	
	public List<Alquiler> getAlquileres(Turismo turismo){}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
