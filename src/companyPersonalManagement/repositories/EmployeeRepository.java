package companyPersonalManagement.repositories;

import companyPersonalManagement.entitys.Employee;

import java.util.HashMap;
import java.util.Map;

public class EmployeeRepository{

    private int counter = 0;
    private final Map<Integer, Employee> wholeEmployeesRepository;

    public EmployeeRepository() {
        wholeEmployeesRepository = new HashMap<>();
    }

    public Integer idGenerator(){
        return counter++;
    }

    public Map<Integer, Employee> getWholeEmployeesRepository() {
        return wholeEmployeesRepository;
    }


}
