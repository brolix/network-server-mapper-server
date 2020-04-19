package ost.exceptions;

public class NoServerFoundInSegmentException extends SegmentDataException {
    public NoServerFoundInSegmentException() {
        super("The given server is not a part of that segment");
    }

    public NoServerFoundInSegmentException(String message) {
        super(message);
    }
}
