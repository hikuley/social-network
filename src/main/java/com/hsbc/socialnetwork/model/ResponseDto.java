package com.hsbc.socialnetwork.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.validation.FieldError;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto {

    private Boolean status;
    private String message;
    private Object data;
    private List<FieldError> fieldErrors;


    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<FieldError> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<FieldError> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
