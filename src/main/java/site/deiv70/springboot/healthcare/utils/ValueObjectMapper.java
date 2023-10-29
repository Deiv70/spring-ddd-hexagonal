package site.deiv70.springboot.healthcare.utils;

import java.lang.reflect.InvocationTargetException;

import org.mapstruct.TargetType;

import site.deiv70.springboot.healthcare.infrastructure.in.ApiErrorException;

/**
 * This interface is used to help MapStruct to map ValueObjects to their Values and vice versa.
 * {@code @Mapper(componentModel = "spring", uses = {ValueObjectMapper.class})}
 */
public interface ValueObjectMapper {

	static <V extends ValueObject<T>, T> T mapToValue(V valueObject) {
		return valueObject == null ? null : valueObject.getValue();
	}

	static <V extends ValueObject<T>, T> V mapFromValueObject(T value, @TargetType Class<V> valueObjectClass) {
		if (value == null) {
			return null;
		}

		try {
			V valueObject = valueObjectClass.getDeclaredConstructor(value.getClass()).newInstance(value);

			return valueObject;
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			throw new ApiErrorException("Error mapping Value {".concat(String.valueOf(value))
				.concat("} to ValueObject {").concat(String.valueOf(valueObjectClass)), e);
		}
	}

}
