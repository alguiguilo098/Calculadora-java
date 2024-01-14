package Implementacao.Key;

import Interfacecalculator.IKey;
import Interfacecalculator.IKeybord;
import Interfacecalculator.Operation;

public class KeyOperation implements IKey {
    Operation operation;
    IKeybord keybord;
    public KeyOperation(Operation operation){
        this.operation=operation;
    }

    @Override
    public void press() {
        System.out.println(this.operation.toString());
    }
    
}
