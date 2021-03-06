package support;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public final class AssertUtil {
	public static <E> void assertCollection(Collection<E> actual, Collection<E> expected, String... ignoreFields)
		throws Exception {
		if (actual == null && expected == null) {
			return;
		}

		assertThat(actual).isNotNull();
		assertThat(expected).isNotNull();

		assertThat(actual).hasSize(expected.size());

		Iterator<E> expectedIterator = expected.iterator();
		for (E actualElement : actual) {
			E expectedElement = expectedIterator.next();
			assertElement(actualElement, expectedElement, ignoreFields);
		}
	}

	public static <E> void assertElement(E actual, E expected, String... ignoreFields) throws Exception {
		if (actual == null && expected == null) {
			return;
		}

		assertThat(actual).isNotNull();
		assertThat(expected).isNotNull();

		for (Field field1 : RefrectionUtil.privateFields(actual)) {
			if (Arrays.asList(ignoreFields).contains(field1.getName())) {
				continue;
			}

			Field field2 = RefrectionUtil.privateField(expected, field1.getName());

			Object value1 = field1.get(actual);
			Object value2 = field2.get(expected);

			if (value1 instanceof Collection<?>) {
				assertCollection(toCollection(value1), toCollection(value2), ignoreFields);
				continue;
			}

			if (RefrectionUtil.hasEqualsMethod(value1.getClass())) {
				assertThat(value1).isEqualTo(value2);
				continue;
			}

			assertElement(value1, value2, ignoreFields);
		}
	}

	@SuppressWarnings("unchecked")
	private static <E> Collection<E> toCollection(Object obj) {
		return (Collection<E>)obj;
	}
}
