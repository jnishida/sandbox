package schedule;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

import org.junit.Test;

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
}
