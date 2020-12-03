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
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Creates the game controller in charge of the game logic, has a list for each enemy, player character and weapon available.
 * */
public class GameController {
    private final LinkedList<AbstractPlayerCharacter> playerCharacters = new LinkedList<>();
    private final LinkedList<Enemy> enemies = new LinkedList<>();
    private final LinkedList<IWeapon> inventory = new LinkedList<>();
    private final BlockingQueue<ICharacter> turns = new LinkedBlockingDeque<>();

    /**
     * The constructor starts by creating the player characters, enemies and weapon in the inventory.
     * */
    public GameController(){
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
     * Makes a player character attack an enemy, if killed removes it from the enemies and turns list.
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
     * Makes an enemy attack a random character from the player characters list, if it dies removes it from
     * the turns and player characters list, also adding the weapon to the inventory back.
     * */
    public void attackPlayer(Enemy enemy){
        int len = playerCharacters.size();
        Random ran = new Random();
        int nxt = ran.nextInt(len);
        AbstractPlayerCharacter objective = playerCharacters.get(nxt);
        enemy.attack(objective);
        if (objective.getHealthPoints() <=0){
            playerCharacters.remove(nxt);
            turns.remove(objective);
            inventory.add(objective.getEquippedWeapon());
        }
        endTurn(enemy);
    }

    /**
     * Function that goes by every player character from the list and starts
     * the count of when it gets added to the turns Blocking queue
     * */
    private void startAllyTurns(){
        for (AbstractPlayerCharacter playerCharacter:
             playerCharacters) {
            playerCharacter.waitTurn();
        }
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
     * Checks if the enemies are all dead, by checking if the list is empty
     * */
    public boolean deadEnemies(){
        return enemies.isEmpty();
    }

    /**
     * Checks if the allies are all dead, by checking if the list is empty
     * */
    public boolean deadAllies(){
        return playerCharacters.isEmpty();
    }

    /**
     * Equips a viable weapon to an ally, if the ally already has a weapon equipped it swaps them
     * and adds the free one back to the inventory.
     * */
    public void equipWeapon(int index,IWeapon weapon){
        AbstractPlayerCharacter playerCharacter = getAlly(index);
        boolean isArmed = false;
        IWeapon equippedWeapon = null;
        if( playerCharacter.getEquippedWeapon() != null){
            isArmed = true;
            equippedWeapon = playerCharacter.getEquippedWeapon();
        }
        if (playerCharacter.equipWeapon(weapon)){
            getInventory().remove(weapon);
            if(isArmed){
                getInventory().add(equippedWeapon);
            }
        }
    }

    /**
     * Creates the player characters that are gone be playable and adds them to the player characters list
     * */
    private void createPlayer(){
        addPlayerCharacter(new BlackMageFactory(turns, "Mago oscuro"));
        addPlayerCharacter(new EngineerFactory(turns,"El industrial"));
        addPlayerCharacter(new KnightFactory(turns,"Artorias"));
        addPlayerCharacter(new ThiefFactory(turns,"Tifa"));
        addPlayerCharacter(new WhiteMageFactory(turns,"Gandalf"));
    }

    /**
     * Creates the enemies of the game and adds them to the enemies list
     * */
    private void createEnemies(){
        addEnemy(new GoblinFactory(turns,"Goblin"));
        addEnemy(new GoblinFactory(turns,"Goblin"));
        addEnemy(new GoblinFactory(turns,"Goblin"));
        addEnemy(new DemonFactory(turns,"Demonio"));
        addEnemy(new TrollFactory(turns,"Troll"));
    }

    /**
     * Creates the weapon that the player are going to equip, and adds them to the inventory
     * */
    private void createInventory(){
        addWeapon(new StaffFactory("Baston magico"));
        addWeapon(new StaffFactory("Baston oscuro"));
        addWeapon(new AxeFactory("Hacha enana"));
        addWeapon(new SwordFactory("Espada del olimpo"));
        addWeapon(new KnifeFactory("Daga oculta"));
        addWeapon(new BowFactory("Arco de elfo"));

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

    /**
     * Returns the list of the inventory.
     * */
    public LinkedList<IWeapon> getInventory(){
        return inventory;
    }

    /**
     * Returns the list of the enemies.
     * */
    public LinkedList<Enemy> getEnemies(){
        return enemies;
    }

    /**
     * Returns the list of the player characters.
     * */
    public LinkedList<AbstractPlayerCharacter> getPlayerCharacters(){
        return playerCharacters;
    }

    /**
     * Returns the ally in a specific position of the player characters linked list.
     * */
    public AbstractPlayerCharacter getAlly(int index){
        return playerCharacters.get(index);
    }

    /**
     * Returns the enemy in a specific position of the enemies linked list.
     * */
    public Enemy getEnemy(int index){
        return enemies.get(index);
    }

    /**
     * Returns the turns blocking queue.
     * */
    public BlockingQueue<ICharacter> getTurns(){
        return turns;
    }
}
