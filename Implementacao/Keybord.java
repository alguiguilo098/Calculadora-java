package Implementacao;

import java.util.HashMap;
import java.util.Map;

import Exeception.CPUException;
import Exeception.KeybordException;
import Interfacecalculator.Digits;
import Interfacecalculator.ICPU;
import Interfacecalculator.IKey;
import Interfacecalculator.IKeybord;
import Interfacecalculator.Operation;

public class Keybord implements IKeybord {

    Map<String,IKey> hash_key;
    ICPU cpu;
    public Keybord(){
        this.hash_key=new HashMap<>();
    }
    @Override
    public void setkey(String name,IKey key) throws KeybordException {
        try {
            if (key==null) {
                throw new KeybordException("key is null");
            }
            this.hash_key.put(name, key);
        } catch (KeybordException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public IKey getkey(Operation value){
        return this.hash_key.get(value.toString());
    }

    @Override
    public IKey getkey(Digits value) {
        return this.hash_key.get(value.toString());
    }
    @Override
    public IKey getkey(String value) {
        return this.hash_key.get(value);
    }
    @Override
    public ICPU getcpu() {
        return this.cpu;
    }
    @Override
    public void setcpu(ICPU cpu) {
        try{
            if (cpu==null) {
                throw new CPUException("CPU não foi encontrada");
            }
            this.cpu=cpu;
        }catch(CPUException e){
            System.err.println(e.getMessage());
        }
    }
        
}
