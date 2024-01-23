package Interfacecalculator;

import Exeception.KeybordException;

public interface IKeybord {
    void setkey(String name,IKey key)throws KeybordException;
    ICPU getcpu();
    void setcpu(ICPU cpu);
    IKey getkey(Operation value);
    IKey getkey(Digits value);
    IKey getkey(String value);
}
