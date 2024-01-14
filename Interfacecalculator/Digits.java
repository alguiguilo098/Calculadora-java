package Interfacecalculator;

public enum Digits {
    ONE(1),TWO(2),
    THREE(3),FOUR(4),
    FIVE(5),SIX(6),
    SEVEN(7),EIGHT(8),
    NINE(9),ZERO(0);
    int value;
    Digits(int i){
        this.value=i;
    }
    public int get_value(){
        return this.value;
    }
}
