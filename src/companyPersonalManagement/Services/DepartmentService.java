package companyPersonalManagement.Services;

import companyPersonalManagement.dtos.errorsDto.ErrorCodes;
import companyPersonalManagement.dtos.errorsDto.ErrorDto;
import companyPersonalManagement.dtos.requestDtos.DepartmentDto;

import companyPersonalManagement.dtos.responseDtos.AddRemoveUnitDto;
import companyPersonalManagement.dtos.responseDtos.EmployeeListDto;
import companyPersonalManagement.dtos.responseDtos.PresentDepartmentDto;
import companyPersonalManagement.dtos.responseDtos.PresentEmployeeDto;
import companyPersonalManagement.entitys.Department;
import companyPersonalManagement.entitys.Employee;
import companyPersonalManagement.repositories.DepartmentRepository;
import companyPersonalManagement.repositories.RepositoryServices.DepartmentRepositoryService;
import companyPersonalManagement.repositories.RepositoryServices.EmployeeRepositoryService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class DepartmentService {
    private final DepartmentRepositoryService service;
    private final DepartmentRepository dRepository;
    private final EmployeeRepositoryService eRepository;

    public DepartmentService(DepartmentRepositoryService service, DepartmentRepository dRepository, EmployeeRepositoryService eRepository) {
        this.service = service;
        this.dRepository = dRepository;
        this.eRepository = eRepository;
    }

    public PresentDepartmentDto findDepartment(DepartmentDto dto) {
        List<ErrorDto> errors = presentDepNameValidation.validate(dto);
        if (errors.isEmpty()) {
            String name = dto.getDepartmentName();
            Department department = dRepository.getDepartmentsRepository().get(name);
            List<Employee> employees = department.getDepartmentPersonal();
            return new PresentDepartmentDto(name, employees, errors);
        } else {
            return new PresentDepartmentDto("-", new ArrayList<>(), errors);
        }
    }

    public AddRemoveUnitDto removeDepartment(DepartmentDto dto) {
        List<ErrorDto> errors = presentDepNameValidation.validate(dto);

        if (errors.isEmpty()) {
            String name = dto.getDepartmentName();
            dRepository.getDepartmentsRepository().remove(name);
            return new AddRemoveUnitDto("Department " + name + " successful removed.", errors);
        } else {
            return new AddRemoveUnitDto("Department did not removed.", errors);
        }
    }

    public AddRemoveUnitDto addNewDepartment(DepartmentDto dto) {

        List<ErrorDto> errors = newDepValidation.validate(dto);

        String name;
        if (errors.isEmpty()) {
            service.addNewDepartment(dto);
            return new AddRemoveUnitDto("Department was added successful", errors);
        } else {
            return new AddRemoveUnitDto("Error, department did not added", errors);
        }
    }

    public PresentEmployeeDto addEmployeeToDep(PresentDepartmentDto dDto, Integer id) {
        List<ErrorDto> errors = presentDepNameValidation.validate(dDto);
        Employee employee = eRepository.findEmployeeById(id);
        if (errors.isEmpty() && employee != null) {
            String dName = dDto.getDepartmentName();
            Department department = dRepository.getDepartmentsRepository().get(dName);
            employee.setDepartmentName(dName);
            department.getDepartmentPersonal().add(employee);
            return new PresentEmployeeDto(id, employee.getFirstName(), employee.getLastName(), employee.getPosition(), employee.getDepartmentName(), errors);
        } else {
            return new PresentEmployeeDto(0, "-", "-", "-", "-", errors);
        }
    }

    public PresentEmployeeDto removeEmployeeFromDep(PresentDepartmentDto dDto, Integer id) {

        List<ErrorDto> errors = presentDepNameValidation.validate(dDto);
        Employee employee = eRepository.findEmployeeById(id);

        if (errors.isEmpty() && employee != null) {

            String dName = dDto.getDepartmentName();
            Department department = dRepository.getDepartmentsRepository().get(dName);
            employee.setDepartmentName("not defined");
            department.getDepartmentPersonal().remove(employee);
            return new PresentEmployeeDto(id, employee.getFirstName(), employee.getLastName(), employee.getPosition(), "not defined", errors);
        } else {
            return new PresentEmployeeDto(0, "-", "-", "-", "-", errors);
        }
    }

    public EmployeeListDto findDepEmployees(DepartmentDto dto) {

        List<ErrorDto> errors = presentDepNameValidation.validate(dto);

        if (errors.isEmpty()) {

            Department department = dRepository.getDepartmentsRepository().get(dto.getDepartmentName());
            List<Employee> employees = department.getDepartmentPersonal();

            List<PresentEmployeeDto> employeeDtos = employees.stream()
                    .map(e -> new PresentEmployeeDto(e.getPersonalId(), e.getFirstName(), e.getLastName(), e.getPosition(), e.getDepartmentName(), new ArrayList<>()))
                    .toList();
            return new EmployeeListDto(employeeDtos, errors);
        } else {
            return new EmployeeListDto(new ArrayList<>(), errors);
        }
    }


    ValidationInterface<DepartmentDto> newDepValidation = new ValidationInterface<DepartmentDto>() {
        @Override
        public List<ErrorDto> validate(DepartmentDto request) {
            List<ErrorDto> error = new ArrayList<>();
            DepartmentDto dto;
            String name;

            if (request == null) {
                error.add(new ErrorDto(ErrorCodes.ER401, "Request should not be empty"));
                return error;
            } else {
                try {
                    dto = (DepartmentDto) request;
                    name = dto.getDepartmentName();
                } catch (Exception e) {
                    error.add(new ErrorDto(ErrorCodes.ER402, "Request in wrong format"));
                    return error;
                }
            }
            if (dRepository.getDepartmentsRepository().containsKey(name)) {
                error.add(new ErrorDto(ErrorCodes.ER403, "Name already exist"));
                return error;
            }

            if (name.length() < 3 || name.length() > 20) {
                error.add(new ErrorDto(ErrorCodes.ER405, "Name length must be between 3 and 20 characters"));
                return error;
            }
            return error;
        }
    };


    ValidationInterface<DepartmentDto> presentDepNameValidation = new ValidationInterface<DepartmentDto>() {
        @Override
        public List<ErrorDto> validate(DepartmentDto request) {
            List<ErrorDto> errors = new ArrayList<>();
            DepartmentDto dto;
            String name;

            if (request == null) {
                errors.add(new ErrorDto(ErrorCodes.ER401, "Request should not be empty"));
                return errors;
            } else {
                try {
                    dto = (DepartmentDto) request;
                    name = dto.getDepartmentName();
                } catch (Exception e) {
                    errors.add(new ErrorDto(ErrorCodes.ER402, "Request in wrong format"));
                    return errors;
                }
            }

            if (dRepository.getDepartmentsRepository().containsKey(name)) {
                return errors;
            } else {
                return errors;
            }
        }
    };
}

