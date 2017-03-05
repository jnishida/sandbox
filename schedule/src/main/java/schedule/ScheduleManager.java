package schedule;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Collection;

public class ScheduleManager {
	public Collection<Schedule> getFreeTime(LocalDate from, LocalDate to, Duration duraration) {
		Collection<Schedule> temporaryFreeTime = createTemporaryFreeTime(from, to);
		Collection<Schedule> schedules = getSchedules(from, to);

		return findFreeTimeInSchedules(temporaryFreeTime, schedules);
	}

	private Collection<Schedule> findFreeTimeInSchedules(Collection<Schedule> temporaryFreeTime,
		Collection<Schedule> schedules) {
		throw new UnsupportedOperationException("未実装");
	}

	private Collection<Schedule> getSchedules(LocalDate from, LocalDate to, String... names) {
		throw new UnsupportedOperationException("未実装");
	}

	private Collection<Schedule> createTemporaryFreeTime(LocalDate from, LocalDate to) {
		throw new UnsupportedOperationException("未実装");
	}
}
