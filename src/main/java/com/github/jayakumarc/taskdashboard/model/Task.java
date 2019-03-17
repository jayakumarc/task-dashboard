package com.github.jayakumarc.taskdashboard.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.jayakumarc.taskdashboard.model.constant.TaskStatus;
import com.github.jayakumarc.taskdashboard.model.constant.TaskType;
import com.github.jayakumarc.taskdashboard.model.converter.TaskStatusConverter;
import com.github.jayakumarc.taskdashboard.model.converter.TaskTypeConverter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tasks")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String workflowId;

    @NotBlank
    private String entityId;

    @NotBlank
    private String userId;

    @NotBlank
    private String url;

    private Date date;

    @Convert(converter = TaskTypeConverter.class)
    private TaskType type;

    @Convert(converter = TaskStatusConverter.class)
    private TaskStatus status = TaskStatus.NEW;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

}
