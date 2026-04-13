package com.x86.followup.module.plan.infrastructure.adapter;

import com.x86.followup.module.plan.domain.exception.PlanNotFound;
import com.x86.followup.module.plan.domain.model.Plan;
import com.x86.followup.module.plan.domain.model.PlanId;
import com.x86.followup.module.plan.domain.repository.PlanRepository;
import com.x86.followup.module.plan.infrastructure.mapper.PlanMapper;
import com.x86.followup.module.plan.infrastructure.persistence.JpaPlanRepository;
import com.x86.followup.module.plan.infrastructure.persistence.PlanEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class PostgresPlanAdapter implements PlanRepository {

    private final JpaPlanRepository jpaRepository;
    private final PlanMapper planMapper;

    @Override
    public Plan save(Plan plan){
        PlanEntity entity = planMapper.toEntity(plan);

        PlanEntity savedEntity = jpaRepository.save(entity);

        return planMapper.toDomain(savedEntity);
    }

    @Override
    @Transactional
    public void update(Plan plan){
        PlanEntity existingEntity = jpaRepository.findById(plan.getId().getValue())
                .orElseThrow(() -> new PlanNotFound("Este plan no existe"));

        existingEntity.setGymId(plan.getGymId().getValue());
        existingEntity.setName(plan.getName().getValue());
        existingEntity.setPrice(plan.getPrice().getValue());
        existingEntity.setDuration(plan.getDurationDay().getValue());
        existingEntity.setDescription(plan.getDescription().getValue());
        existingEntity.setIsActive(plan.getIsActive());

        jpaRepository.save(existingEntity);
    }

    @Override
    public void delete(PlanId id) {
        jpaRepository.deleteById(id.getValue());
    }

    @Override
    public Optional<Plan> findById(PlanId id){
        if (id == null || id.getValue() == null) {
            return Optional.empty();
        }

        return jpaRepository.findById(id.getValue())
                .map(planMapper::toDomain);
    }

    @Override
    public List<Plan> findAll(){
        return jpaRepository.findAll().stream()
                .map(planMapper::toDomain)
                .collect(Collectors.toList());
    }

}
