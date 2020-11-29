package com.github.cc3002.finalreality.model.combatTest;

import com.github.abraham054.finalreality.model.character.Enemy;
import com.github.abraham054.finalreality.model.character.ICharacter;
import com.github.abraham054.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.abraham054.finalreality.model.character.player.magicPlayer.WhiteMage;
import com.github.abraham054.finalreality.model.weapon.Weapon;
import com.github.abraham054.finalreality.model.weapon.magicWeapon.Staff;
import org.junit.jupiter.api.BeforeEach;

import java.util.concurrent.BlockingQueue;

public abstract class AbstractCombat implements ICombat{

    protected BlockingQueue<ICharacter> turns;
    protected Enemy testEnemyFighter;
    protected String nameEnemyFighter;
    protected int healthEnemyFighter;
    protected AbstractPlayerCharacter testCharFighter;
    protected String nameCharFighter;
    protected int healthCharFighter;
    protected int defense;
    protected Weapon staff;

    public abstract void setHealths();

    public void setNames(){
        nameEnemyFighter = "Goblin";
        nameCharFighter = "Mago";
    }

    public void setDefense(){
        defense = 10;
    }

    public void setAbstractFighter() {
        testEnemyFighter = new Enemy(nameEnemyFighter,20,defense,100,healthEnemyFighter,turns);
        testCharFighter = new WhiteMage(nameEnemyFighter,turns,defense,healthCharFighter,50);
    }

    private void setWeapon(){
        staff = new Staff("PaloMagico", 8, 60, 150);
    }

    @BeforeEach
    public void setUp(){
        setNames();
        setDefense();
        setHealths();
        setAbstractFighter();
        setWeapon();
    }
}
