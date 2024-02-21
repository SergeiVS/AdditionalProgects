package companyPersonalManagement.Services;


import companyPersonalManagement.dtos.errorsDto.ErrorCodes;
import companyPersonalManagement.dtos.errorsDto.ErrorDto;
import companyPersonalManagement.dtos.requestDtos.EmployeeDto;
import companyPersonalManagement.dtos.responseDtos.EmployeeListDto;
import companyPersonalManagement.dtos.responseDtos.PresentEmployeeDto;
import companyPersonalManagement.entitys.Employee;
import companyPersonalManagement.repositories.EmployeeRepository;
import companyPersonalManagement.repositories.RepositoryServices.EmployeeRepositoryService;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private final EmployeeRepositoryService service;
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepositoryService service, EmployeeRepository repository) {
        this.service = service;
        this.repository = repository;
    }


    public PresentEmployeeDto addNewEmployee(EmployeeDto dto) {
        List<ErrorDto> errors = employeeDtoValidate.validate(dto);
        if (errors.isEmpty()) {
            Employee employee = service.addNewEmployee(dto);
            Integer id = employee.getPersonalId();
            String fName = employee.getFirstName();
            String lName = employee.getLastName();

            return new PresentEmployeeDto(id, fName, lName, "-", "-", errors);
        } else {
            return new PresentEmployeeDto(0, "-", "-", "-", "-", errors);
        }
    }

    public PresentEmployeeDto layOffEmployee(PresentEmployeeDto dto) {
        List<ErrorDto> errors = presentEmployeeDtoValidate.validate(dto);
        if (errors.isEmpty()) {
            Integer id = dto.getPersonalId();
            String fName = dto.getFirstName();
            String lName = dto.getLastName();
            String dName = "-";
            String position = "-";

            Employee e = service.employeeLayOff(id);

            return new PresentEmployeeDto(e.getPersonalId(), e.getFirstName(), e.getFirstName(), e.getPosition(), e.getDepartmentName(), errors);
        } else {
            return new PresentEmployeeDto(0, "-", "-", "-", "-", errors);
        }
    }

    public PresentEmployeeDto setEmployeePosition(Integer id, String position) {
        List<ErrorDto> errors = validateId.validate(id);

        if (errors.isEmpty()) {
            Employee employee = service.findEmployeeById(id);
            String fName = employee.getFirstName();
            String lName = employee.getLastName();
            String dName = employee.getDepartmentName();
            service.setEmployeePosition(id, position);
            return new PresentEmployeeDto(id, fName, lName, position, dName, errors);
        } else {
            return new PresentEmployeeDto(0, "-", "-", "-", "-", errors);
        }
    }

    public PresentEmployeeDto findEmployeeById(Integer id) {
        List<ErrorDto> errors = validateId.validate(id);
        if (errors.isEmpty()) {
            Employee employee = service.findEmployeeById(id);
            String fName = employee.getFirstName();
            String lName = employee.getLastName();
            String position = employee.getPosition();
            String dName = employee.getDepartmentName();
            return new PresentEmployeeDto(id, fName, lName, position, dName, errors);
        } else {
            return new PresentEmployeeDto(0, "-", "-", "-", "-", errors);
        }
    }

    public EmployeeListDto findAllEmployees() {
        List<PresentEmployeeDto> employeeDtos = new ArrayList<>();
        List<Employee> employees = service.findAllEmployees();
        for (Employee e : employees) {
            Integer id = e.getPersonalId();
            String fName = e.getFirstName();
            String lName = e.getLastName();
            String position = e.getPosition();
            String dName = e.getDepartmentName();
            employeeDtos.add(new PresentEmployeeDto(id, fName, lName, position, dName, new ArrayList<ErrorDto>()));

        }
        return new EmployeeListDto(employeeDtos, new ArrayList<>());
    }

    public EmployeeListDto findEmployeesByLastName(String lastName) {

        List<ErrorDto> errors = validateName.validate(lastName);
        List<Employee> employeeList = service.findEmployeeByLastname(lastName);
        List<PresentEmployeeDto> employeeDtos = new ArrayList<>();

        if (employeeList.isEmpty()) {
            errors.add(new ErrorDto(ErrorCodes.ER407, "Name not found"));
            employeeDtos.add(new PresentEmployeeDto(0, "-", "-", "-", "-", new ArrayList<ErrorDto>()));
            return new EmployeeListDto(employeeDtos, errors);
        } else {

            for (Employee e : employeeList) {
                Integer id = e.getPersonalId();
                String fName = e.getFirstName();
                String lName = e.getLastName();
                String position = e.getPosition();
                String dName = e.getDepartmentName();
                employeeDtos.add(new PresentEmployeeDto(id, fName, lName, position, dName, new ArrayList<ErrorDto>()));
            }
            return new EmployeeListDto(employeeDtos, errors);
        }
    }

    public Integer findWholeEmployeesCount() {
        return service.wholePersonalCount();
    }

    ValidationInterface<String> validateName = new ValidationInterface<String>() {
        @Override
        public List<ErrorDto> validate(String request) {
            List<ErrorDto> errors = new ArrayList<>();

            if (request == null) {
                errors.add(new ErrorDto(ErrorCodes.ER401, "Lastname field can not be empty"));
                return errors;
            }
            return errors;
        }
    };

    ValidationInterface<Integer> validateId = new ValidationInterface<Integer>() {
        @Override
        public List<ErrorDto> validate(Integer request) {
            List<ErrorDto> errors = new ArrayList<>();
            if (request <= 0) {
                errors.add(new ErrorDto(ErrorCodes.ER406, "Id not valid"));
                return errors;
            }
            if (!repository.getEmployeesRepository().containsKey(request)) {
                errors.add(new ErrorDto(ErrorCodes.ER406, "Id not valid"));
                return errors;
            }
            return errors;
        }
    };

    ValidationInterface<EmployeeDto> employeeDtoValidate = new ValidationInterface<EmployeeDto>() {
        @Override
        public List<ErrorDto> validate(EmployeeDto request) {
            List<ErrorDto> errors = new ArrayList<>();

            if (request == null) {
                errors.add(new ErrorDto(ErrorCodes.ER401, "First or lastname field can not be empty"));
                return errors;
            } else {
                try {
                    String fName = request.getFirstName();
                    String lastName = request.getLastName();
                } catch (Exception e) {
                    errors.add(new ErrorDto(ErrorCodes.ER402, "Request in wrong format"));
                    return errors;
                }
            }
            if (request.getLastName().isEmpty() || request.getFirstName().isEmpty()) {
                errors.add(new ErrorDto(ErrorCodes.ER401, "First or lastname field can not be empty"));
                return errors;

            }
            return errors;
        }
    };
    ValidationInterface<PresentEmployeeDto> presentEmployeeDtoValidate = new ValidationInterface<PresentEmployeeDto>() {
        @Override
        public List<ErrorDto> validate(PresentEmployeeDto request) {
            List<ErrorDto> errors = new ArrayList<>();

            if (request == null) {
                errors.add(new ErrorDto(ErrorCodes.ER401, "Request can not be empty"));
                return errors;
            } else {
                try {
                    Integer id = request.getPersonalId();

                } catch (Exception e) {
                    errors.add(new ErrorDto(ErrorCodes.ER402, "Request in wrong format"));
                    return errors;
                }
            }
            if (request.getLastName().isEmpty() || request.getFirstName().isEmpty() || request.getPersonalId() == 0) {
                errors.add(new ErrorDto(ErrorCodes.ER401, "Fields of request can not be empty"));
                return errors;
            }
            return errors;
        }
    };
}
