package com.project.shopapp.exception;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized exception"),
    INVALID_KEY(1001, "Uncategorized error"),
    USER_EXISTED(1002, "User existed"),
    USERNAME_INVALID(1003, "Username must be at least {min} characters"),
    INVALID_PASSWORD(1004, "Password must be at least {min} characters"),
    USER_NOT_FOUND(1005, "User not found"),
    EMAIL_EXISTED(1006, "Email existed"),
    ROLE_NOT_FOUND(1007, "Role not found"),
    INVALID_CREDENTIALS(1008, "Invalid credentials"),
    ;

    private int code;
    private String message;

    ErrorCode(int code,String message) {
        this.code = code;
        this.message = message;
    }



    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
