package com.github.jayakumarc.taskdashboard.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import com.github.jayakumarc.taskdashboard.model.constant.TaskType;

@Converter(autoApply = true)
public class TaskTypeConverter implements AttributeConverter<TaskType, String> {
    public String convertToDatabaseColumn(TaskType taskType) {
        return taskType.getValue();
    }

    public TaskType convertToEntityAttribute(String taskType) {
        return TaskType.fromString(taskType);
    }
}
