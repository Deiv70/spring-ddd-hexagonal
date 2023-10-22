package site.deiv70.springboot.healthcare.infrastructure.in.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import site.deiv70.springboot.healthcare.domain.model.HealthcareWorker;
import site.deiv70.springboot.healthcare.infrastructure.in.model.HealthcareWorkerDtoModel;

@Mapper(componentModel = "spring")
public interface HealthcareWorkerInMapper {

	HealthcareWorkerDtoModel toInfrastructure(HealthcareWorker healthcareWorker);

	default Page<HealthcareWorkerDtoModel> toInfrastructure(Page<HealthcareWorker> healthcareWorkerPage) {
		return healthcareWorkerPage.map(this::toInfrastructure);
	}

	HealthcareWorker toDomain(HealthcareWorkerDtoModel healthcareWorkerDto);

}
