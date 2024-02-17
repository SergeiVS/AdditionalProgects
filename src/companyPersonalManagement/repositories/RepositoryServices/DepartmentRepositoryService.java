package companyPersonalManagement.repositories.RepositoryServices;

import companyPersonalManagement.dtos.requestDtos.NewDepartmentDto;
import companyPersonalManagement.entitys.Department;
import companyPersonalManagement.entitys.Employee;
import companyPersonalManagement.repositories.DepartmentRepository;
import companyPersonalManagement.repositories.DepartmentRepositoryInterface;

import java.util.ArrayList;
import java.util.List;

public class DepartmentRepositoryService implements DepartmentRepositoryInterface {

    private final DepartmentRepository dRepository = new DepartmentRepository();

    @Override
    public void addNewDepartment(NewDepartmentDto newDepartmentDto) {

        String name = newDepartmentDto.getDepartmentName();
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

    @Override
    public List<Employee> findDepartmentEmployeesByPosition(String departmentName, String position) {

        List<Employee> employeesByPosition = new ArrayList<>();
        Department department = dRepository.getDepartmentsRepository().get(departmentName);

        for (Employee employee : department.getDepartmentPersonal()) {
            if (employee.getPosition().equals(position)){
                employeesByPosition.add(employee);
            }
            return employeesByPosition;
        }
        return null;
    }
}
