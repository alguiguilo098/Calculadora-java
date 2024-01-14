package Interfacecalculator;

import Exeception.DisplayException;

/**
 * IDisplay
 */
public interface IDisplay {
    void show(Digits digit)throws DisplayException;
    void setsignal();
    void clear();
}