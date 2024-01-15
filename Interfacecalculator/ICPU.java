package Interfacecalculator;

import Exeception.CPUException;

/**
 * ICPU
 */
public interface ICPU {
    void recive(Digits digit)throws CPUException;
    void recive(Operation operator)throws CPUException;
    void setdisplay(IDisplay display);
}
