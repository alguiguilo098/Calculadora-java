import Implementacao.CPU;
import Implementacao.Display;
import Implementacao.Keybord;
import Interfacecalculator.IDisplay;
import Interfacecalculator.IKeybord;
import Interfacecalculator.Operation;
import Interfacecalculator.Digits;
public class main {
    public static void main(String[] args) {
       IDisplay d=new Display();
       IKeybord k= new Keybord();
       CPU cpu=new CPU();
       try { 
        cpu.setdisplay(d);
        cpu.recive(Digits.ONE);
        cpu.recive(Digits.ONE);
        cpu.recive(Digits.ONE);
        cpu.recive(Operation.SIGNAL);
        cpu.recive(Operation.ADD);
        cpu.recive(Digits.ONE);
        cpu.recive(Digits.ONE);
        cpu.recive(Operation.EQUAL);
       } catch (Exception e) {
       }
    }   
}
