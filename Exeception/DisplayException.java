package Exeception;

public class DisplayException extends Exception {
    String err;
    public DisplayException(String err){
        this.err=err;
    }

    @Override
    public String getMessage() {
        return this.err;
    }
    
}
