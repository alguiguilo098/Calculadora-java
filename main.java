import Implementacao.CPU;
import Implementacao.Display;
import Implementacao.Keybord;
import Interfacecalculator.IDisplay;
import Interfacecalculator.IKeybord;
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
        System.out.println(cpu.getregister1());
       } catch (Exception e) {
       }
    }   
}
