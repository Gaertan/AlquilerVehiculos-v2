package org.iesalandalus.programacion.alquilervehiculos;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.FactoriaFuenteDatos;
import org.iesalandalus.programacion.alquilervehiculos.modelo.Modelo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.ModeloCascada;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Vista vista = new Vista();
		Modelo modeloCascada = new ModeloCascada(FactoriaFuenteDatos.MEMORIA.crear());
		Controlador controlador = new Controlador(modeloCascada, vista);

		controlador.comenzar();






	}

}
