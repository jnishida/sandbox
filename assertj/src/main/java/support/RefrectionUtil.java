package support;

import java.lang.reflect.Field;

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
		return element.getClass().getDeclaredFields();
	}

	static <E> Field privateField(E element, String name) throws NoSuchFieldException {
		return element.getClass().getDeclaredField(name);
	}


}
