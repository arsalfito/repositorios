package co.gov.archivo.indicadores.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ParamDto {
  private Long id;
  private String display;
  private Long parameter;
  private Long parent;  
  private String value;
}
