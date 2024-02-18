package companyPersonalManagement.Services;

import companyPersonalManagement.dtos.errorsDto.ErrorDto;


import java.util.List;

public interface ValidationInterface<T>{

    List<ErrorDto> validate(T request);

}
