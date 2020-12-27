package com.github.abraham054.finalreality.controller.handlers;

import com.github.abraham054.finalreality.controller.GameController;
import com.github.abraham054.finalreality.model.character.player.AbstractPlayerCharacter;

import java.beans.PropertyChangeEvent;

public class DeadPlayerHandler extends EventHandler {
    public DeadPlayerHandler(GameController controller) {
        super(controller);
    }

    /**
     * Tells the controller that a player died.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.playerIsDead((AbstractPlayerCharacter) evt.getNewValue());
    }
}
