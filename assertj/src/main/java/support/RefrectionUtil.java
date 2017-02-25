package support;

import java.lang.reflect.Field;
import java.util.stream.Stream;

public final class RefrectionUtil {
	static boolean hasEqualsMethod(Class<? extends Object> class1) {
		try {
			class1.getDeclaredMethod("equals", Object.class);
			return true;
		} catch (NoSuchMethodException e) {
			return false;
		}
	}

	static <E> Field[] privateFields(E element) {
		Field[] fields = element.getClass().getDeclaredFields();
		Stream.of(fields).forEach(f -> {
			f.setAccessible(true);
		});
		return fields;
	}

	static <E> Field privateField(E element, String name) throws NoSuchFieldException {
		Field field = element.getClass().getDeclaredField(name);
		field.setAccessible(true);
		return field;
	}

}
