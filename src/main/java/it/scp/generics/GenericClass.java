package it.scp.generics;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GenericClass <T, Y, Z> {

    public List<Y> convertToDtoList(List<T> objectsToMap, Class<Y> clazz) {
        List<Y> result = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();

        for (T el : objectsToMap) {
            Y mappedObject = modelMapper.map(el, clazz);
            result.add(mappedObject);
        }

        return result;
    }

    public Y convertToDtoList(T objectToMap, TypeToken<Y> typeToken) {
        ModelMapper modelMapper = new ModelMapper();
        Type listType = typeToken.getType();
        Y mappedObject = modelMapper.map(objectToMap, listType);

        return mappedObject;
    }

    public Y convertToDtoList(T objectToMap, Class<Z> clazz) {
        ModelMapper modelMapper = new ModelMapper();
        Type listType = new TypeToken<List<Z>>(){}.getType();
        Y mappedObject = modelMapper.map(objectToMap, listType);

        return mappedObject;
    }

    public Y convertToDto(T objectToMap, Class<Y> clazz) {
        ModelMapper modelMapper = new ModelMapper();
        Y mappedObject = modelMapper.map(objectToMap, clazz);

        return mappedObject;
    }

}
