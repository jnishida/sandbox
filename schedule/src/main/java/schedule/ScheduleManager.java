package schedule;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

public class ScheduleManager {
	public Collection<Schedule> getFreeTime(LocalDate from, LocalDate to, Duration duraration) {
		Collection<Schedule> temporaryFreeTime = createTemporaryFreeTime(from, to);
		Collection<Schedule> schedules = getSchedules(from, to);

		return findFreeTimeInSchedules(temporaryFreeTime, schedules);
	}

	Collection<Schedule> findFreeTimeInSchedules(Collection<Schedule> temporaryFreeTime,
		Collection<Schedule> schedules) {
		for (Schedule schedule : schedules) {
			if (temporaryFreeTime.contains(schedule)){
				temporaryFreeTime.remove(schedule);
			}
		}
		return temporaryFreeTime;
	}

	private Collection<Schedule> getSchedules(LocalDate from, LocalDate to, String... names) {
		Collection<Schedule> schedules = new HashSet<Schedule>();
		Collection<ScheduleOwner> scheduleOwners = getScheduleOwners();
		for (ScheduleOwner scheduleOwner : scheduleOwners) {
			for (Schedule schedule : scheduleOwner.getScheduleList()) {
				schedules.addAll(schedule.innerUnits());
				continue;
			}
		}
		return schedules;
	}

	private Collection<ScheduleOwner> getScheduleOwners() {
		return ScheduleAccesser.getScheduleOwners();
	}

	Collection<Schedule> createTemporaryFreeTime(LocalDate from, LocalDate to) {
		Collection<Schedule> freeTimes = new LinkedList<>();
		for (LocalDate date = from; date.isBefore(to) || date.equals(to); date = date.plusDays(1)) {
			for (LocalTime time = RegularTime.START.getTime(); time
				.isBefore(RegularTime.END.getTime()); time = time.plusMinutes(Schedule.MINUTES_OF_UNIT)) {
				LocalDateTime start = LocalDateTime.of(date, time);
				LocalDateTime end = start.plusMinutes(Schedule.MINUTES_OF_UNIT);
				freeTimes.add(new Schedule(start, end));
			}
		}
		return freeTimes;
	}
}
