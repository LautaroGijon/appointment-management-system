package domain;

import enums.Specialty;

public class Service {
	
	
	private int codigo;
	private int duracion;
	private int monto;
	
	private String descripcion;
	
	private Specialty especialidadRequerida;
	
	
	
	//SETTER & GETTERS
	
	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public int getDuracion() {
		return duracion;
	}


	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}


	public int getMonto() {
		return monto;
	}


	public void setMonto(int monto) {
		this.monto = monto;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Specialty getEspecialidadRequerida() {
		return especialidadRequerida;
	}


	public void setEspecialidadRequerida(Specialty especialidadRequerida) {
		this.especialidadRequerida = especialidadRequerida;
	}


	//Constructor
	public Service(int codigo, int duracion, int monto, String descripcion, Specialty especialidadRequerida) {
	
		this.codigo = codigo;
		this.duracion = duracion;
		this.monto = monto;
		this.descripcion = descripcion;
		this.especialidadRequerida = especialidadRequerida;
	}
	
	
	public boolean mismoCodigo(int codigo2) {
		
		return this.codigo == codigo2;
	}
	
	
	

}
