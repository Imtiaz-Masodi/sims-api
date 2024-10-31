package app.soft_tenders.sims.pojo;

public class ExecutionResult<T> {
    private T payload;
    private String errorMessage;

    public ExecutionResult(T payload) {
        this.payload = payload;
    }

    public ExecutionResult(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return errorMessage == null;
    }
}
