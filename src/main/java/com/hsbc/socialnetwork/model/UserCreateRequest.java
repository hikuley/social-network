package com.hsbc.socialnetwork.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserCreateRequest extends BaseDto {


    private static final int NICKNAME_MIN_LENGTH = 4;
    private static final int NICKNAME_MAX_LENGTH = 100;

    private static final int PASSWORD_MIN_LENGTH = 4;
    private static final int PASSWORD_MAX_LENGTH = 100;

    private static final String EMAIL_MESSAGE = "Must be a well-formed email address";

    private String firstName;
    private String lastName;


    @NotNull
    @Size(min = NICKNAME_MIN_LENGTH, max = NICKNAME_MAX_LENGTH)
    private String nickName;

    @Email(message = EMAIL_MESSAGE)
    private String email;

    @NotNull
    @Size(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH)
    private String password;

    public UserCreateRequest() {
    }

    public UserCreateRequest(String firstName, String lastName, String nickName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
