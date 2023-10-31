package site.deiv70.springboot.healthcare.domain.port;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import site.deiv70.springboot.healthcare.domain.model.HealthcareWorker;

@Component
public interface HealthcareWorkerRepositoryPort {

	Page<HealthcareWorker> findAll(Pageable pageable);

	Optional<HealthcareWorker> findById(UUID id);

	HealthcareWorker save(HealthcareWorker healthcareWorker);

	List<HealthcareWorker> save(List<HealthcareWorker> healthcareWorker);

	HealthcareWorker save(Map<String, Object> healthcareWorkerHashMap);

	void delete(UUID id);

}
