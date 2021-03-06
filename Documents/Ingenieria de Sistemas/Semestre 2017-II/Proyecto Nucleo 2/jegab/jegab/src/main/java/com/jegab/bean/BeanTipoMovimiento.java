package com.jegab.bean;
// default package
// Generated 15-sep-2017 0:05:55 by Hibernate Tools 5.2.5.Final

import java.util.HashSet;
import java.util.Set;

import javax.faces.bean.ManagedBean;

/**
 * TipoMovimiento generated by hbm2java
 */
@ManagedBean(name="tipomovimiento")
public class BeanTipoMovimiento implements java.io.Serializable {

	private int idtipoMovimiento;
	private String nombre;
	private Set<BeanMovimiento> movimientos = new HashSet<BeanMovimiento>(0);

	public BeanTipoMovimiento() {
	}

	public BeanTipoMovimiento(int idtipoMovimiento, String nombre) {
		this.idtipoMovimiento = idtipoMovimiento;
		this.nombre = nombre;
	}

	public BeanTipoMovimiento(int idtipoMovimiento, String nombre, Set<BeanMovimiento> movimientos) {
		this.idtipoMovimiento = idtipoMovimiento;
		this.nombre = nombre;
		this.movimientos = movimientos;
	}

	public int getIdtipoMovimiento() {
		return this.idtipoMovimiento;
	}

	public void setIdtipoMovimiento(int idtipoMovimiento) {
		this.idtipoMovimiento = idtipoMovimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<BeanMovimiento> getMovimientos() {
		return this.movimientos;
	}

	public void setMovimientos(Set<BeanMovimiento> movimientos) {
		this.movimientos = movimientos;
	}

}
