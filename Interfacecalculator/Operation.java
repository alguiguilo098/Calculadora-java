package Interfacecalculator;

public enum Operation {
    ADD(0),SUBTRACTION(1),
    MULTIPLICATION(3),POINT(4),DIVISION(5),
    SQRT(6),PERCENTAGE(7),SIGNAL(8),
    EQUAL(9),CLEAR(10);
    
    int value;
    Operation(int value){
        this.value=value;
    }
    public int getValue() {
        return value;
    }
}
