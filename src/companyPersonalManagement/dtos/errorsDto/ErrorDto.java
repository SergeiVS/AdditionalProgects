package companyPersonalManagement.dtos.errorsDto;

public class ErrorDto {
    private final ErrorCodes errorCode;

    private final String message;

    public ErrorDto(ErrorCodes errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public ErrorCodes getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ErrorDto{" +
                "errorCode=" + errorCode +
                ", message='" + message + '\'' +
                '}';
    }
}
