package Exeception;

/**
 * KeyException
 */
public class KeyException extends Exception {
    String err;
    public KeyException(String err){
        this.err=err;
    }
    @Override
    public String getMessage() {
        return this.err;
    }
}