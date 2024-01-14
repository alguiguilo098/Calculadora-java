package Interfacecalculator;

import Exeception.KeybordException;

public interface IKeybord {
    void setkey(String name,IKey key)throws KeybordException;
    IKey getkey(Operation value);
    IKey getkey(Digits value);
    IKey getkey(String value);
}
