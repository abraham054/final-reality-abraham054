package com.github.cc3002.finalreality.model.gameControllerTest;

import com.github.abraham054.finalreality.controller.GameController;
import com.github.abraham054.finalreality.model.character.Enemy;
import com.github.abraham054.finalreality.model.character.ICharacter;
import com.github.abraham054.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.abraham054.finalreality.model.weapon.IWeapon;
import com.github.abraham054.finalreality.utils.characterFactories.PlayerFactory.BlackMageFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

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
        gameController.equipWeapon(2,weapons.get(0)); //Knight no puede equipar baston
        gameController.equipWeapon(4,weapons.get(0)); //Mago blanco equipa baston
        gameController.equipWeapon(0,weapons.get(1)); //Mago oscuro equipa baston
        gameController.equipWeapon(1,weapons.get(2)); //Ingeniero equipa Hacha
        gameController.equipWeapon(3,weapons.get(3)); //Ladron equipa espada
        gameController.equipWeapon(2,weapons.get(4)); //Caballero equipa cuchillo
        gameController.equipWeapon(1,weapons.get(5)); //Ingeniero equipa arco
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
        assertEquals(gameController.getSelectedAlly(),gameController.getAlly(0));
        assertEquals(gameController.getSelectedEnemy(),gameController.getEnemy(0));
        LinkedList<AbstractPlayerCharacter> playersCharacters = gameController.getPlayerCharacters();
        LinkedList<Enemy> enemies = gameController.getEnemies();
        LinkedList<IWeapon> inventory = gameController.getInventory();
        assertEquals(5,playersCharacters.size());
        assertEquals(5,enemies.size());
        assertEquals(6,inventory.size());
    }

    @Test
    @Override
    public void testWeaponStates(){
        assertFalse(gameController.getInventory().get(0).getIfAvailable());
        assertTrue(gameController.getInventory().get(2).getIfAvailable());
        assertEquals("not available",
                gameController.getInventory().get(0).getWeaponState().toString());
        assertEquals("is available",
                gameController.getInventory().get(2).getWeaponState().toString());
    }

    @Test
    @Override
    public void testTurns() {
        BlockingQueue<ICharacter> queue = gameController.getTurns();
        assertEquals(10,queue.size());
        AbstractPlayerCharacter playerCharacter= gameController.getSelectedAlly();
        Enemy enemy = gameController.getSelectedEnemy();
        gameController.attackEnemy(playerCharacter,enemy);
        assertEquals(9,queue.size());
        gameController.attackPlayer(enemy);
        assertEquals(8,queue.size());
        for (ICharacter character :
                gameController.getTurns()) {
            if(gameController.isAllyTurn()){
                gameController.allyTurn();
                gameController.startedTurn((AbstractPlayerCharacter) gameController.getTurnsHead());
                gameController.turnAttackAnEnemy();
            }else{
                gameController.turnAttackAPlayer();
            }
        }
    }

    @Test
    public void testEquippedTeam(){
        assertTrue(gameController.allTeamEquipped());
        gameController.addPlayerCharacter(new BlackMageFactory(new LinkedBlockingDeque<>(),"Mago de ejemplo"));
        assertFalse(gameController.allTeamEquipped());
    }

    @Test
    public void testStats(){
        AbstractPlayerCharacter playerCharacter = gameController.getAlly(1);
        LinkedList<String> playerStats = new LinkedList<>();
        playerStats.add(playerCharacter.getName());
        playerStats.add("Defense: " + String.valueOf(playerCharacter.getDefense()));
        playerStats.add("Health points: " + String.valueOf(playerCharacter.getHealthPoints()));
        playerStats.add("Arma: " + gameController.getAlly(1).getEquippedWeapon().getName());
        assertEquals(playerStats,gameController.getPlayerStats(1));
        LinkedList<String> enemyStats = new LinkedList<>();
        Enemy enemy = gameController.getEnemy(0);
        enemyStats.add(enemy.getName());
        enemyStats.add("Weight: " + String.valueOf(enemy.getWeight()));
        enemyStats.add("Defense: " + String.valueOf(enemy.getDefense()));
        enemyStats.add("Attack points: " + String.valueOf(enemy.getAttackPoints()));
        enemyStats.add("Health points: " + String.valueOf(enemy.getHealthPoints()));
        assertEquals(enemyStats,gameController.getEnemyStats(0));
        IWeapon weapon = gameController.getInventory().get(2);
        LinkedList<String> weaponStats = new LinkedList<>();
        weaponStats.add(weapon.getName());
        weaponStats.add(String.valueOf(weapon.getWeight()));
        weaponStats.add(String.valueOf(weapon.getDamage()));
        weaponStats.add(weapon.getWeaponState().toString());
        assertEquals(weaponStats,gameController.getWeaponStats(2));
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
            gameController.playerIsDead(gameController.getAlly(0));
            gameController.enemyIsDead(gameController.getEnemy(0));
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
