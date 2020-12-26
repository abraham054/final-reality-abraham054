package com.github.abraham054.finalreality.controller.phases;

public class EnemyTurnPhase extends Phase{

    @Override
    public String toString() {
        return "EnemyTurnPhase";
    }

    @Override
    public void toCheckQueuePhase(){
        changePhase(new CheckQueuePhase());
    }

    @Override
    public void attack(){
        controller.turnAttackAPlayer();
        toCheckQueuePhase();
    }
}
