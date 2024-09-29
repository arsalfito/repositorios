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
@Table(name = "temas")
public class Tema implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tema", nullable = false)
    private String tema;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_subcomponente", nullable = true)
    private SubComponente subComponente;
}
