package com.github.abraham054.finalreality.controller;

import com.github.abraham054.finalreality.model.character.*;
import com.github.abraham054.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.abraham054.finalreality.model.weapon.IWeapon;
import com.github.abraham054.finalreality.utils.characterFactories.EnemyFactory.*;
import com.github.abraham054.finalreality.utils.characterFactories.PlayerFactory.*;
import com.github.abraham054.finalreality.utils.weaponFactory.*;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * The game controller in charge of the game logic, has a list for each enemy, player character and weapon available.
 * */
public class GameController {
    private final LinkedList<AbstractPlayerCharacter> playerCharacters = new LinkedList<>();
    private final LinkedList<Enemy> enemies = new LinkedList<>();
    private final LinkedList<IWeapon> inventory = new LinkedList<>();
    private BlockingQueue<ICharacter> turns;

    /**
     * The constructor starts by creating the player characters, enemies and weapon in the inventory.
     * */
    GameController(){
        createPlayer();
        createEnemies();
        createInventory();
    }

    /**
     * Receives a character, which can be an enemy or a player character, and end it's turn.
     * */
    private void endTurn(ICharacter character){
        turns.remove(character);
    }

    /**
     * Makes a player character attack an enemy, if killed removes it from the enemies list
     * */
    public void attackEnemy(AbstractPlayerCharacter playerCharacter, Enemy enemy){
        playerCharacter.attack(enemy);
        endTurn(playerCharacter);
        if(enemy.getHealthPoints()<=0){
            enemies.remove(enemy);
            turns.remove(enemy);
        }
    }

    /**
     * Makes an enemy attack a random character from the player characters list
     * */
    public void attackPlayer(Enemy enemy){
        int len = playerCharacters.size();
        Random ran = new Random();
        int nxt = ran.nextInt(len);
        enemy.attack(playerCharacters.get(nxt));
        endTurn(enemy);
    }

    /**
     * Function that goes by every player character from the list and starts
     * the count of when it gets added to the turns Blocking queue
     * */
    private boolean startAllyTurns(){
        for (AbstractPlayerCharacter playerCharacter:
             playerCharacters) {
            if(playerCharacter.getEquippedWeapon() != null){
                playerCharacter.waitTurn();
            } else return false;
        } return true;
    }

    /**
     * Function that goes by every enemy from the list and starts
     * the count of when it gets added to the turns Blocking queue
     * */
    private void startEnemyTurns(){
        for (Enemy enemy:
             enemies) {
            enemy.waitTurn();
        }
    }

    /**
     * Function that adds both enemies and allies to the blocking queue
     * */
    public void startTurns(){
        startAllyTurns();
        startEnemyTurns();
    }

    /**
     * Checks if the characters from a list are all dead, by checking if the list is empty
     * */
    public boolean deadTeam(LinkedList list){
        return list.isEmpty();
    }

    /**
     * Equips a viable weapon to an ally, if the ally already has a weapon equipped it swaps them
     * and adds the free one back to the inventory.
     * */
    private void equipWeapon(AbstractPlayerCharacter playerCharacter,IWeapon weapon){
        if (playerCharacter.equipWeapon(weapon)){
            inventory.remove(weapon);
            if( playerCharacter.getEquippedWeapon() != null){
                IWeapon equippedWeapon =  playerCharacter.getEquippedWeapon();
                inventory.add(equippedWeapon);
            }
        }
    }

    /**
     * Creates the player characters that are gone be playable and adds them to the player characters list
     * */
    private void createPlayer(){
        addPlayerCharacter(new BlackMageFactory(turns, "Mago oscuro"));
        addPlayerCharacter(new EngineerFactory(turns,"El industrial"));
    }

    /**
     * Creates the enemies of the game and adds them to the enemies list
     * */
    private void createEnemies(){
        addEnemy(new GoblinFactory(turns,"Goblin"));
        addEnemy(new DemonFactory(turns,"Demonio"));
        addEnemy(new TrollFactory(turns,"Troll"));
    }

    /**
     * Creates the weapon that the player are going to equip, and adds them to the inventory
     * */
    private void createInventory(){
        addWeapon(new StaffFactory("Baston magico"));
        addWeapon(new AxeFactory("Hacha enana"));
    }

    /**
     * Adds a pre design player character to the list, by using a factory
     * */
    public void addPlayerCharacter(IPlayerFactory factory){
        playerCharacters.add(factory.make());
    }

    /**
     * Adds a pre design enemy to the list, by using a factory
     * */
    public void addEnemy(IEnemyFactory factory){
        enemies.add(factory.make());
    }

    /**
     * Adds a pre design weapon to the list, by using a factory
     * */
    public void addWeapon(IWeaponFactory factory) { inventory.add(factory.make());}

}
