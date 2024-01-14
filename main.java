import Implementacao.Display;
import Interfacecalculator.IDisplay;
import Interfacecalculator.Digits;
public class main {
    public static void main(String[] args) {
       IDisplay d=new Display();
       try {
            d.show(Digits.ONE);
            d.show(Digits.TWO);
            Thread.sleep(10000);
            d.clear(); 
        
       } catch (Exception e) {
        // TODO: handle exception
       }
    }   
}
