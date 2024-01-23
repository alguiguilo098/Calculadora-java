import Implementacao.CPU;
import Implementacao.Display;
import Implementacao.Keybord;
import Implementacao.Key.KeyDigit;
import Implementacao.Key.KeyOperation;
import Interfacecalculator.Digits;
import Interfacecalculator.ICPU;
import Interfacecalculator.IDisplay;
import Interfacecalculator.IKeybord;
import Interfacecalculator.Operation;

public class Calculator {

    IDisplay display;
    IKeybord keybord;
    ICPU cpu;

    public Calculator(){
        this.cpu=new CPU();
        this.display=new Display();
        this.keybord=new Keybord();
        this.keybord.setcpu(cpu);
        this.cpu.setdisplay(display);
        try{
            KeyDigit keydigit= new KeyDigit(Digits.ZERO);
            this.keybord.setkey(Digits.ZERO.toString(), keydigit);
            keydigit.setkeybord(keybord);

            keydigit=new KeyDigit(Digits.ONE);
            this.keybord.setkey(Digits.ONE.toString(),keydigit);
            keydigit.setkeybord(keybord);

            keydigit=new KeyDigit(Digits.TWO);
            this.keybord.setkey(Digits.TWO.toString(),keydigit);
            keydigit.setkeybord(keybord);

            keydigit=new KeyDigit(Digits.THREE);
            this.keybord.setkey(Digits.THREE.toString(),keydigit );
            keydigit.setkeybord(keybord);

            keydigit=new KeyDigit(Digits.FOUR);
            this.keybord.setkey(Digits.FOUR.toString(),keydigit);
            keydigit.setkeybord(keybord);

            keydigit=new KeyDigit(Digits.FIVE);
            this.keybord.setkey(Digits.FIVE.toString(),keydigit );
            keydigit.setkeybord(keybord);

            keydigit=new KeyDigit(Digits.SIX);
            this.keybord.setkey(Digits.SIX.toString(),keydigit);
            keydigit.setkeybord(keybord);

            keydigit=new KeyDigit(Digits.SEVEN);
            this.keybord.setkey(Digits.SEVEN.toString(),keydigit);
            keydigit.setkeybord(keybord);

            keydigit=new KeyDigit(Digits.EIGHT);
            this.keybord.setkey(Digits.EIGHT.toString(),keydigit);
            keydigit.setkeybord(keybord);

            keydigit=new KeyDigit(Digits.NINE);
            this.keybord.setkey(Digits.NINE.toString(), keydigit);
            keydigit.setkeybord(keybord);

            KeyOperation keyoperation;

            this.keybord.setkey(Operation.ADD.toString(), keyoperation=new KeyOperation(Operation.ADD));
            keyoperation.setkeybord(keybord);


            this.keybord.setkey(Operation.SUBTRACTION.toString(), keyoperation=new KeyOperation(Operation.SUBTRACTION));
            keyoperation.setkeybord(keybord);

            this.keybord.setkey(Operation.MULTIPLICATION.toString(), keyoperation=new KeyOperation(Operation.MULTIPLICATION));
            keyoperation.setkeybord(keybord);
            
            this.keybord.setkey(Operation.DIVISION.toString(),keyoperation=new KeyOperation(Operation.DIVISION));
            keyoperation.setkeybord(keybord);
            
            this.keybord.setkey(Operation.SIGNAL.toString(), keyoperation=new KeyOperation(Operation.SIGNAL));
            keyoperation.setkeybord(keybord);
            
            this.keybord.setkey(Operation.PERCENTAGE.toString(), keyoperation=new KeyOperation(Operation.PERCENTAGE));
            keyoperation.setkeybord(keybord);
            
            this.keybord.setkey(Operation.SIGNAL.toString(), keyoperation=new KeyOperation(Operation.SIGNAL));
            keyoperation.setkeybord(keybord);
            
            this.keybord.setkey(Operation.CLEAR.toString(),keyoperation=new KeyOperation(Operation.CLEAR));
            keyoperation.setkeybord(keybord);
            
            this.keybord.setkey(Operation.POINT.toString(), keyoperation=new KeyOperation(Operation.POINT));
            keyoperation.setkeybord(keybord);
            
            this.keybord.setkey(Operation.EQUAL.toString(), keyoperation=new KeyOperation(Operation.EQUAL));
            keyoperation.setkeybord(keybord);
            
            this.keybord.setkey(Operation.SQRT.toString(), keyoperation=new KeyOperation(Operation.SQRT));
            keyoperation.setkeybord(keybord);

        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    IKeybord getkeybord(){
        return this.keybord;
    }
}
