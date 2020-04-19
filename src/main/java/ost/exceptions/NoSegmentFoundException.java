package ost.exceptions;

public class NoSegmentFoundException extends SegmentDataException {
    public NoSegmentFoundException() {
        super("The given segment doesn't exist");
    }

    public NoSegmentFoundException(String message) {
        super(message);
    }
}
