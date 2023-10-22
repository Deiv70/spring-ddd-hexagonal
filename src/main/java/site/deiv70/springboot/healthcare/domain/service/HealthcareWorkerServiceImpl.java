package site.deiv70.springboot.healthcare.domain.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import site.deiv70.springboot.healthcare.application.out.port.HealthcareWorkerRepositoryPort;
import site.deiv70.springboot.healthcare.domain.model.HealthcareWorker;
import site.deiv70.springboot.healthcare.infrastructure.in.ApiErrorException;

@Service
@RequiredArgsConstructor
public class HealthcareWorkerServiceImpl implements HealthcareWorkerService {

	final HealthcareWorkerRepositoryPort healthcareWorkerRepositoryPort;

	// Inspired by Laravel Resource Controllers

	@Override
	public Page<HealthcareWorker> index(Pageable pageable) {
		return healthcareWorkerRepositoryPort.findAll(pageable);
	}

	@Override
	public HealthcareWorker store(HealthcareWorker healthcareWorker) {
		return healthcareWorkerRepositoryPort.save(healthcareWorker);
	}

	@Override
	public HealthcareWorker show(UUID id) {
		return healthcareWorkerRepositoryPort.findById(id)
			.orElseThrow(() -> new ApiErrorException(
				"Healthcare worker '".concat(String.valueOf(id)).concat("' not found")));
	}

	@Override
	public HealthcareWorker update(HealthcareWorker healthcareWorker) {
		return healthcareWorkerRepositoryPort.save(healthcareWorker);
	}

	@Override
	public List<HealthcareWorker> update(List<HealthcareWorker> healthcareWorkerList) {
		return healthcareWorkerRepositoryPort.save(healthcareWorkerList);
	}

	@Override
	public boolean delete(UUID id) {
		healthcareWorkerRepositoryPort.delete(id);
		return healthcareWorkerRepositoryPort.findById(id).isEmpty();
	}

}
