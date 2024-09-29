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
@Table(name = "sub_componentes")
public class SubComponente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subcomponente", nullable = false)
    private String subComponente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_componente", nullable = false)
    private Componente componente;
}
