package com.github.abraham054.finalreality.controller.phases;

public class StartTurnsPhase extends Phase{
    @Override
    public String toString() {
        return "StartTurnsPhase";
    }

    @Override
    public void toCheckQueuePhase(){
        changePhase(new CheckQueuePhase());
    }

    @Override
    public void StartTurns(){
        controller.startTurns();
        toCheckQueuePhase();
    }
}
