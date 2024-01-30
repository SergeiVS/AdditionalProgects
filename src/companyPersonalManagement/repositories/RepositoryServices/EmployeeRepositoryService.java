package companyPersonalManagement.repositories.RepositoryServices;

import companyPersonalManagement.Dtos.NewEmployeeDto;

import companyPersonalManagement.entitys.Employee;
import companyPersonalManagement.repositories.EmployeeRepository;
import companyPersonalManagement.repositories.EmployeeRepositoryInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeRepositoryService implements EmployeeRepositoryInterface {

    EmployeeRepository eRepository = new EmployeeRepository();

    @Override
    public void addNewEmployee(NewEmployeeDto newEmployeeDto) {

        Integer id = eRepository.idGenerator();
        String lastName = newEmployeeDto.getLastName();
        String firstName = newEmployeeDto.getFirstName();

        Employee employee = new Employee(id, lastName, firstName);
        eRepository.getWholeEmployeesRepository().put(id, employee);
    }

    @Override
    public void employeeLayOff(Integer id) {
        eRepository.getWholeEmployeesRepository().remove(id);
    }

    @Override
    public Employee findEmployeeById(Integer id) {
        return eRepository.getWholeEmployeesRepository().get(id);
    }

    @Override
    public List<Employee> findEmployeeByLastname(String lastName) {
        List<Employee> employees = new ArrayList<>();
        Map<Integer, Employee> employeeMap = eRepository.getWholeEmployeesRepository();

        for (Map.Entry<Integer, Employee> entry : employeeMap.entrySet()) {
            String entryLastName = entry.getValue().getLastName();
            if (entryLastName.equals(lastName)) {
                employees.add(entry.getValue());
            }
        }
        return employees;
    }

    @Override
    public List<Employee> findEmployeesByPosition(String position) {

        List<Employee> employees = new ArrayList<>();
        Map<Integer, Employee> employeeMap = eRepository.getWholeEmployeesRepository();

        for (Map.Entry<Integer, Employee> entry : employeeMap.entrySet()) {
            String entryPosition = entry.getValue().getPosition();
            if (entryPosition.equals(position)) {
                employees.add(entry.getValue());
            }
        }
        return employees;

    }

    @Override
    public Integer wholePersonalCount() {

        return eRepository.getWholeEmployeesRepository().size();
    }
}
