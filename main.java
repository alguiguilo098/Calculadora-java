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
        cpu.recive(Digits.NINE);
        cpu.recive(Digits.NINE);
        cpu.recive(Digits.NINE);
        cpu.recive(Digits.EIGHT);
        cpu.recive(Operation.POINT);
        cpu.recive(Digits.EIGHT);
        cpu.recive(Digits.EIGHT);
        cpu.recive(Operation.ADD);
        cpu.recive(Digits.TWO);
        cpu.recive(Operation.EQUAL);
        System.out.println(cpu.getregister1());
        System.out.println(cpu.getregister2());
       } catch (Exception e) {
       }
    }   
}
