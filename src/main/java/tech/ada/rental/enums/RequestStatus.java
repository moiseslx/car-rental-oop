package tech.ada.rental.enums;

public enum RequestStatus {
    NOT_FOUND(404),
    SUCCESS(200),
    BAD_REQUEST(400);

    private final int statusCode;

    RequestStatus(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
