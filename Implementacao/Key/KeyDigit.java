package Implementacao.Key;
import Interfacecalculator.IKey;
import Interfacecalculator.Digits;
import Interfacecalculator.IKeybord;
public class KeyDigit implements IKey {
    Digits digit;
    IKeybord keybord;
    public KeyDigit(Digits digit){
        this.digit=digit;
    }
    @Override
    public void press() {
        System.out.println(this.digit.toString());
    }    
}
