package schedule;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
	@JsonProperty("start")
	private ZonedDateTime start;

	@JsonProperty("end")
	private ZonedDateTime end;
}
