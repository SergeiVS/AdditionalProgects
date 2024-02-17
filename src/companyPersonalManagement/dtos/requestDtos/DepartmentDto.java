package companyPersonalManagement.dtos.requestDtos;

public class DepartmentDto extends Request {
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
