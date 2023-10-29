package site.deiv70.springboot.healthcare.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class Utils {

	public static List<String> getClassFieldNameList(Object classObject) {
		List<String> fieldNameList = new ArrayList<>();
		for (Field field : classObject.getClass().getDeclaredFields()) {
			fieldNameList.add(field.getName());
		}
		return fieldNameList;
	}

}
