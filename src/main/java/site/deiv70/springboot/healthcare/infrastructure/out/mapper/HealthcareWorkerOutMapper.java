package site.deiv70.springboot.healthcare.infrastructure.out.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import site.deiv70.springboot.healthcare.domain.model.HealthcareWorker;
import site.deiv70.springboot.healthcare.infrastructure.out.model.HealthcareWorkerEntity;
import site.deiv70.springboot.healthcare.utils.ValueObjectMapper;

@Mapper(componentModel = "spring", uses = {ValueObjectMapper.class})
public interface HealthcareWorkerOutMapper {

	HealthcareWorkerEntity toInfrastructure(HealthcareWorker healthcareWorker);

	List<HealthcareWorkerEntity> toInfrastructure(List<HealthcareWorker> healthcareWorkerList);

	default Page<HealthcareWorkerEntity> toInfrastructure(Page<HealthcareWorker> healthcareWorkerPage) {
		return healthcareWorkerPage.map(this::toInfrastructure);
	}

	HealthcareWorker toDomain(HealthcareWorkerEntity healthcareWorkerEntity);

	List<HealthcareWorker> toDomain(List<HealthcareWorkerEntity> entityList);

	default Page<HealthcareWorker> toDomain(Page<HealthcareWorkerEntity> entityPage) {
		return entityPage.map(this::toDomain);
	}

}
