package companyPersonalManagement;

import companyPersonalManagement.Services.DepartmentService;
import companyPersonalManagement.Services.EmployeeService;
import companyPersonalManagement.repositories.DepartmentRepository;
import companyPersonalManagement.repositories.EmployeeRepository;
import companyPersonalManagement.repositories.RepositoryServices.DepartmentRepositoryService;
import companyPersonalManagement.repositories.RepositoryServices.EmployeeRepositoryService;
import companyPersonalManagement.ui.Ui;


public class CompanyApp {
    public static void main(String[] args) {

        EmployeeRepository eRepository = new EmployeeRepository();
        EmployeeRepositoryService eRepoService = new EmployeeRepositoryService();
        DepartmentRepository dRepository = new DepartmentRepository();
        DepartmentRepositoryService dRepoService = new DepartmentRepositoryService();
        DepartmentService dService = new DepartmentService(dRepoService, dRepository, eRepoService);
        EmployeeService eService = new EmployeeService();

        Ui ui = new Ui(dService, eService);
        ui.execute();

    }
}
