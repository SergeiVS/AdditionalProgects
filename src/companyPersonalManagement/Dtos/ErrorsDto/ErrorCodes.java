package companyPersonalManagement.Dtos.ErrorsDto;

public enum ErrorCodes {
    ER401("parameter should not be empty", 401),
    ;

private String description;
private int errorCode;

    ErrorCodes(String description, int errorCode) {
        this.description = description;
        this.errorCode = errorCode;
    }
}
