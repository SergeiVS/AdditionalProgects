package companyPersonalManagement.Services;

import companyPersonalManagement.dtos.errorsDto.ErrorCodes;
import companyPersonalManagement.dtos.errorsDto.ErrorDto;
import companyPersonalManagement.dtos.requestDtos.DepartmentDto;
import companyPersonalManagement.dtos.requestDtos.NewDepartmentDto;

import companyPersonalManagement.dtos.responseDtos.AddNewUnitDto;
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

    Validation newDepValidation = new Validation() {
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

    public AddNewUnitDto addNewDepartment(NewDepartmentDto dto) {
        List<ErrorDto> errors = newDepValidation.validate(dto);
        if (errors.isEmpty()) {
            service.addNewDepartment(dto);
            return new AddNewUnitDto("Department was added successful", errors);
        } else {
            return new AddNewUnitDto("Error, department did not added", errors);
        }
    }

}

