package com.vmware.calculate.model;

import org.springframework.http.HttpStatus;

public class BaseResponseTO<T> {

    private HttpStatus status;
    private int statusCode;
    private String message;
    private T result;

    public BaseResponseTO() {
    }

    /**
     * @param status
     * @param message
     */
    public BaseResponseTO(HttpStatus status, String message) {
        super();
        this.status = status;
        this.statusCode = status.value();
        this.message = message;
    }

    /**
     * @param status
     * @param message
     * @param result
     */
    public BaseResponseTO(HttpStatus status, String message, T result) {
        super();
        this.status = status;
        this.statusCode = status.value();
        this.message = message;
        this.result = result;
    }

    /**
     * @return the status
     */
    public HttpStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    /**
     * @return the statusCode
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * @param statusCode the statusCode to set
     */
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the response
     */
    public T getResult() {
        return result;
    }

    /**
     * @param result the response to set
     */
    public void setResult(T result) {
        this.result = result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BaseResponseTO [status=" + status + ", message=" + message + ", result=" + result;
    }
}
