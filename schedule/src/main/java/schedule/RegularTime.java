package schedule;

import java.time.LocalTime;

public enum RegularTime {
	START(9, 0),
	END(17, 30);

	private LocalTime time;

	private RegularTime(int hour, int minute) {
		this.time = LocalTime.of(hour, minute);
	}

	public LocalTime getTime() {
		return time;
	}
}