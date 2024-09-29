package co.gov.archivo.indicadores.entities;

import java.io.Serializable;
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
@Table(name = "habilita_pregunta")
public class HabilitaPregunta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "habilita_pregunta", nullable = false)
    private Boolean habilitaPregunta;
    
    @Column(name = "deshabilita_pregunta", nullable = false)
    private Boolean deshabilitaPregunta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pregunta_habilita", nullable = true)
    private Pregunta preguntaHabilita;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pregunta_deshabilita", nullable = true)
    private Pregunta preguntaDeshabilita;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;
}