package com.leo.leo.util;

public class ErrorMessage {
    private String errorMsg;
    private  String status;

    public ErrorMessage(String errorMsg, String status) {
        this.errorMsg = errorMsg;
        this.status = status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
