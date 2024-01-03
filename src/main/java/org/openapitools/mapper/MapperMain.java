package org.openapitools.mapper;

import io.swagger.v3.core.util.Json;
import org.openapitools.jackson.nullable.JsonNullable;

public interface MapperMain<Entity, Dto> {
    Entity dtoToEntity(Dto dto);
    Dto entityToDto(Entity entity);

    default <T> T map(JsonNullable<T> value){
        if(value == null || !value.isPresent()){
            return null;
        }
        return value.get();
    }

    default <T> JsonNullable<T> map(T value)
    {
        return JsonNullable.of(value);
    }
}
