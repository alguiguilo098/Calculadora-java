import Implementacao.CPU;
import Implementacao.Display;
import Implementacao.Keybord;
import Interfacecalculator.IDisplay;
import Interfacecalculator.IKeybord;
import Interfacecalculator.Operation;
import Interfacecalculator.Digits;
public class main {

    public static void main(String[] args) {
       try { 
        Calculator c=new Calculator();
        c.getkeybord().getkey("ONE").press();
        c.getkeybord().getkey("TWO").press();
        c.getkeybord().getkey("TWO").press();
        c.getkeybord().getkey(Operation.PERCENTAGE).press();
        c.getkeybord();
    } catch (Exception e) {
        System.err.println("java");
       }
    }   
}