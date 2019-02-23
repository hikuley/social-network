package com.hsbc.socialnetwork.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse {

    private boolean success = true;

    @ApiModelProperty(required = true, notes = "Response code defining the business case or error of this response")
    private String responseCode;

    @ApiModelProperty(notes = "Default description for the response code")
    private String responseMessage;

    @ApiModelProperty(notes = "Response data")
    private Object data;


    public BaseResponse() {
    }

    public BaseResponse(Object data) {
        this.data = data;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
