package co.gov.archivo.indicadores.entities;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "auth_personas")
public class Persona1 implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_persona", nullable = false)
    private Parametro tipoPersona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_documento", nullable = false)
    private Parametro tipoDocumento;

    @Column(name = "documento", nullable = false, unique = true)
    private String documento;

    @Column(name = "nombre1")
    private String nombre1;

    @Column(name = "nombre2")
    private String nombre2;

    @Column(name = "apellido1")
    private String apellido1;

    @Column(name = "apellido2")
    private String apellido2;

    @Column(name = "nombre_completo")
    private String nombreCompleto;

    @Column(name = "fecha_creacion", nullable = false)
    private Date fechaCreacion;
    
    @Column(name = "correo", length = 150, nullable = false, unique = true)
	private String correo;

}