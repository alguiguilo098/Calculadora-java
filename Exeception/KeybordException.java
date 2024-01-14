package Exeception;

public class KeybordException extends Exception {
    String err;
    public KeybordException(String err){
        this.err=err;
    }
    
    @Override
    public String getMessage() {
        return this.err;
    }
}
