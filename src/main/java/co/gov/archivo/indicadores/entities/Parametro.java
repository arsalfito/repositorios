package co.gov.archivo.indicadores.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "parametros")
public class Parametro implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "id_entidad", nullable = true)
	private Long idEntidad;
	
    @Column(name = "descripcion", nullable = false)
	private String descripcion;
    
    @Column(name = "parametro", nullable = false)
    private Long parametro;
    
    @Column(name = "parent", nullable = true)
    private Long parent;
    
    @Column(name = "value", nullable = true)
    private String value;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_parametro", nullable = true)
    private TipoParametro tipoParametro;
    
    public Parametro(Long id) {
    	this.id = id;
    }
}
