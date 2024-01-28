package companyPersonalManagement.entitys;

import java.util.LinkedList;
import java.util.List;

public class Department {
    private String departmentName;
    private List<Employee> departmentPersonal;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        departmentPersonal = new LinkedList<>();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public List<Employee> getDepartmentPersonal() {
        return departmentPersonal;
    }
}
