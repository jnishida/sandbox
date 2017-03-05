package schedule;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleOwner {
	private String name;

	private Collection<Schedule> ScheduleList;
}
