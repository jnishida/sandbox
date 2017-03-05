package schedule;

import java.util.Collection;

public class ScheduleAccesser {
	private static Collection<ScheduleOwner> scheduleOwners;

	public synchronized static Collection<ScheduleOwner> getScheduleOwners() {
		return scheduleOwners;
	}

	public synchronized static void setScheduleOwners(Collection<ScheduleOwner> scheduleOwners) {
		ScheduleAccesser.scheduleOwners = scheduleOwners;
	}
}
