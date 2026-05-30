package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table( name ="tbl_actividad")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Actividad {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id_actividad")
	@EqualsAndHashCode.Include
	private Integer id_actividad;
	
	
	@Column (name = "descripcion")
	private String descripcion;
	
	@Column (name = "fecha_inicio")
	private LocalDate fechaInicio;
	
		
	@Column (name = "nro_vacantes")
	private Integer nroVacantes;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	
	@Override
	public String toString() {
		return descripcion;
	}

}

