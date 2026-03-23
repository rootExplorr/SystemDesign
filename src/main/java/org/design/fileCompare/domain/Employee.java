package org.design.fileCompare.domain;

import java.util.Objects;

public record Employee(String id, String name, String email, String department, double salary) implements Comparable<Employee> {
    @Override
    public int compareTo(Employee other) {
        // Compare all fields; return 0 if equal, non-zero otherwise
        return Objects.compare(this, other, (e1, e2) -> {
            if (Objects.equals(e1.id, e2.id) &&
                    Objects.equals(e1.name, e2.name) &&
                    Objects.equals(e1.email, e2.email) &&
                    Objects.equals(e1.department, e2.department) &&
                    Double.compare(e1.salary, e2.salary) == 0) {
                return 0;
            }
            return -1;
        });
    }
}