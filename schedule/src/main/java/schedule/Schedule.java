package schedule;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedList;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import common.MyLocalDateTimeDeserializer;
import common.MyLocalDateTimeSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Schedule {
	public static final int MINUTES_OF_UNIT = 30;

	@JsonSerialize(using = MyLocalDateTimeSerializer.class)
	@JsonDeserialize(using = MyLocalDateTimeDeserializer.class)
	private LocalDateTime start;

	@JsonSerialize(using = MyLocalDateTimeSerializer.class)
	@JsonDeserialize(using = MyLocalDateTimeDeserializer.class)
	private LocalDateTime end;

	public Schedule(LocalDateTime start, LocalDateTime end) {
		this.start = start;
		this.end = end;
	}

	@JsonIgnore
	public Duration getDuration() {
		return Duration.between(start, end);
	}

	@JsonIgnore
	public long getDurationMinutes() {
		return getDuration().toMinutes();
	}

	@JsonIgnore
	public Collection<Schedule> innerUnits() {
		Collection<Schedule> inner = new LinkedList<>();

		for (Schedule divide = divide(this); divide != null; divide = divide(new Schedule(divide.getEnd(), end))) {
			inner.add(divide);
		}
		return inner;
	}

	private Schedule divide(Schedule schedule) {
		if (schedule.getDurationMinutes() < MINUTES_OF_UNIT) {
			return null;
		}
		return new Schedule(schedule.getStart(), schedule.getStart().plusMinutes(MINUTES_OF_UNIT));
	}
}
