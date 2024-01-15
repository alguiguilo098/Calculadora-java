package Implementacao;

import Interfacecalculator.Digits;
import Interfacecalculator.ICPU;
import Interfacecalculator.IKey;
import Interfacecalculator.IKeybord;
import Interfacecalculator.Operation;

public class CPU implements ICPU {
    private Display display;
    
    public class Register{
        Double value;
        boolean signal;
        boolean ispoint;
        int pot;
        public Register(int value,boolean signal, int pot){
            this.signal=false;
            this.ispoint=false;
            this.pot=0;
            this.value=0.0;
        }
        void incremet_pot(){
            this.pot++;
        }
        void point(){
            this.pot=-1;
        }
        void decrement_pot(){
            this.pot--;
        }        
    }
    Operation operation;
    boolean isregister1=true;
    Register register1=new Register(0, false, 0);
    Register register2= new Register(0, false, 0);
    public Double getregister1(){
        return this.register1.value;
    }
    public Double getregister2(){
        return this.register2.value;
    }
    @Override
    public void recive(Digits digit) {
        if (isregister1) {
            if (register1.ispoint==false) {
                register1.value=register1.value*Math.pow(10, this.register1.pot>0?1:0)+digit.get_value();
                register1.incremet_pot();
            }else{        
                register1.value=register1.value+Math.pow(10, this.register1.pot)*digit.get_value();
                register1.decrement_pot();
            }
        }else{
            if (register2.ispoint==false) {
                register1.value=register1.value*Math.pow(10, this.register1.pot>0?1:0)+digit.get_value();
                register1.incremet_pot();
            }else{
                register2.value=register2.value+Math.pow(10, this.register2.pot)*digit.get_value();
                register1.decrement_pot();
            }
            }
        }
    }

    @Override
    public void recive(Operation operator) {
        switch (operator) {
            case SIGNAL:
                if (isregister1) {
                    this.register1.value=-this.register1.value;
                } else {
                    this.register1.value=-this.register1.value;
                }
                break;
            case ADD:
                
                break;
        }
    }
}
