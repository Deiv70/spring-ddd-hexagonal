package site.deiv70.springboot.healthcare.infrastructure.out;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

import site.deiv70.springboot.healthcare.application.out.port.HealthcareWorkerRepositoryPort;
import site.deiv70.springboot.healthcare.domain.model.HealthcareWorker;
import site.deiv70.springboot.healthcare.infrastructure.out.mapper.HealthcareWorkerOutMapper;
import site.deiv70.springboot.healthcare.infrastructure.out.model.HealthcareWorkerEntity;

@Repository
@RequiredArgsConstructor
public class HealthcareWorkerRepositoryAdapterJPA implements HealthcareWorkerRepositoryPort {

	final HealthcareWorkerOutMapper healthcareWorkerOutMapper;
	final HealthcareWorkerJpaRepository healthcareWorkerJpaRepository;

	@Override
	public Page<HealthcareWorker> findAll(Pageable pageable) {
		Page<HealthcareWorkerEntity> entityPage = healthcareWorkerJpaRepository.findAll(pageable);
		return healthcareWorkerOutMapper.toDomain(entityPage);
	}

	/* @Override
	public List<HealthcareWorker> findAll() {
		List<HealthcareWorkerEntity> entityList = healthcareWorkerJpaRepository.findAll();
		return healthcareWorkerOutMapper.toDomain(entityList);
	} */

	@Override
	public HealthcareWorker save(HealthcareWorker healthcareWorker){
		HealthcareWorkerEntity entity = healthcareWorkerOutMapper.toInfrastructure(healthcareWorker);
		entity = healthcareWorkerJpaRepository.save(entity);
		return healthcareWorkerOutMapper.toDomain(entity);
	}

	@Override
	public List<HealthcareWorker> save(List<HealthcareWorker> healthcareWorker) {
		List<HealthcareWorkerEntity> entityList = healthcareWorkerOutMapper.toInfrastructure(healthcareWorker);
		entityList = healthcareWorkerJpaRepository.saveAll(entityList);
		return healthcareWorkerOutMapper.toDomain(entityList);
	}

	@Override
	public Optional<HealthcareWorker> findById(UUID id) {
		Optional<HealthcareWorkerEntity> entity = healthcareWorkerJpaRepository.findById(id);
		return entity.map(healthcareWorkerOutMapper::toDomain);
	}

	@Override
	public void delete(UUID id) {
		healthcareWorkerJpaRepository.deleteById(id);
	}

}
