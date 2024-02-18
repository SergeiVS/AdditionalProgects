package companyPersonalManagement.entitys;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Department {
    private String departmentName;
    private List<Employee> departmentPersonal;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        departmentPersonal = new ArrayList<>();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public List<Employee> getDepartmentPersonal() {
        return departmentPersonal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department that)) return false;
        return Objects.equals(getDepartmentName(), that.getDepartmentName()) && Objects.equals(getDepartmentPersonal(), that.getDepartmentPersonal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDepartmentName(), getDepartmentPersonal());
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + departmentName + '\'' +
                ", departmentPersonal=" + departmentPersonal +
                '}';
    }
}
