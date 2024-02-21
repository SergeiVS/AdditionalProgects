package companyPersonalManagement.ui;

import companyPersonalManagement.Services.DepartmentService;
import companyPersonalManagement.Services.EmployeeService;
import companyPersonalManagement.Services.utils.PrintDtos;
import companyPersonalManagement.Services.utils.UserInput;
import companyPersonalManagement.dtos.requestDtos.DepartmentDto;
import companyPersonalManagement.dtos.requestDtos.EmployeeDto;
import companyPersonalManagement.dtos.responseDtos.AddRemoveUnitDto;
import companyPersonalManagement.dtos.responseDtos.EmployeeListDto;
import companyPersonalManagement.dtos.responseDtos.PresentDepartmentDto;
import companyPersonalManagement.dtos.responseDtos.PresentEmployeeDto;

public class Ui {
    private final DepartmentService departmentService;

    private final EmployeeService employeeService;


    public Ui(DepartmentService departmentService, EmployeeService employeeService) {
        this.departmentService = departmentService;
        this.employeeService = employeeService;
    }

    public void execute() {
        while (true) {
            System.out.println("Task menu: ");
            System.out.println("1. Add new employee");
            System.out.println("2. Lay off employee");
            System.out.println("3. Find all employees");
            System.out.println("4. Find employee by id");
            System.out.println("5. Find employees by lastname");
            System.out.println("6. Find count of employees");
            System.out.println("7. Add new department");
            System.out.println("8. Delete department");
            System.out.println("9. Find department");
            System.out.println("10. Add employee to department");
            System.out.println("11. Remove employee from department");
            System.out.println("12. Find all department employees");
            System.out.println("13. Exit");
            int menuCode = UserInput.inputInt("Insert menu code 1 to 13");
            if (menuCode > 0 && menuCode <= 13) {
                try {
                    switch (menuCode) {
                        case 1:
                            String fName = UserInput.inputString("Insert firstname");
                            String lName = UserInput.inputString("Insert lastname");
                            PresentEmployeeDto newEmployee = employeeService.addNewEmployee(new EmployeeDto(fName, lName));
                            PrintDtos.printPresentEmployee(newEmployee);
                            break;

                        case 2:
                            int idToLayOff = UserInput.inputInt("Insert employee id");
                            PresentEmployeeDto employeeForLayOff = employeeService.findEmployeeById(idToLayOff);
                            employeeForLayOff = employeeService.layOffEmployee(employeeForLayOff);
                            PrintDtos.printPresentEmployee(employeeForLayOff);
                            break;

                        case 3:
                            EmployeeListDto employees = employeeService.findAllEmployees();
                            PrintDtos.printEmployeesDtoList(employees);
                            break;

                        case 4:
                            int idToFind = UserInput.inputInt("Insert needed id");
                            PresentEmployeeDto employeeFound = employeeService.findEmployeeById(idToFind);
                            PrintDtos.printPresentEmployee(employeeFound);
                            break;

                        case 5:
                            String name = UserInput.inputString("Insert lastname");
                            EmployeeListDto employeesByName = employeeService.findEmployeesByLastName(name);
                            PrintDtos.printEmployeesDtoList(employeesByName);
                            break;
                        case 6:
                            int countOfEmployees = employeeService.findWholeEmployeesCount();
                            System.out.println("In company are " + countOfEmployees + " employees.");
                            break;
                        case 7:
                            String dName = UserInput.inputString("Insert new department name");
                            AddRemoveUnitDto departmentDto = departmentService.addNewDepartment(new DepartmentDto(dName));
                            System.out.println(departmentDto.toString());
                            break;
                        case 8:
                            dName = UserInput.inputString("Insert new department name");
                            departmentDto = departmentService.removeDepartment(new DepartmentDto(dName));
                            System.out.println(departmentDto.toString());
                            break;
                        case 9:
                            dName = UserInput.inputString("Insert new department name");
                            PresentDepartmentDto department = departmentService.findDepartment(new DepartmentDto(dName));
                            PrintDtos.printDepartment(department);
                            break;
                        case 10:
                            idToFind = UserInput.inputInt("Insert needed id");
                            dName = UserInput.inputString("Insert new department name");
                            department = departmentService.findDepartment(new DepartmentDto(dName));
                            employeeFound = departmentService.addEmployeeToDep(department, idToFind);
                            PrintDtos.printPresentEmployee(employeeFound);
                            break;
                        case 11:
                            idToFind = UserInput.inputInt("Insert needed id");
                            dName = UserInput.inputString("Insert new department name");
                            department = departmentService.findDepartment(new DepartmentDto(dName));
                            employeeFound = departmentService.removeEmployeeFromDep(department, idToFind);
                            PrintDtos.printPresentEmployee(employeeFound);
                            break;
                        case 12:
                            dName = UserInput.inputString("Insert new department name");
                            department = departmentService.findDepartment(new DepartmentDto(dName));
                            EmployeeListDto depEmployees = departmentService.findDepEmployees(department);
                            PrintDtos.printEmployeesDtoList(depEmployees);
                            break;
                        case 13:
                            return;
                    }
                } catch (Exception e) {
                    System.out.println("Error! Please try again!");
                    e.printStackTrace();
                }
            }
        }
    }


}
