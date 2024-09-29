package co.gov.archivo.indicadores.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class LoginDto {
  private String username;
  private String password;
  private Long idApplication;
}
