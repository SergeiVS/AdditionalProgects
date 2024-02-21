package companyPersonalManagement.repositories.RepositoryServices;

import companyPersonalManagement.dtos.requestDtos.DepartmentDto;
import companyPersonalManagement.entitys.Department;
import companyPersonalManagement.entitys.Employee;
import companyPersonalManagement.repositories.DepartmentRepository;
import companyPersonalManagement.repositories.DepartmentRepositoryInterface;

import java.util.List;

public class DepartmentRepositoryService implements DepartmentRepositoryInterface {

    private final DepartmentRepository dRepository ;

    public DepartmentRepositoryService(DepartmentRepository dRepository) {
        this.dRepository = dRepository;
    }

    @Override
    public void addNewDepartment(DepartmentDto DepartmentDto) {

        String name = DepartmentDto.getDepartmentName();
        Department department = new Department(name);
        dRepository.getDepartmentsRepository().put(name, department);
    }

    @Override
    public void removeDepartment(String departmentName) {
        dRepository.getDepartmentsRepository().remove(departmentName);
    }

    @Override
    public void addEmployeeToDepartment(String departmentName, Employee employee) {

        Department workingD = dRepository.getDepartmentsRepository().get(departmentName);

        workingD.getDepartmentPersonal().add(employee);

    }

    @Override
    public void removeEmployeeFromDepartment(String departmentName, Employee employee) {

        Department workingD = dRepository.getDepartmentsRepository().get(departmentName);

        workingD.getDepartmentPersonal().remove(employee);

    }


    @Override
    public List<Employee> findAllDepartmentEmployees(String departmentName) {

        return dRepository.getDepartmentsRepository().get(departmentName).getDepartmentPersonal();
    }
}
