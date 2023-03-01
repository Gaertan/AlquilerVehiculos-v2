package org.iesalandalus.programacion.alquilervehiculos.vista;

import javax.naming.OperationNotSupportedException;

public enum Accion {
	SALIR("Salir"){public void ejecutar() {
					vista.terminar();
	}},
	
	
	INSERTAR_CLIENTE("Insertar cliente"){

		@Override
		protected void ejecutar() {
			// TODO Auto-generated method stub
			vista.insertarCliente();
		}},
	INSERTAR_TURISMO("Insertar vehiculo"){

		@Override
		protected void ejecutar() {
			// TODO Auto-generated method stub
			vista.insertarVehiculo();
		}},
	INSERTAR_ALQUILER("Insertar alquiler"){

		@Override
		protected void ejecutar() {
			// TODO Auto-generated method stub
			vista.insertarAlquiler();
		}},
	BUSCAR_CLIENTE("Buscar cliente"){

		@Override
		protected void ejecutar() {
			// TODO Auto-generated method stub
			vista.buscarCliente();
		}},
	BUSCAR_TURISMO("Buscar vehiculo"){

		@Override
		protected void ejecutar() {
			// TODO Auto-generated method stub
			vista.buscarTurismo();
		}},
	BUSCAR_ALQUILER("Buscar alquiler"){

		@Override
		protected void ejecutar() {
			// TODO Auto-generated method stub
			vista.buscarAlquiler();
			
		}},
	MODIFICAR_CLIENTE("Modificar cliente"){

		@Override
		protected void ejecutar() {
			// TODO Auto-generated method stub
			vista.modificarCliente();
		}},
	DEVOLVER_ALQUILER("Devolver alquiler"){

		@Override
		protected void ejecutar() {
			// TODO Auto-generated method stub
			vista.devolverAlquiler();
		}},
	BORRAR_CLIENTE("Borrar cliente"){

		@Override
		protected void ejecutar() {
			// TODO Auto-generated method stub
			vista.borrarCliente();
		}},
	BORRAR_TURISMO("Borrar vehiculo"){

		@Override
		protected void ejecutar() {
			// TODO Auto-generated method stub
			vista.borrarTurismo();
		}},
	BORRAR_ALQUILER("Borrar alquiler"){

		@Override
		protected void ejecutar() {
			// TODO Auto-generated method stub
			vista.borrarAlquiler();
		}},
	LISTAR_CLIENTES("Listar clientes"){

		@Override
		protected void ejecutar() {
			// TODO Auto-generated method stub
			vista.listarCliente();
		}},
	LISTAR_TURISMOS("Listar vehiculo"){

		@Override
		protected void ejecutar() {
			// TODO Auto-generated method stub
			vista.listarTurismo();
		}},
	LISTAR_ALQUILERES("Listar alquileres"){

		@Override
		protected void ejecutar() {
			// TODO Auto-generated method stub
			vista.listarAlquiler();
		}},
	LISTAR_ALQUILERES_CLIENTES("Listar alquileres de clientes"){

		@Override
		protected void ejecutar() {
			// TODO Auto-generated method stub
			vista.listarAlquileresCliente();
		}},
	LISTAR_ALQUILERES_TURISMO("Listar alquileres de vehiculos"){

		@Override
		protected void ejecutar() {
			// TODO Auto-generated method stub
			vista.listarAlquileresTurismo();
		}};
	protected Vista vista;
	private String cadenaAmostrar;

	Accion(String cadenaAmostrar){this.cadenaAmostrar=cadenaAmostrar;}

	private boolean esOrdinalValido(int ordinal) {
		return(ordinal>=0&&ordinal<Accion.values().length);

	}

	public Accion get(int ordinal) throws OperationNotSupportedException {
		if(esOrdinalValido(ordinal)) {return Accion.values()[ordinal];}else throw new OperationNotSupportedException("No se encuentra el ordinal insertado(fuera de rango)");
	}



	protected void setVista(Vista vista) {this.vista=vista;}
	
	protected abstract void ejecutar();




	@Override
	public String toString() {return this.cadenaAmostrar;}

}
