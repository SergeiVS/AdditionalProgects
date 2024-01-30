package companyPersonalManagement.Dtos;

import companyPersonalManagement.Dtos.ErrorsDto.ErrorDto;

import java.util.List;

abstract class DepartmentDto {
    private final String departmentName;

    public DepartmentDto(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    @Override
    public String toString() {
        return "DepartmentDto{" +
                "departmentName='" + departmentName + '\'' +
                '}';
    }
}
