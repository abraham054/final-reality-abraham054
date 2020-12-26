package com.github.abraham054.finalreality.controller.phases;

public class PlayerTurnPhase extends Phase{

    @Override
    public String toString() {
        return "PlayerTurnPhase";
    }

    @Override
    public void toCheckQueuePhase(){
        changePhase(new CheckQueuePhase());
    }

    @Override
    public void attack(){
        controller.turnAttackAnEnemy();
        toCheckQueuePhase();
    }

    @Override
    public boolean canAttack() {
        return true;
    }
}
