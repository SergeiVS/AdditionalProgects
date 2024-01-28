package companyPersonalManagement.Dtos;

public class NewDepartmentDto {
    private String departmentName;
    public NewDepartmentDto(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}
