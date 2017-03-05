package schedule;

import java.util.Collection;

import lombok.Data;

@Data
public class ScheduleAccesser {
	private Collection<ScheduleOwner> scheduleOwners;
}
