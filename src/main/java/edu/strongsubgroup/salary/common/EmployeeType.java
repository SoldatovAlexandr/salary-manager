package edu.strongsubgroup.salary.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EmployeeType {
    ENGINEER,
    MANAGER,
    WORKER;

    public static final String ENGINEER_STRING = "ENGINEER";
    public static final String MANAGER_STRING = "MANAGER";
    public static final String WORKER_STRING = "WORKER";
}
