package site.deiv70.springboot.healthcare.infrastructure.out;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import site.deiv70.springboot.healthcare.infrastructure.out.model.HealthcareWorkerEntity;

@Repository
public interface HealthcareWorkerJpaRepository extends JpaRepository<HealthcareWorkerEntity, UUID> {



}
