package app.soft_tenders.sims.pojo;

public class ApiResponse<T> {
    private final boolean isSuccess;
    private final String message;
    private T payload;

    public ApiResponse(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public ApiResponse(boolean isSuccess, String message, T payload) {
        this.isSuccess = isSuccess;
        this.message = message;
        this.payload = payload;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String getMessage() {
        return message;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public static String stringify(boolean isSuccess, String message) {
        return String.format("{ \"isSuccess\": %s, \"message\": \"%s\" }", isSuccess, message);
    }
}
