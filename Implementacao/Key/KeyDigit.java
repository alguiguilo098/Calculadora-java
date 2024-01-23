package Implementacao.Key;
import Interfacecalculator.IKey;
import Exeception.CPUException;
import Interfacecalculator.Digits;
import Interfacecalculator.IKeybord;
public class KeyDigit implements IKey {
    Digits digit;
    IKeybord keybord;
    public KeyDigit(Digits digit){
        this.digit=digit;
    }
    public void setkeybord(IKeybord keybord){
        this.keybord=keybord;
    }
    @Override
    public void press(){
        try {
            this.keybord.getcpu().recive(this.digit);
        } catch (CPUException e) {
            System.err.println(e.getMessage());
        }
    }    
}
