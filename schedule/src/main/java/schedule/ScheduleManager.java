package schedule;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.LinkedList;

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

	Collection<Schedule> createTemporaryFreeTime(LocalDate from, LocalDate to) {
		Collection<Schedule> freeTimes = new LinkedList<>();
		for (LocalDate date = from; date.isBefore(to) || date.equals(to); date = date.plusDays(1)) {
			for (LocalTime time = RegularTime.START.getTime(); time
				.isBefore(RegularTime.END.getTime()); time = time.plusMinutes(30)) {
				LocalDateTime start = LocalDateTime.of(date, time);
				LocalDateTime end = start.plusMinutes(30);
				freeTimes.add(new Schedule(start, end));
			}
		}
		return freeTimes;
	}
}
