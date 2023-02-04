package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;

public class Turismo {
	private final String ER_MARCA="\\[A-Za-z](-|\\s|)?[a-zA-ZáéíóúüñÁÉÍÓÚÑ]+";
	private final String ER_MATRICULA="\\d{4}\s{0,1}([B-D]|[F-H]|[J-N]|[P-T]|[V-Z]){3}{4}";

	private String marca;
	private String modelo;
	private int cilindrada;
	private String matricula;

	public Turismo(String marca, String modelo, int cilindrada, String matricula) {

		setMarca(marca);
		setModelo(modelo);
		setCilindrada(cilindrada);
		setMatricula(matricula);
	}

	public Turismo(Turismo turismo) {
		if (turismo == null) {
			throw new NullPointerException("ERROR: No es posible copiar un turismo nulo.");
		}
		setMarca(turismo.getMarca());
		setModelo(turismo.getModelo());
		setCilindrada(turismo.getCilindrada());
		setMatricula(turismo.getMatricula());

	}
	private void setMarca(String marca){
		if (marca == null) {throw new NullPointerException("ERROR: La marca no puede ser nula.");}
		if(!marca.matches(ER_MARCA)) {throw new IllegalArgumentException("ERROR: La marca no tiene un formato válido.");}
		else{this.marca=marca;}}


	private void setModelo(String modelo) {
		if (modelo == null) {throw new NullPointerException("ERROR: El modelo no puede ser nula.");}
		modelo.trim();
		if(modelo=="") {throw new IllegalArgumentException("ERROR: El modelo no puede estar en blanco.");}
		else{this.modelo=modelo;}}


	private void setCilindrada(int cilindrada) {

		if((cilindrada<=0)||(cilindrada>5000)) {throw new IllegalArgumentException("ERROR: La cilindrada no es correcta.");}
		this.cilindrada=cilindrada;
	}


	private void setMatricula(String matricula) {
		if (matricula == null) {throw new NullPointerException("ERROR: La matrícula no puede ser nula.");}
		if(!matricula.matches(ER_MATRICULA)) {throw new IllegalArgumentException("ERROR: La matrícula no tiene un formato válido.");}
		this.matricula=matricula;
	}

	public String getMarca() {return this.marca;}
	public String getModelo() {return this.modelo;}
	public int getCilindrada() {return this.cilindrada;}
	public String getMatricula() {return this.matricula;}

	public Turismo getTurismoConMatricula(String matricula){
		if (matricula==null) if (matricula == null) {throw new NullPointerException("ERROR: La matrícula no puede ser nula.");}
		return new Turismo("Seat","Leon",90,matricula);
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		Turismo other = (Turismo) obj;
		return Objects.equals(matricula, other.matricula);
	}

	@Override
	public String toString() {
		return (String.format("%s %s (%sCV) - %s", marca, modelo, cilindrada, matricula, "disponible"));
	}



}
