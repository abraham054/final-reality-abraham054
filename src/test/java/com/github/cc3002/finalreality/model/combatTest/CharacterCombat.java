package com.github.cc3002.finalreality.model.combatTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterCombat extends AbstractCombat{

    @Override
    public void setHealths() {
        healthEnemyFighter = 200;
        healthCharFighter = 20;
    }

    @Test
    @Override
    public void testFight() {
        /* Attack without weapon doesn't do damage */
        testCharFighter.attack(testEnemyFighter);
        assertEquals(200,testEnemyFighter.getHealthPoints());
        testCharFighter.equipWeapon(staff);
        /* Attack with weapon does 50 damage */
        testCharFighter.attack(testEnemyFighter);
        assertEquals(150,testEnemyFighter.getHealthPoints());
        /* Receives enough damage to get killed */
        testCharFighter.receiveDamage(40);
        assertEquals(0,testCharFighter.getHealthPoints());
        /* Can't attack without hp */
        testCharFighter.attack(testEnemyFighter);
        assertEquals(150,testEnemyFighter.getHealthPoints());
    }

}
