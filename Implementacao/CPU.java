package Implementacao;

import Interfacecalculator.Digits;
import Interfacecalculator.ICPU;
import Interfacecalculator.IKey;
import Interfacecalculator.IKeybord;
import Interfacecalculator.Operation;

public class CPU implements ICPU {
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
        void clear(){
            this.signal=false;
            this.ispoint=false;
            this.pot=0;
            this.value=0.0;
        }        
    }
    
    private Display display;
    private Operation operation=Operation.ADD;
    private boolean isregister1=true;
    private Register register1=new Register(0, false, 0);
    private Register register2= new Register(0, false, 0);
    private void swapisregister(){
        this.isregister1=this.isregister1==true?false:true;
    }

    private void reset(){
        this.register1.clear();
        
        this.isregister1=true;
    }
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
                if (register1.value>0 || register1.value==0.0) {
                    register1.value=register1.value*Math.pow(10, this.register1.pot>0?1:0)+digit.get_value();
                }else{
                    register1.value=register1.value*Math.pow(10, this.register1.pot>0?1:0)-digit.get_value();
                }
                register1.incremet_pot();
            }else{
                if (register1.value>0 ||register1.value==0.0) {
                    register1.value=register1.value+Math.pow(10, this.register1.pot)*digit.get_value();
                }else{
                    register1.value=register1.value-Math.pow(10, this.register1.pot)*digit.get_value();
                }
                register1.decrement_pot();
            }
        }else{
            if (register2.ispoint==false) {
                if (register2.value>0 || register2.value==0.0) {
                    register2.value=register2.value*Math.pow(10, this.register2.pot>0?1:0)+digit.get_value();
                }else{
                    register2.value=register2.value*Math.pow(10, this.register2.pot>0?1:0)-digit.get_value();
                }
                register2.incremet_pot();
            }else{
                if (register1.value>0 ||register1.value==0.0) {
                    register1.value=register1.value+Math.pow(10, this.register1.pot)*digit.get_value();
                }else{
                    register1.value=register1.value-Math.pow(10, this.register1.pot)*digit.get_value();
                }
                register1.decrement_pot();
            }
            }
        }
    private void equal(){
        if (this.operation==Operation.ADD) {
            this.register1.value=this.register2.value+this.register1.value;
            this.register2.clear();
        } else if (this.operation==Operation.MULTIPLICATION) {
            this.register1.value=this.register1.value*this.register2.value;
            this.register2.clear();
        } else if (this.operation==Operation.SUBTRACTION) {
            this.register1.value=this.register1.value-this.register2.value;
            this.register2.clear();
        }else if (this.operation==Operation.SQRT) {
            this.register1.value=Math.sqrt(this.register1.value);
            this.register2.clear();
        }else if (this.operation==Operation.PERCENTAGE) {
            this.register1.value=this.register1.value/100;
            this.register2.clear();
        }else if (this.operation==Operation.DIVISION) {
            if(this.register1.value!=0){
                this.register1.value=this.register1.value/this.register2.value;
                this.register2.clear();
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
                    this.register2.value=-this.register1.value;
                }
                break;
            case POINT:
                if (isregister1) {
                    this.register1.ispoint=true;
                    this.register1.point();
                }else{
                    this.register2.ispoint=true;
                    this.register2.point();
                }
                break;
            case EQUAL:
                this.equal();
                break;  
            case ADD:
                this.swapisregister();
                if(this.isregister1)this.equal(); 
                this.operation=Operation.ADD;
                break;
            case SUBTRACTION:
                this.swapisregister();
                if(this.isregister1)this.equal(); 
                this.operation=Operation.SUBTRACTION;
                break;
            case MULTIPLICATION:
                this.swapisregister();
                if(this.isregister1)this.equal(); 
                this.operation=Operation.MULTIPLICATION;
                break;
            case DIVISION:
                this.swapisregister();
                if(this.isregister1==false)this.equal();  
                this.operation=Operation.DIVISION;
                break;
            case CLEAR:
                this.reset();
                break;
            default:
                break;
            }
        }
}
