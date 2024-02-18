package companyPersonalManagement.Services.utils;


import companyPersonalManagement.dtos.responseDtos.PresentDepartmentDto;
import companyPersonalManagement.dtos.responseDtos.PresentEmployeeDto;
import companyPersonalManagement.entitys.Employee;

import java.util.Arrays;
import java.util.List;

public class PrintDtos {
    public static void printPresentEmployee(PresentEmployeeDto dto) {

        System.out.println(Arrays.toString(dto.getErrorDtos().toArray()));
        System.out.println("Employee id: " + dto.getPersonalId());
        System.out.println(dto.getFirstName() + " " + dto.getLastName());
        System.out.println("Position: " + dto.getPosition());
        System.out.println("Department: " + dto.getDepartmentName());

    }

    public static void printDepartment(PresentDepartmentDto dto) {
        System.out.println(Arrays.toString(dto.getErrors().toArray()));
        System.out.println("Department: " + dto.getDepartmentName());
        int count = 0;
        for (Employee employee : dto.getEmployees()) {
            System.out.println(++count + ".");
            System.out.println(employee.getFirstName() + " " + employee.getLastName());
            System.out.println("Position: " + employee.getPosition());
        }
    }

    public static void printEmployeesDtoList(List<PresentEmployeeDto> employees) {
        int count = 0;
        for (PresentEmployeeDto employee : employees) {
            System.out.println(++count + ".");
            System.out.println(employee.getFirstName() + " " + employee.getLastName());
            System.out.println("Position: " + employee.getPosition());
            System.out.println("Department: " + employee.getDepartmentName());
        }
    }

}
