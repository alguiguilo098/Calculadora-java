package Implementacao;

import Exeception.CPUException;
import Exeception.DisplayException;
import Interfacecalculator.Digits;
import Interfacecalculator.ICPU;
import Interfacecalculator.IDisplay;
import Interfacecalculator.Operation;

public class CPU implements ICPU {
    public class Register{
        private Double value;
        private boolean signal;
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
    
    private IDisplay display;
    private Operation operation=Operation.ADD;
    private boolean isregister1=true;
    private int count_operation=0;
    private Register register1=new Register(0, false, 0);
    private Register register2= new Register(0, false, 0);

    private void swapisregister(){
        if (this.isregister1==true) {
            this.isregister1=false;
        }else{
            this.isregister1=true;
        }
    }

    private void reset(){
        this.register1.clear();
        this.register2.clear();        
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
                this.swapisregister();
                this.count_operation=0;
                this.equal();
                try {
                    this.showvalue(getregister1());
                    Thread.sleep(10000);
                } catch (Exception e) {
                }
                this.display.clear();
                break;  
            case ADD:
                if (this.count_operation==0) {
                    swapisregister();
                }
                this.count_operation++;
                if(this.isregister1==false)this.equal(); 
                this.operation=Operation.ADD;
                this.display.clear();
                break;
            case SUBTRACTION:
                if (this.count_operation==0) {
                    swapisregister();
                }
                this.count_operation++;
                if(this.isregister1==false)this.equal(); 
                this.operation=Operation.SUBTRACTION;
                break;
            case MULTIPLICATION:
                if (this.count_operation==0) {
                    swapisregister();
                }
                this.count_operation++;
                if(this.isregister1==false)this.equal(); 
                this.operation=Operation.MULTIPLICATION;
                break;
            case DIVISION:
                if (this.count_operation==0) {
                    swapisregister();
                }
                this.count_operation++;
                if(this.isregister1==false)this.equal();  
                this.operation=Operation.DIVISION;
                break;
            case CLEAR:
                this.reset();
                this.display.clear();
                break;
            default:
                break;
            }
        }
        private void showvalue(Double value) throws 
        DisplayException,
        CPUException{
            String valuestring=value.toString();
            for (int i = 0; i < valuestring.length(); i++) {
                switch (valuestring.charAt(i)) {
                    case '.':
                        try {
                            if (this.display==null) {
                                throw new CPUException("Não foi possível encontrar o display");
                            }
                            this.display.setsignal(Operation.POINT);

                        } catch (DisplayException display) {
                            System.err.println(display.getMessage());
                        }catch (CPUException cpu) {
                            System.err.println(cpu.getMessage());
                        }
                        break;
                    case '-':
                        try {
                            if (this.display==null) {
                                throw new CPUException("Não foi possível encontrar o display");
                            }
                            this.display.setsignal(Operation.SIGNAL);
                        } catch (DisplayException display) {
                            System.err.println(display.getMessage());
                        }catch (CPUException cpu) {
                            System.err.println(cpu.getMessage());
                        }
                        break;
                    case '1':
                        try {
                            if (this.display==null) {
                                throw new CPUException("Não foi possível encontrar o display");
                            }
                            this.display.show(Digits.ONE);

                        } catch (DisplayException display) {
                            System.err.println(display.getMessage());
                        }catch (CPUException cpu) {
                            System.err.println(cpu.getMessage());
                        }
                        break;
                    case '2':
                        try {
                            if (this.display==null) {
                                throw new CPUException("Não foi possível encontrar o display");
                            }
                            this.display.show(Digits.TWO);

                        } catch (DisplayException display) {
                            System.err.println(display.getMessage());
                        }catch (CPUException cpu) {
                            System.err.println(cpu.getMessage());
                        }
                        break;
                    case'3':
                        try {
                            if (this.display==null) {
                                throw new CPUException("Não foi possível encontrar o display");
                            }
                            this.display.show(Digits.THREE);

                        } catch (DisplayException display) {
                            System.err.println(display.getMessage());
                        }catch (CPUException cpu) {
                            System.err.println(cpu.getMessage());
                        }
                        break;
                    case '4':
                        try {
                            if (this.display==null) {
                                throw new CPUException("Não foi possível encontrar o display");
                            }
                            this.display.show(Digits.FOUR);

                        } catch (DisplayException display) {
                            System.err.println(display.getMessage());
                        }catch (CPUException cpu) {
                            System.err.println(cpu.getMessage());
                        }
                        break;
                    case '5':
                        try {
                            if (this.display==null) {
                                throw new CPUException("Não foi possível encontrar o display");
                            }
                            this.display.show(Digits.FIVE);

                        } catch (DisplayException display) {
                            System.err.println(display.getMessage());
                        }catch (CPUException cpu) {
                            System.err.println(cpu.getMessage());
                        }
                        break;
                    case '6':
                        try {
                            if (this.display==null) {
                                throw new CPUException("Não foi possível encontrar o display");
                            }
                            this.display.show(Digits.SIX);

                        } catch (DisplayException display) {
                            System.err.println(display.getMessage());
                        }catch (CPUException cpu) {
                            System.err.println(cpu.getMessage());
                        }
                        break;
                    case '7':
                        try {
                            if (this.display==null) {
                                throw new CPUException("Não foi possível encontrar o display");
                            }
                            this.display.show(Digits.SEVEN);

                        } catch (DisplayException display) {
                            System.err.println(display.getMessage());
                        }catch (CPUException cpu) {
                            System.err.println(cpu.getMessage());
                        }
                        break;
                    case '8':
                        try {
                            if (this.display==null) {
                                throw new CPUException("Não foi possível encontrar o display");
                            }
                            this.display.show(Digits.EIGHT);

                        } catch (DisplayException display) {
                            System.err.println(display.getMessage());
                        }catch (CPUException cpu) {
                            System.err.println(cpu.getMessage());
                        }
                        break;
                    case '9':
                        try {
                            if (this.display==null) {
                                throw new CPUException("Não foi possível encontrar o display");
                            }
                            this.display.show(Digits.NINE);

                        } catch (DisplayException display) {
                            System.err.println(display.getMessage());
                        }catch (CPUException cpu) {
                            System.err.println(cpu.getMessage());
                        }
                    case '0':
                        try {
                            if (this.display==null) {
                                throw new CPUException("Não foi possível encontrar o display");
                            }
                            this.display.show(Digits.ZERO);

                        } catch (DisplayException display) {
                            System.err.println(display.getMessage());
                        }catch (CPUException cpu) {
                            System.err.println(cpu.getMessage());
                        }
                }
            }
        }
        @Override
        public void setdisplay(IDisplay display) {
            this.display=display;
        }
}
