package co.gov.archivo.indicadores.entities;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "respuestas")
public class Respuesta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_registro", nullable = false)
    private Date fechaRegistro;

    @Column(name = "anio_reporta", nullable = false)
    private Integer anioReporta;

    @Column(name = "valor", nullable = false)
    private String valor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pregunta", nullable = false)
    private Pregunta pregunta;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_entidad", nullable = false)
    private Entidad entidad;
}
