package schedule;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleOwner {
	@JsonProperty("name")
	private String name;

	@JsonProperty("ScheduleList")
	private List<Schedule> ScheduleList;
}
