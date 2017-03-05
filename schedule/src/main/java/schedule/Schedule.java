package schedule;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import common.MyLocalDateTimeDeserializer;
import common.MyLocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
	@JsonProperty("start")
	@JsonSerialize(using = MyLocalDateTimeSerializer.class)
	@JsonDeserialize(using = MyLocalDateTimeDeserializer.class)
	private LocalDateTime start;

	@JsonProperty("end")
	@JsonSerialize(using = MyLocalDateTimeSerializer.class)
	@JsonDeserialize(using = MyLocalDateTimeDeserializer.class)
	private LocalDateTime end;
}
