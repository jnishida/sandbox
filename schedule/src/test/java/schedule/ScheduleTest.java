package schedule;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.Test;

public class ScheduleTest {

	@Test
	public void testInnerUnits() {
		Schedule schedule = new Schedule(LocalDateTime.parse("2017-03-01T11:30"), LocalDateTime.parse("2017-03-01T13:00"));
		assertThat(schedule.innerUnits())
			.hasSize(3)
			.containsExactly(
				new Schedule(LocalDateTime.parse("2017-03-01T11:30"), LocalDateTime.parse("2017-03-01T12:00")),
				new Schedule(LocalDateTime.parse("2017-03-01T12:00"), LocalDateTime.parse("2017-03-01T12:30")),
				new Schedule(LocalDateTime.parse("2017-03-01T12:30"), LocalDateTime.parse("2017-03-01T13:00")));
	}
}
