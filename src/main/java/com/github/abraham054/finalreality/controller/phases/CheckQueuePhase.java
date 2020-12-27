package com.github.abraham054.finalreality.controller.phases;

import com.github.abraham054.finalreality.controller.exceptions.InvalidTransitionException;

public class CheckQueuePhase extends Phase{

    /**
     * Returns a string with the name of this phase.
     */
    @Override
    public String toString() {
        return "CheckQueuePhase";
    }

    /**
     * Tries to change the phase to turn phase if the controller's queue is not empty, if not able to change
     * throws an exception.
     */
    @Override
    public void toTurnPhase() throws InvalidTransitionException {
        if(checkQueue()){
            changePhase(new TurnPhase());
        }else{
            throw new InvalidTransitionException("The queue is still empty");
        }
    }

    /**
     * Changes phase to start turns phase.
     */
    @Override
    public void toStartTurnsPhase() {
        changePhase(new StartTurnsPhase());
    }
}
