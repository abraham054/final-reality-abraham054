package com.github.abraham054.finalreality.controller.handlers;

import com.github.abraham054.finalreality.controller.GameController;
import com.github.abraham054.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.abraham054.finalreality.model.character.player.IPlayerCharacter;

import java.beans.PropertyChangeEvent;

public class BeginTurnHandler extends EventHandler {
    public BeginTurnHandler(GameController controller){
        super(controller);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.startedTurn((AbstractPlayerCharacter) evt.getNewValue());
    }
}
