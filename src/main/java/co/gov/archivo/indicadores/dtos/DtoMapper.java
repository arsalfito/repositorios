package co.gov.archivo.indicadores.dtos;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

public class DtoMapper {

	public static <T> GenericDto toGenericDto(T entity) throws IllegalAccessException {
        Class<?> clazz = entity.getClass();
        Long id = null;
        Object value = null;

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.getName().equalsIgnoreCase("id")) {
                id = (Long) field.get(entity);
            } else if (field.getName().equalsIgnoreCase("value")) {
                value = field.get(entity);
            }
        }

        if (id == null) {
            throw new IllegalArgumentException("Entity does not have an id field");
        }

        return new GenericDto(id, value);
    }

    public static <T> List<GenericDto> toGenericDtoList(List<T> entities) {
        return entities.stream()
                .map(entity -> {
                    try {
                        return toGenericDto(entity);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("Failed to map entity to DTO", e);
                    }
                })
                .collect(Collectors.toList());
    }
}
