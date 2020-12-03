package com.github.cc3002.finalreality.model.gameControllerTest;

import com.github.abraham054.finalreality.controller.GameController;
import com.github.abraham054.finalreality.model.character.Enemy;
import com.github.abraham054.finalreality.model.character.ICharacter;
import com.github.abraham054.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.abraham054.finalreality.model.weapon.IWeapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

public class GameControllerTest implements IGameControllerTest{
    protected GameController gameController;

    @BeforeEach
    public void setController(){
        gameController = new GameController();
    }

    @BeforeEach
    public void setTurns(){
        LinkedList<IWeapon> weapons = gameController.getInventory();
        gameController.equipWeapon(2,weapons.getFirst()); //Knight no puede equipar baston

        gameController.equipWeapon(4,weapons.getFirst()); //Mago blanco equipa baston
        gameController.equipWeapon(0,weapons.getFirst()); //Mago oscuro equipa baston
        gameController.equipWeapon(1,weapons.getFirst()); //Ingeniero equipa Hacha
        gameController.equipWeapon(3,weapons.getFirst()); //Ladron equipa espada
        gameController.equipWeapon(2,weapons.getFirst()); //Caballero equipa cuchillo

        gameController.equipWeapon(1,weapons.getFirst()); //Ingeniero equipa arco

        gameController.startTurns();
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Override
    public void testLists() {
        LinkedList<AbstractPlayerCharacter> playersCharacters = gameController.getPlayerCharacters();
        LinkedList<Enemy> enemies = gameController.getEnemies();
        LinkedList<IWeapon> inventory = gameController.getInventory();
        assertEquals(5,playersCharacters.size());
        assertEquals(5,enemies.size());
        assertEquals(1,inventory.size());
    }

    @Test
    @Override
    public void testTurns() {
        BlockingQueue<ICharacter> queue = gameController.getTurns();
        assertEquals(10,queue.size());
        AbstractPlayerCharacter playerCharacter= gameController.getAlly(0);
        Enemy enemy = gameController.getEnemy(0);
        gameController.attackEnemy(playerCharacter,enemy);
        assertEquals(9,queue.size());
        gameController.attackPlayer(enemy);
        assertEquals(8,queue.size());
    }

    @Test
    @Override
    public void testFight() {
        LinkedList<AbstractPlayerCharacter> playersCharacters = gameController.getPlayerCharacters();
        LinkedList<Enemy> enemies = gameController.getEnemies();
        for (AbstractPlayerCharacter playerChar :
                playersCharacters) {
            gameController.attackEnemy(playerChar,enemies.getFirst());
        }
        for (Enemy enemy :
                enemies) {
            for (int i = 0; i < 5; i++) {
                gameController.attackPlayer(enemy);
            }
        }
    }

    @Test
    @Override
    public void testDead() {
        assertFalse(gameController.deadEnemies());
        assertFalse(gameController.deadAllies());
        for (int i = 0; i < 5;i++) {
            gameController.getEnemies().remove();
            gameController.getPlayerCharacters().remove();
        }
        assertTrue(gameController.deadEnemies());
        assertTrue(gameController.deadAllies());
    }

    @Test
    @Override
    public void testWeapon(){
        LinkedList<IWeapon> weapons = gameController.getInventory();
        AbstractPlayerCharacter playerCharacter = gameController.getAlly(0);

    }


}
