package schedule;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

public class ScheduleManager {
	private static final int MINITES_OF_UNIT = 30;

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
		Collection<Schedule> schedules = new HashSet<Schedule>();
		for (ScheduleOwner scheduleOwner : getScheduleOwners()) {
			for (Schedule schedule: scheduleOwner.getScheduleList()) {
				schedules.add(schedule);
			}
		}
		return schedules;
	}

	private Collection<ScheduleOwner> getScheduleOwners() {
		return new ScheduleAccesser().getScheduleOwners();
	}

	Collection<Schedule> createTemporaryFreeTime(LocalDate from, LocalDate to) {
		Collection<Schedule> freeTimes = new LinkedList<>();
		for (LocalDate date = from; date.isBefore(to) || date.equals(to); date = date.plusDays(1)) {
			for (LocalTime time = RegularTime.START.getTime(); time
				.isBefore(RegularTime.END.getTime()); time = time.plusMinutes(MINITES_OF_UNIT)) {
				LocalDateTime start = LocalDateTime.of(date, time);
				LocalDateTime end = start.plusMinutes(MINITES_OF_UNIT);
				freeTimes.add(new Schedule(start, end));
			}
		}
		return freeTimes;
	}
}
