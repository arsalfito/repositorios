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
@Table(name = "preguntas")
public class Pregunta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_pregunta", nullable = false)
    private String numeroPregunta;

    @Column(name = "pregunta", nullable = false)
    private String pregunta;

    @Column(name = "orden", nullable = false)
    private Integer orden;

    @Column(name = "obligatoria", nullable = false)
    private Boolean obligatoria;

    @Column(name = "es_multiple", nullable = false)
    private Boolean esMultiple;
    
    @Column(name = "tipo_dato", nullable = false)
    private String tipoDato;

    @Column(name = "tiene_ponderacion", nullable = true)
    private Boolean tienePonderacion;        

    @Column(name = "valor_ponderacion", nullable = true)
    private Double valorPonderacion;

    @Column(name = "tiene_ponderacion_variable", nullable = false)
    private Boolean tienePonderacionVariable;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tema", nullable = false)
    private Tema tema;

    
}
