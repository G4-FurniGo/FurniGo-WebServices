package com.furnigo.shared.domain.model.entities;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import java.util.Date;

@MappedSuperclass
@Data
public class AuditableModel {
    @CreatedDate
    private Date createAt;
    @LastModifiedBy
    private Date updatedAt;
}
