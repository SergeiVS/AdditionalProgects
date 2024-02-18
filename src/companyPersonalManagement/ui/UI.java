package companyPersonalManagement.ui;

import companyPersonalManagement.Services.DepartmentService;
import companyPersonalManagement.Services.EmployeeService;
import companyPersonalManagement.repositories.EmployeeRepository;
import companyPersonalManagement.repositories.RepositoryServices.DepartmentRepositoryService;

public class UI {
    private final DepartmentService departmentService;

    private final EmployeeService employeeService;

    public UI(DepartmentService departmentService, EmployeeService employeeService) {
        this.departmentService = departmentService;
        this.employeeService = employeeService;
    }



}
