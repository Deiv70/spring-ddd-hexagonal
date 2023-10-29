package site.deiv70.springboot.healthcare.domain.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import site.deiv70.springboot.healthcare.domain.model.HealthcareWorker;
import site.deiv70.springboot.healthcare.domain.port.HealthcareWorkerRepositoryPort;

@RequiredArgsConstructor
@Service
public class HealthcareWorkerService {

	final HealthcareWorkerRepositoryPort healthcareWorkerRepositoryPort;

	// C
	public HealthcareWorker store(HealthcareWorker healthcareWorker) {

	};
	// R
	public HealthcareWorker show(UUID id) {

	};

	public Page<HealthcareWorker> index(Pageable pageable) {

	};
	// U
	public HealthcareWorker update(HealthcareWorker healthcareWorker) {

	};

	public List<HealthcareWorker> update(List<HealthcareWorker> healthcareWorkerList) {

	};

//	public HealthcareWorker update(Map<String, Object> healthcareWorkerMap) {};
	// D
	public boolean delete(UUID id) {

	};

}
