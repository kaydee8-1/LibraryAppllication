package pl.library.model;

public class ArgumentOutsideRangeException extends RuntimeException {
    private String object;
    private int leftBoundary;
    private int rightBoundary;

    public ArgumentOutsideRangeException(String object, int leftBoundary, int rightBoundary) {
        this.leftBoundary = leftBoundary;
        this.rightBoundary = rightBoundary;
        this.object = object;
    }

    @Override
    public String getMessage() {
        return object + " is outside of range " + leftBoundary + " - " + rightBoundary;
    }
}
