package site.deiv70.springboot.healthcare.infrastructure.out;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.ReflectionUtils;

import lombok.RequiredArgsConstructor;

import site.deiv70.springboot.healthcare.domain.model.HealthcareWorker;
import site.deiv70.springboot.healthcare.domain.port.HealthcareWorkerRepositoryPort;
import site.deiv70.springboot.healthcare.infrastructure.in.ApiErrorException;
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

	@Override
	public Optional<HealthcareWorker> findById(UUID id) {
		Optional<HealthcareWorkerEntity> entity = healthcareWorkerJpaRepository.findById(id);
		return entity.map(healthcareWorkerOutMapper::toDomain);
	}

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
	public HealthcareWorker save(Map<String, Object> healthcareWorkerHashMap) {
		HealthcareWorkerEntity entity = healthcareWorkerJpaRepository.findById((UUID) healthcareWorkerHashMap.get("id"))
			.orElseThrow(() -> new ApiErrorException(
				"HealthcareWorker not found with id: " + healthcareWorkerHashMap.get("id")));
		healthcareWorkerHashMap.remove("id");

		healthcareWorkerHashMap.forEach((key, value) -> {
			Field field = ReflectionUtils.findField(HealthcareWorkerEntity.class, key);
			if (null != field) {
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, entity, value);
			} else {
				throw new ApiErrorException("HealthcareWorker field not found: " + key);
			}
		});

		HealthcareWorkerEntity savedEntity = healthcareWorkerJpaRepository.save(entity);
		return healthcareWorkerOutMapper.toDomain(savedEntity);
	}

	@Override
	public void delete(UUID id) {
		healthcareWorkerJpaRepository.deleteById(id);
	}

}
