package com.github.jayakumarc.taskdashboard.model.constant;

import java.util.stream.Stream;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TaskType {

    APPROVAL("approval");

    private String value;

    TaskType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static TaskType fromString(String value) {
        return Stream.of(TaskType.values()).filter(item -> item.getValue().equals(value))
                .findFirst().orElseThrow(() -> new RuntimeException(
                        String.format("Unsupported enum value '%s'", value)));
    }

}
