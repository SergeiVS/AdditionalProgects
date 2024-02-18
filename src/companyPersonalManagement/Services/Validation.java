package companyPersonalManagement.Services;

import com.sun.net.httpserver.Request;
import companyPersonalManagement.dtos.errorsDto.ErrorDto;


import java.util.List;

public interface Validation <T>{

    List<ErrorDto> validate(T request);

}
