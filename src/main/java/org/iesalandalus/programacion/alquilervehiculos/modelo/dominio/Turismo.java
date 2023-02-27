package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;


public class Turismo extends Vehiculo {
	private final int FACTOR_CILINDRADA = 10;
	private int cilindrada;
	
	
	public Turismo(String marca, String modelo, int cilindrada, String matricula) {

		super( marca,  modelo,  matricula);

		setCilindrada(cilindrada);
		
	}

	public Turismo(Turismo vehiculo) {
		super();
		if (vehiculo == null) {
			throw new NullPointerException("ERROR: No es posible copiar un turismo nulo.");
		}
		setMarca(vehiculo.getMarca());
		setModelo(vehiculo.getModelo());
		setCilindrada(vehiculo.getCilindrada());
		setMatricula(vehiculo.getMatricula());

	}
	private void setCilindrada(int cilindrada) {

		if((cilindrada<=0)||(cilindrada>5000)) {throw new IllegalArgumentException("ERROR: La cilindrada no es correcta.");}
		this.cilindrada=cilindrada;
	}

	public int getCilindrada() {return this.cilindrada;}
	

	@Override
	public Vehiculo getVehiculoConMatricula(String matricula){
		if (matricula==null) if (matricula == null) {throw new NullPointerException("ERROR: La matrícula no puede ser nula.");}
		return new Turismo("Seat","Leon",90,matricula);
	}

	@Override
	public String toString() {
		return (String.format("%s %s (%sCV) - %s", marca, modelo, cilindrada, matricula, "disponible"));
	}

	@Override
	protected int getFactorPrecio() {

		return cilindrada/FACTOR_CILINDRADA;
	}



}
