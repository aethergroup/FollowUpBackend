package com.x86.followup.module.plan.infrastructure.persistence;

import com.x86.followup.module.plan.domain.model.PlanIsActive;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "plans")
@Getter
@Setter
public class PlanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "gym_id")
    private Integer gymId;

    private String name;

    private Double price;

    @Column(name = "duration_days")
    private String duration;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "is_active")
    private PlanIsActive isActive;
}
