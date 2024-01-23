package Implementacao.Key;

import Exeception.CPUException;
import Interfacecalculator.IKey;
import Interfacecalculator.IKeybord;
import Interfacecalculator.Operation;

public class KeyOperation implements IKey {
    Operation operation;
    IKeybord keybord;
    public KeyOperation(Operation operation){
        this.operation=operation;
    }
    public void setkeybord(IKeybord keybord){
        this.keybord=keybord;
    }
    @Override
    public void press() {
        try {
            this.keybord.getcpu().recive(operation);
        } catch (CPUException e) {
            System.err.println(e.getMessage());
        }
    }

    
}
