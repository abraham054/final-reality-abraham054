package com.github.cc3002.finalreality.model.combatTest;

import com.github.abraham054.finalreality.model.character.Enemy;
import com.github.abraham054.finalreality.model.character.ICharacter;
import com.github.abraham054.finalreality.model.character.player.commonPlayer.CommonClasses.Knight;
import com.github.abraham054.finalreality.model.character.player.magicPlayer.MagicClasses.WhiteMage;
import com.github.abraham054.finalreality.model.weapon.CommonWeapon.CommonWeapon;
import com.github.abraham054.finalreality.model.weapon.MagicWeapon.MagicWeapon;
import com.github.abraham054.finalreality.model.weapon.WeaponTypes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CombatTest {
    protected Enemy malulo;
    protected Knight quijote;
    protected WhiteMage howl;
    private BlockingQueue<ICharacter> turns;
    private MagicWeapon staff;
    int hp = 150;

    @BeforeEach
    void setUp(){
        CommonWeapon sword = new CommonWeapon("Frostmourne", 16, 120, CommonWeaponType.SWORD);
        staff = new MagicWeapon("PaloMagico", 8, 100, MagicWeaponType.STAFF, 150);
        malulo = new Enemy("Malulo",12,10,100,90,turns);
        quijote = new Knight("Quijote",turns,20,hp);
        howl = new WhiteMage("Howl",turns,20,120,50);

        quijote.equipWeapon(sword);
        //howl.equipWeapon(staff);
    }

    @Test
    void testFight(){
        assertEquals(150,quijote.getHealthPoints());
        malulo.attack(quijote);
        hp += -malulo.getAttackPoints()+quijote.getDefense();
        assertEquals(hp,quijote.getHealthPoints());
        howl.attack(quijote);
        assertEquals(hp,quijote.getHealthPoints());
        howl.equipWeapon(staff);
        howl.attack(quijote);
        hp += -howl.getEquippedWeapon().getDamage()+quijote.getDefense();
        assertEquals(hp,quijote.getHealthPoints());
        quijote.attack(malulo);
        assertEquals(90,malulo.getHealthPoints());
        howl.attack(malulo);
        malulo.attack(howl);
    }

}
