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

import java.util.ArrayList;
import java.util.List;

public class DepartmentService {
    private final DepartmentRepositoryService service;
    private final DepartmentRepository repository;

    public DepartmentService(DepartmentRepositoryService service, DepartmentRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    public PresentDepartmentDto findDepartment(DepartmentDto dto){
        List<ErrorDto> errors = presentDepNameValidation.validate(dto);
        if (errors.isEmpty()){
            String name = dto.getDepartmentName();
            Department department = repository.getDepartmentsRepository().get(name);
            List<Employee> employees = department.getDepartmentPersonal();
            return new PresentDepartmentDto(name, employees, errors);
        }else {
            return new PresentDepartmentDto("-", new ArrayList<>(), errors);
        }
    }
    public AddRemoveUnitDto removeDepartment(DepartmentDto dto) {
        List<ErrorDto> errors = presentDepNameValidation.validate(dto);

        if (errors.isEmpty()) {
            String name = dto.getDepartmentName();
            repository.getDepartmentsRepository().remove(name);
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

    public PresentEmployeeDto addEmployeeToDep (PresentDepartmentDto dDto, Employee employee){
        List<ErrorDto> errors = presentDepNameValidation.validate(dDto);
        if (errors.isEmpty()) {
            String dName = dDto.getDepartmentName();
            Department department = repository.getDepartmentsRepository().get(dName);
            employee.setDepartmentName(dName);
            department.getDepartmentPersonal().add(employee);
            return new PresentEmployeeDto(employee.getFirstName(), employee.getLastName(), employee.getPosition(), employee.getDepartmentName(), errors);
        }else {
            return new PresentEmployeeDto("-","-","-","-",errors);
        }
    }
    public PresentEmployeeDto removeEmployeeFromDep (PresentDepartmentDto dDto, Employee employee){
        List<ErrorDto> errors = presentDepNameValidation.validate(dDto);
        if (errors.isEmpty()) {
            String dName = dDto.getDepartmentName();
            Department department = repository.getDepartmentsRepository().get(dName);
            employee.setDepartmentName(dName);
            department.getDepartmentPersonal().remove(employee);
            return new PresentEmployeeDto(employee.getFirstName(), employee.getLastName(), employee.getPosition(), "not defined", errors);
        }else {
            return new PresentEmployeeDto("-","-","-","-",errors);
        }
    }
    public EmployeeListDto findDepEmployees(DepartmentDto dto){
        List<ErrorDto> errors = presentDepNameValidation.validate(dto);
        if(errors.isEmpty()){
            Department department = repository.getDepartmentsRepository().get(dto.getDepartmentName());
            List<Employee> employees = department.getDepartmentPersonal();
            return new EmployeeListDto(employees, errors);
        }else {
            return new EmployeeListDto(new ArrayList<>(), errors);
        }
    }



    ValidationInterface newDepValidation = new ValidationInterface() {
        @Override
        public List<ErrorDto> validate(Object request) {
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
            if (repository.getDepartmentsRepository().containsKey(name)) {
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



    ValidationInterface presentDepNameValidation = new ValidationInterface() {
        @Override
        public List<ErrorDto> validate(Object request) {
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

            if (repository.getDepartmentsRepository().containsKey(name)) {
                return errors;
            } else {
                return errors;
            }
        }
    };
}

