package com.github.cc3002.finalreality.model.combatTest;

import com.github.abraham054.finalreality.model.character.Enemy;
import com.github.abraham054.finalreality.model.character.ICharacter;
import com.github.abraham054.finalreality.model.character.player.PlayerCharacter;
import com.github.abraham054.finalreality.model.character.player.MagicPlayer.MagicClasses.WhiteMage;
import com.github.abraham054.finalreality.model.weapon.MagicWeapon.MagicWeapon;
import com.github.abraham054.finalreality.model.weapon.Weapon;
import com.github.abraham054.finalreality.model.weapon.WeaponTypes.MagicWeaponType;
import org.junit.jupiter.api.BeforeEach;

import java.util.concurrent.BlockingQueue;

public abstract class AbstractCombat implements ICombat{

    protected BlockingQueue<ICharacter> turns;
    protected Enemy testEnemyFighter;
    protected String nameEnemyFighter;
    protected int healthEnemyFighter;
    protected PlayerCharacter testCharFighter;
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
        staff = new MagicWeapon("PaloMagico", 8, 60
                , MagicWeaponType.STAFF, 150);
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
