package companyPersonalManagement.repositories;

import companyPersonalManagement.entitys.Department;

import java.util.HashMap;
import java.util.Map;

public class DepartmentRepository {

    private final Map<String, Department> departmentsRepository;


    public DepartmentRepository() {
        departmentsRepository = new HashMap<>();
    }

    public Map<String, Department> getDepartmentsRepository() {
        return departmentsRepository;
    }

    @Override
    public String toString() {
        return "DepartmentRepository{" +
                "departmentsRepository=" + departmentsRepository +
                '}';
    }
}
