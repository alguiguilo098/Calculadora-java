package Implementacao;

import java.util.HashMap;
import java.util.Map;

import Exeception.KeybordException;
import Interfacecalculator.Digits;
import Interfacecalculator.IKey;
import Interfacecalculator.IKeybord;
import Interfacecalculator.Operation;

public class Keybord implements IKeybord {
    Map<String,IKey> hash_key;
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
        
}
