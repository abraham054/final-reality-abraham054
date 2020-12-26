package com.github.abraham054.finalreality.controller.handlers;

import com.github.abraham054.finalreality.controller.GameController;

import java.beans.PropertyChangeEvent;

public abstract class EventHandler implements IEventHandler{
    protected GameController controller;

    protected EventHandler(GameController controller){
        this.controller = controller;
    }

}
