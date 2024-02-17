package companyPersonalManagement.entitys;

import java.util.Objects;

public class Employee {

    private Integer personalId;
    private String firstName;
    private String lastName;
    private String position;
    private String departmentName;

    public Employee(Integer personalId, String firstName, String lastName) {
        this.personalId = personalId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getPersonalId() {
        return personalId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(getPersonalId(), employee.getPersonalId()) && Objects.equals(getFirstName(), employee.getFirstName()) && Objects.equals(getLastName(), employee.getLastName()) && Objects.equals(getPosition(), employee.getPosition()) && Objects.equals(getDepartmentName(), employee.getDepartmentName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPersonalId(), getFirstName(), getLastName(), getPosition(), getDepartmentName());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "personalId=" + personalId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
