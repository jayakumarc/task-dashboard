package com.github.jayakumarc.taskdashboard.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import com.github.jayakumarc.taskdashboard.model.constant.TaskStatus;

@Converter(autoApply = true)
public class TaskStatusConverter implements AttributeConverter<TaskStatus, String> {
    public String convertToDatabaseColumn(TaskStatus taskStatus) {
        return taskStatus.getValue();
    }

    public TaskStatus convertToEntityAttribute(String taskStatus) {
        return TaskStatus.fromString(taskStatus);
    }
}
