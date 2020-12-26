package com.github.abraham054.finalreality.controller.phases;

import com.github.abraham054.finalreality.controller.exceptions.InvalidTransitionException;

public class CheckQueuePhase extends Phase{

    @Override
    public String toString() {
        return "CheckQueuePhase";
    }

    @Override
    public void toTurnPhase() throws InvalidTransitionException {
        if(checkQueue()){
            changePhase(new TurnPhase());
        }else{
            throw new InvalidTransitionException("The queue is still empty");
        }
    }

    @Override
    public void toStartTurnsPhase() {
        changePhase(new StartTurnsPhase());
    }
}
