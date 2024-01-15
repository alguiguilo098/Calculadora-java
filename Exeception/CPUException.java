package Exeception;

public class CPUException extends Exception {
    String err;
    public CPUException(String err){
        this.err=err;
    }
    @Override
    public String getMessage() {
        return this.err;
    }
}
