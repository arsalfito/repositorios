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
@Table(name = "datos_contacto")
public class DatosContacto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_contacto", nullable = false)
    private Parametro tipoContacto;

    @Column(name = "datoContacto", nullable = false)
    private String datoContacto;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_responsable_documental", nullable = true)
    private ResponsableGestionDocumental responsable;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_entidad", nullable = true)
    private Entidad entidad;
}

