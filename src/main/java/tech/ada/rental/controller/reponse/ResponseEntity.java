package tech.ada.rental.controller.reponse;

import tech.ada.rental.enums.RequestStatus;

public class ResponseEntity<T>{

    private T data;
    private RequestStatus status;
    private String message;


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseEntity(T data, RequestStatus status, String message) {
        this.data = data;
        this.status = status;
        this.message = message;
    }

    public ResponseEntity() {
    }

    @Override
    public String toString() {
        return "ResponseEntity{" +
                "data=" + data +
                ", status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
