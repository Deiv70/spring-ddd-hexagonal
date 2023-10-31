package site.deiv70.springboot.healthcare.infrastructure.in;

import java.util.Map;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import site.deiv70.springboot.healthcare.domain.model.HealthcareWorker;
import site.deiv70.springboot.healthcare.domain.service.HealthcareWorkerService;
import site.deiv70.springboot.healthcare.infrastructure.in.mapper.HealthcareWorkerInMapper;
import site.deiv70.springboot.healthcare.infrastructure.in.model.HealthcareWorkerDtoModel;

@RestController
@RequestMapping("${server.servlet.api-path}")
@RequiredArgsConstructor
public class HealthcareWorkerRestController /* implements HealthcareWorkerApi */ {

	final HealthcareWorkerInMapper healthcareWorkerInMapper;
	final HealthcareWorkerService healthcareWorkerService;

	@RequestMapping(value = "/healthcare-worker", method = RequestMethod.GET )
	public ResponseEntity<Page<HealthcareWorkerDtoModel>> getHealthcareWorkers(
		@PageableDefault(size = 10, page = 0)
		final Pageable pageable
	) {
		Page<HealthcareWorker> domainResponse = healthcareWorkerService.index(pageable);
		Page<HealthcareWorkerDtoModel> dtoResponse = healthcareWorkerInMapper.toInfrastructure(domainResponse);

		return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/healthcare-worker/{id}", method = RequestMethod.GET )
	public ResponseEntity<HealthcareWorkerDtoModel> getHealthcareWorker(
		@PathVariable("id")
		UUID id
	) {
		HealthcareWorker domainResponse = healthcareWorkerService.show(id);
		HealthcareWorkerDtoModel dtoResponse = healthcareWorkerInMapper.toInfrastructure(domainResponse);

		return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/healthcare-worker", method = RequestMethod.POST )
	public ResponseEntity<HealthcareWorkerDtoModel> createHealthcareWorker(
		@RequestBody
		HealthcareWorkerDtoModel healthcareWorkerDtoModel
	) {
		healthcareWorkerDtoModel.setId(UUID.randomUUID());
		HealthcareWorker domainRequest = healthcareWorkerInMapper.toDomain(healthcareWorkerDtoModel);
		HealthcareWorker domainResponse = healthcareWorkerService.store(domainRequest);
		HealthcareWorkerDtoModel dtoResponse = healthcareWorkerInMapper.toInfrastructure(domainResponse);

		return new ResponseEntity<>(dtoResponse, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/healthcare-worker/{id}", method = RequestMethod.PUT )
	public ResponseEntity<HealthcareWorkerDtoModel> updateHealthcareWorker(
		@PathVariable("id")
		UUID id,
		@RequestBody
		HealthcareWorkerDtoModel healthcareWorkerDtoModel
	) {
		healthcareWorkerDtoModel.setId(id);
		HealthcareWorker domainRequest = healthcareWorkerInMapper.toDomain(healthcareWorkerDtoModel);
		HealthcareWorker domainResponse = healthcareWorkerService.store(domainRequest);
		HealthcareWorkerDtoModel dtoResponse = healthcareWorkerInMapper.toInfrastructure(domainResponse);

		return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/healthcare-worker/{id}", method = RequestMethod.PATCH )
	public ResponseEntity<HealthcareWorkerDtoModel> patchHealthcareWorker(
		@PathVariable("id")
		UUID id,
		@RequestBody
		Map<String, Object> patchBody
	) {
		patchBody.put("id", id);
		HealthcareWorker domainResponse = healthcareWorkerService.update(patchBody);
		HealthcareWorkerDtoModel dtoResponse = healthcareWorkerInMapper.toInfrastructure(domainResponse);

		return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/healthcare-worker/{id}", method = RequestMethod.DELETE )
	public ResponseEntity<Void> deleteHealthcareWorker(
		@PathVariable("id")
		UUID id
	) {
		healthcareWorkerService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
