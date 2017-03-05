package schedule;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ScheduleTest {

	@Test
	public void test() throws Exception {
		List<ScheduleOwner> owners = owners();
		ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
		File parent = new File("src/test/resources");
		mapper.writeValue(new File(parent, "test1.json"), owners);
		System.out.println(owners);
	}

	private List<ScheduleOwner> owners() {
		List<ScheduleOwner> owners = Arrays.asList(
			new ScheduleOwner("A氏", Arrays.asList(
				new Schedule(LocalDateTime.of(2017, 3, 1, 9, 00), LocalDateTime.of(2017, 3, 1, 0, 30)),
				new Schedule(LocalDateTime.of(2017, 3, 1, 12, 12), LocalDateTime.of(2017, 3, 1, 12, 12)),
				new Schedule(LocalDateTime.of(2017, 3, 1, 14, 05), LocalDateTime.of(2017, 3, 2, 9, 30)))),
			new ScheduleOwner(("B氏"), Arrays.asList(
				new Schedule(LocalDateTime.of(2017, 3, 1, 16, 00), LocalDateTime.of(2017, 3, 2, 17, 30)))));
		return owners;
	}
}
