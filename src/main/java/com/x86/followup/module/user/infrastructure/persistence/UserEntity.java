package com.x86.followup.module.user.infrastructure.persistence;

import com.x86.followup.module.user.domain.model.UserPaymentMethod;
import com.x86.followup.module.user.domain.model.UserStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users")
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "gym_id")
    private Integer gymId = 1;

    private String name;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private IdentificationEntity identification;

    private String phone;

    @Enumerated(EnumType.STRING)
    private UserPaymentMethod paymentMethod;

    private Timestamp membershipStart;

    private Timestamp membershipEnd;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;
}
