package schedule;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ScheduleManagerTest {

	ScheduleManager sut = new ScheduleManager();

	@Test
	public void testCreateTemporaryFreeTime() {
		LocalDate from = LocalDate.parse("2017-03-01");
		LocalDate to = LocalDate.parse("2017-03-03");
		Collection<Schedule> actual = sut.createTemporaryFreeTime(from, to);

		assertThat(actual)
			.hasSize(((17 - 9) * 2 + 1) * 3)
			.contains(
				new Schedule(LocalDateTime.of(2017, 3, 1, 9, 0), LocalDateTime.of(2017, 3, 1, 9, 30)),
				new Schedule(LocalDateTime.of(2017, 3, 2, 12, 0), LocalDateTime.of(2017, 3, 2, 12, 30)),
				new Schedule(LocalDateTime.of(2017, 3, 3, 17, 0), LocalDateTime.of(2017, 3, 3, 17, 30)))
			.doesNotContain(
				new Schedule(LocalDateTime.of(2017, 3, 1, 8, 30), LocalDateTime.of(2017, 3, 1, 9, 00)),
				new Schedule(LocalDateTime.of(2017, 3, 3, 17, 30), LocalDateTime.of(2017, 3, 3, 18, 00)));
	}
	
	@Test
	public void test() throws Exception{
		File parent = new File("src/test/resources");
		File src = new File(parent, "test1.json");
		ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

		@SuppressWarnings("unchecked")
		Collection<ScheduleOwner> schedules = mapper.readValue(src, ArrayList.class);
		ScheduleAccesser.setScheduleOwners(schedules);
		
		LocalDate from = LocalDate.parse("2017-03-01");
		LocalDate to = LocalDate.parse("2017-03-03");
		Collection<Schedule> freeTimeInSchedules = sut.findFreeTimeInSchedules(
			sut.createTemporaryFreeTime(from, to), 
			sut.getFreeTime(LocalDate.parse("2017-03-01"), LocalDate.parse("2017-03-03"), Duration.ofMinutes(120)));

		System.out.println(freeTimeInSchedules);
	}
}
