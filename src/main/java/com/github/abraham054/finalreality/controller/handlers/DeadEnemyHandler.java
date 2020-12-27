package com.github.abraham054.finalreality.controller.handlers;

import com.github.abraham054.finalreality.controller.GameController;
import com.github.abraham054.finalreality.model.character.Enemy;

import java.beans.PropertyChangeEvent;

public class DeadEnemyHandler extends EventHandler{
    public DeadEnemyHandler(GameController controller){
        super(controller);
    }

    /**
     * Tells the controller that an enemy died.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.enemyIsDead((Enemy) evt.getNewValue());
    }
}
