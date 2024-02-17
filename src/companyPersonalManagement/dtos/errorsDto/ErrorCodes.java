package companyPersonalManagement.dtos.errorsDto;

public enum ErrorCodes {
    ER401("parameter should not be empty", 401),
    ER402("Wrong format request", 402),
    ER403("This name is already exsist", 403),
    ER405("Wrong string length", 405);


private String description;
private int errorCode;

    ErrorCodes(String description, int errorCode) {
        this.description = description;
        this.errorCode = errorCode;
    }
}
