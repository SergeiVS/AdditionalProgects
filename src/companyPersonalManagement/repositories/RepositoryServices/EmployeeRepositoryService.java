package companyPersonalManagement.repositories.RepositoryServices;

import companyPersonalManagement.dtos.requestDtos.EmployeeDto;
import companyPersonalManagement.dtos.responseDtos.PresentEmployeeDto;
import companyPersonalManagement.entitys.Employee;
import companyPersonalManagement.repositories.EmployeeRepository;
import companyPersonalManagement.repositories.EmployeeRepositoryInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeRepositoryService  implements EmployeeRepositoryInterface {
    private final EmployeeRepository eRepository = new EmployeeRepository();

    @Override
    public Employee addNewEmployee(EmployeeDto employeeDto) {

        Integer id = eRepository.idGenerator();
        String lastName = employeeDto.getLastName();
        String firstName = employeeDto.getFirstName();

        Employee employee = new Employee(id, lastName, firstName);
        eRepository.getEmployeesRepository().put(id, employee);
        return employee;
    }

    @Override
    public Employee employeeLayOff(Integer id) {
        Employee employee = eRepository.getEmployeesRepository().get(id);
        eRepository.getEmployeesRepository().remove(id);
        return employee;
    }

    @Override
    public Employee setEmployeePosition(Integer id, String position) {
        Employee employee = eRepository.getEmployeesRepository().get(id);
        employee.setPosition(position);
        return employee;
    }

    @Override
    public Employee findEmployeeById(Integer id) {
        return eRepository.getEmployeesRepository().get(id);
    }

    @Override
    public List<Employee> findAllEmployees() {
        Map<Integer, Employee> employees = eRepository.getEmployeesRepository();
        List<Employee> employeeList = new ArrayList<>();
        for (Map.Entry<Integer, Employee> entry : employees.entrySet()){
            employeeList.add(entry.getValue());
        }
        return employeeList;
    }


    @Override
    public List<Employee> findEmployeeByLastname(String lastName) {
        List<Employee> employees = new ArrayList<>();
        Map<Integer, Employee> employeeMap = eRepository.getEmployeesRepository();

        for (Map.Entry<Integer, Employee> entry : employeeMap.entrySet()) {
            String entryLastName = entry.getValue().getLastName();
            if (entryLastName.equals(lastName)) {
                employees.add(entry.getValue());
            }
        }
        return employees;
    }
    @Override
    public Integer wholePersonalCount() {

        return eRepository.getEmployeesRepository().size();
    }
}
