package com.github.abraham054.finalreality.controller.handlers;

import com.github.abraham054.finalreality.controller.GameController;
import com.github.abraham054.finalreality.model.character.AbstractCharacter;
import com.github.abraham054.finalreality.model.character.player.AbstractPlayerCharacter;

import java.beans.PropertyChangeEvent;

public class EndTurnHandler extends EventHandler {
    public EndTurnHandler(GameController controller) {
        super(controller);
    }

    /**
     * Tells the controller that a turn ended.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.endedTurn((AbstractCharacter) evt.getNewValue());
    }
}
