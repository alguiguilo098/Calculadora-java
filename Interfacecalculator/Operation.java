package Interfacecalculator;

public enum Operation {
    ADD(0),SUBTRACTION(1),
    MULTIPLICATION(3),POINT(4),
    SQRT(5),PERCENTAGE(6),SIGNAL(10);
    
    int value;
    Operation(int value){
        this.value=value;
    }
    public int getValue() {
        return value;
    }
}
