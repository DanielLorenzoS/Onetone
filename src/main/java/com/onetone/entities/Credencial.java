package com.onetone.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "credencial", uniqueConstraints = { @UniqueConstraint(columnNames = { "nombre" }) })
public class Credencial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String nombre;

	@NotNull
	private Long noCuenta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getNoCuenta() {
		return noCuenta;
	}

	public void setNoCuenta(Long noCuenta) {
		this.noCuenta = noCuenta;
	}

	/*
	 * @OneToOne(mappedBy = "credencial") private Alumno alumno;
	 */

}
