package site.deiv70.springboot.healthcare.domain.model;

import java.io.Serial;
import java.io.Serializable;

import lombok.Value;

import site.deiv70.springboot.healthcare.utils.ValueObject;

@Value
public /*final*/ class HealthcareWorkerTaxIdentificationNumberVO implements ValueObject<String>, Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	String value;

	public HealthcareWorkerTaxIdentificationNumberVO(String value) {
		validate(value);
		this.value = value;
	}

	private static void validate(String value) {
		// TODO: validate tax identification number or throw exception
		if (value == null || value.isBlank()) {
			throw new IllegalArgumentException("Tax identification number cannot be null or blank");
		}
	}

}
