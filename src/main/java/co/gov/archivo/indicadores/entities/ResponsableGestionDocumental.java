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
@Table(name = "responsables_gestion_documental")
public class ResponsableGestionDocumental implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona; 
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_entidad", nullable = false)
    private Entidad entidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_role", nullable = false)
    private Parametro role;
}
