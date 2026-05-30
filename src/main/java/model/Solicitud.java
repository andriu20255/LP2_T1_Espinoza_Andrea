package model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_solicitud")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nro_solicitud")
    @EqualsAndHashCode.Include
    private Integer nroSolicitud;

   
    @ManyToOne
    @JoinColumn(name = "id_actividad")
    private Actividad actividad; 

    @Column(name = "estado")
    private String estado;

    @Column(name = "archivo_adjunto")
    private String archivoAdjunto;

    
    @Column(name = "fecha_reg")
    private LocalDateTime fechaReg;
    
    public String getEstadoDescripcion() {
              switch (estado) {
            case "PE": 
                return "Pendiente";
            case "AC": 
                return "Activo";
            case "AN": 
                return "Anulado";
            default:
                return "Desconocido";
        }
    }
	@Column(name= "detalleSolicitud")
	private String detalleSolicitud;
	
    @Override
    public String toString() {
        return nroSolicitud + "";
        
       
    }
}