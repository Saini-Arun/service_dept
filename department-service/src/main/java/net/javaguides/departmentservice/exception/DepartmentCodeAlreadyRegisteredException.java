package net.javaguides.departmentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DepartmentCodeAlreadyRegisteredException extends RuntimeException{

    private String message;

    public DepartmentCodeAlreadyRegisteredException(String message){
        super(message);
        this.message=message;
    }
}
