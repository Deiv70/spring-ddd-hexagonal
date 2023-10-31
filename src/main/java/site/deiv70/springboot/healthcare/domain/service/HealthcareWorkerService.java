package site.deiv70.springboot.healthcare.domain.service;

import java.util.Map;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import site.deiv70.springboot.healthcare.domain.model.HealthcareWorker;
import site.deiv70.springboot.healthcare.domain.port.HealthcareWorkerRepositoryPort;
import site.deiv70.springboot.healthcare.infrastructure.in.ApiErrorException;

@RequiredArgsConstructor
@Service
public class HealthcareWorkerService {

	final HealthcareWorkerRepositoryPort healthcareWorkerRepositoryPort;

	// C
	public HealthcareWorker store(HealthcareWorker healthcareWorker) {
		return healthcareWorkerRepositoryPort.save(healthcareWorker);
	}

	// R
	public HealthcareWorker show(UUID id) {
		return healthcareWorkerRepositoryPort.findById(id)
			.orElseThrow(() -> new ApiErrorException("HealthcareWorker not found with id: " + id));
	}

	public Page<HealthcareWorker> index(Pageable pageable) {
		return healthcareWorkerRepositoryPort.findAll(pageable);
	}

	// U
	public HealthcareWorker update(Map<String, Object> healthcareWorkerHashMap) {

		return healthcareWorkerRepositoryPort.save(healthcareWorkerHashMap);
	}

	// D
	public void delete(UUID id) {
		healthcareWorkerRepositoryPort.delete(id);
	}

}
