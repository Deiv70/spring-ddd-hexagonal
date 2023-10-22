package site.deiv70.springboot.healthcare.domain.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HealthcareWorker implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	private UUID id;

	private String name;

}
