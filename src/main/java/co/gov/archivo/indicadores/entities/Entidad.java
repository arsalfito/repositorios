package co.gov.archivo.indicadores.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name = "entidad")
public class Entidad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_entidad", nullable = false)
    private String nombreEntidad;

    @Column(name = "numero_dependencias", nullable = false)
    private Integer numeroDependencias;

    @OneToOne
    @JoinColumn(name = "representante_legal_id")
    private Persona representanteLegal;

    @ManyToOne
    @JoinColumn(name = "cargo_representante_id")
    private Parametro cargoRepresentante;
}
