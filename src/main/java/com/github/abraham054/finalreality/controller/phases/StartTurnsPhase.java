package com.github.abraham054.finalreality.controller.phases;

public class StartTurnsPhase extends Phase{

    /**
     * Returns a string with the name of this phase.
     */
    @Override
    public String toString() {
        return "StartTurnsPhase";
    }

    /**
     * Changes phase to check queue phase.
     */
    @Override
    public void toCheckQueuePhase(){
        changePhase(new CheckQueuePhase());
    }

    /**
     * Makes the controller start turn then change phase to check queue phase.
     */
    @Override
    public void StartTurns(){
        controller.startTurns();
        toCheckQueuePhase();
    }
}
