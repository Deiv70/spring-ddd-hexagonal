package site.deiv70.springboot.healthcare.domain.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.Value;

import site.deiv70.springboot.healthcare.utils.Default;
import site.deiv70.springboot.healthcare.utils.ValueObject;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor(onConstructor = @__({@Default}))
public class HealthcareWorker implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	private final HealthcareWorker.ID id;
	private String name;
	private String surname;
	private HealthcareWorkerTaxIdentificationNumberVO taxIdentificationNumber;

	@Value
	public static class ID implements ValueObject<UUID>, Serializable {
		@Serial
		private static final long serialVersionUID = 1L;

		UUID value;
	}

}
