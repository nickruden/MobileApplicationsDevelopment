package com.company.gate.logic;

/**
 * This file defines the Gate class.
 */
public class Gate {
    // TODO -- Fill in your code here
    public static final int IN = 1; // установка ворот "внутрь" для разрешения улиткам войти
    public static final int OUT = -1; // установка ворот "наружу" для разрешения улиткам выйти
    public static final int CLOSED = 0; // установка ворот в закрвтое положение
    private int mSwing; // текущее положение поворота ворот


    // установка ворот в одно из положений
    public boolean setSwing(int direction) {
        if (direction == -1 || direction == 0 || direction == 1) {
            mSwing = direction;
            return true;
        } else {
            return false;
        }
    }

    // открытие ворот в одну из сторон
    public boolean open(int direction) {
        if (direction == IN || direction == OUT) {
            setSwing(direction);
            return true;
        } else {
            return false;
        }
    }

    // установка ворот в закрытое положение
    public void close() {
        setSwing(CLOSED);
    }

    // получение значения положения ворот
    public int getSwingDirection() {
        return mSwing;
    }

    // управление движением в зависимости от положения ворот
    public int thru(int count) {
        if (mSwing == IN) {
            return count;
        } else {
            if (mSwing == OUT) {
                return -count;
            } else {
                return 0;
            }
        }
    }

    // переопределение объекта toString для текстового представления состояния ворот
    @Override
    public String toString() {
        if (getSwingDirection() == CLOSED) {
            return "This gate is closed";
        } else if (getSwingDirection() == IN) {
            return "This gate is open and swings to enter the pen only";
        } else if (getSwingDirection() == OUT) {
            return "This gate is open and swings to exit the pen only";
        } else {
            return "This gate has an invalid swing direction";
        }
    }

}
