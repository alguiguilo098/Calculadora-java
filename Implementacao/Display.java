package Implementacao;

import Exeception.DisplayException;
import Interfacecalculator.Digits;
import Interfacecalculator.IDisplay;

public class Display implements IDisplay {
    int x=5;
    int y=0;
    private void one(){
        Graphics.gotoXY(x++,y);
        System.out.print("   11");
        Graphics.gotoXY(x++,y);
        System.out.print("  1 1");
        Graphics.gotoXY(x++,y);
        System.out.print("    1");
        Graphics.gotoXY(x++,y);
        System.out.print("    1");
        Graphics.gotoXY(x++,y);
        System.out.print("11111");
        this.x=5;
        this.y+=8;
    }
    private void two(){
        Graphics.gotoXY(x++,y);
        System.out.print("22222");
        Graphics.gotoXY(x++,y);
        System.out.print("    2");
        Graphics.gotoXY(x++,y);
        System.out.print("22222");
        Graphics.gotoXY(x++,y);
        System.out.print("2    ");
        Graphics.gotoXY(x++,y);
        System.out.print("22222");
        Graphics.gotoXY(x++,y);
        this.x=5;
        this.y+=8;
    }
    
    private void three(){
        Graphics.gotoXY(x++,y);
        System.out.print("33333");
        Graphics.gotoXY(x++,y);
        System.out.print("    3");
        Graphics.gotoXY(x++,y);
        System.out.print("33333");
        Graphics.gotoXY(x++,y);
        System.out.print("    3");
        Graphics.gotoXY(x++,y);
        System.out.print("33333");
        Graphics.gotoXY(x++,y);
        this.x=5;
        this.y+=8;
    }
    private void four(){
        Graphics.gotoXY(x++,y);
        System.out.print("4   4");
        Graphics.gotoXY(x++,y);
        System.out.print("4   4");
        Graphics.gotoXY(x++,y);
        System.out.print("44444");
        Graphics.gotoXY(x++,y);
        System.out.print("    4");
        Graphics.gotoXY(x++,y);
        System.out.print("    4");
        Graphics.gotoXY(x++,y);
        this.x=5;
        this.y+=8;
    }
    private void five(){
        Graphics.gotoXY(x++,y);
        System.out.print("55555");
        Graphics.gotoXY(x++,y);
        System.out.print("5    ");
        Graphics.gotoXY(x++,y);
        System.out.print("55555");
        Graphics.gotoXY(x++,y);
        System.out.print("    5");
        Graphics.gotoXY(x++,y);
        System.out.print("55555");
        Graphics.gotoXY(x++,y);
        this.x=5;
        this.y+=8;
    }
    private void six(){
        Graphics.gotoXY(x++,y);
        System.out.print("66666");
        Graphics.gotoXY(x++,y);
        System.out.print("6    ");
        Graphics.gotoXY(x++,y);
        System.out.print("66666");
        Graphics.gotoXY(x++,y);
        System.out.print("6   6");
        Graphics.gotoXY(x++,y);
        System.out.print("66666");
        Graphics.gotoXY(x++,y);
        this.x=5;
        this.y+=8;
    }
    private void seven(){
        Graphics.gotoXY(x++,y);
        System.out.print("77777");
        Graphics.gotoXY(x++,y);
        System.out.print("    7");
        Graphics.gotoXY(x++,y);
        System.out.print("    7");
        Graphics.gotoXY(x++,y);
        System.out.print("    7");
        Graphics.gotoXY(x++,y);
        System.out.print("    7");
        Graphics.gotoXY(x++,y);
        this.x=5;
        this.y+=8;
    }
    private void eight(){
        Graphics.gotoXY(x++,y);
        System.out.print("88888");
        Graphics.gotoXY(x++,y);
        System.out.print("8   8");
        Graphics.gotoXY(x++,y);
        System.out.print("88888");
        Graphics.gotoXY(x++,y);
        System.out.print("8   8");
        Graphics.gotoXY(x++,y);
        System.out.print("88888");
        Graphics.gotoXY(x++,y);
        this.x=5;
        this.y+=8;
    }
    private void nine(){
        Graphics.gotoXY(x++,y);
        System.out.print("99999");
        Graphics.gotoXY(x++,y);
        System.out.print("9   9");
        Graphics.gotoXY(x++,y);
        System.out.print("99999");
        Graphics.gotoXY(x++,y);
        System.out.print("    9");
        Graphics.gotoXY(x++,y);
        System.out.print("99999");
        Graphics.gotoXY(x++,y);
        this.x=5;
        this.y+=8;
    }
    private void zero(){
        Graphics.gotoXY(x++,y);
        System.out.print("00000");
        Graphics.gotoXY(x++,y);
        System.out.print("0   0");
        Graphics.gotoXY(x++,y);
        System.out.print("0   0");
        Graphics.gotoXY(x++,y);
        System.out.print("0   0");
        Graphics.gotoXY(x++,y);
        System.out.print("00000");
        Graphics.gotoXY(x++,y);
        this.x=5;
        this.y+=8;
        
    }
    @Override
    public void clear() {
        Graphics.cls();
        Graphics.gotoXY(0, 0);
    }
    @Override
    public void show(Digits digit) throws DisplayException {
        try {
            switch (digit) {
                case ONE:
                    this.one();
                    break;
                case TWO:
                    this.two();
                    break;
                case THREE:
                    this.three();
                    break;
                case FOUR:
                    this.four();
                    break;
                case FIVE:
                    this.five();
                    break;
                case SIX:
                    this.six();
                    break;
                case SEVEN:
                    this.seven();
                    break;
                case EIGHT:
                    this.eight();
                    break;
                case NINE:
                    this.nine();
                    break;
                case ZERO:
                    this.zero();
                    break;
                default:
                    throw new DisplayException("Caracter desconhecido");
            }
        } catch (DisplayException e) {
            System.err.println(e.getMessage());
        }
    }
    @Override
    public void setsignal() {
        
    }
    
}
