package site.deiv70.springboot.healthcare.domain.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import site.deiv70.springboot.healthcare.domain.model.HealthcareWorker;

@Component
public interface HealthcareWorkerService {

	// Inspired by Laravel Resource Controllers

	// C
	HealthcareWorker store(HealthcareWorker healthcareWorker);
	// R
	HealthcareWorker show(UUID id);

	Page<HealthcareWorker> index(Pageable pageable);
	// U
	HealthcareWorker update(HealthcareWorker healthcareWorker);

	List<HealthcareWorker> update(List<HealthcareWorker> healthcareWorkerList);
	// D
	boolean delete(UUID id);

}
