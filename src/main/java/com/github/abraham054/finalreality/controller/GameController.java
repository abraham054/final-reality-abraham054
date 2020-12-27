package com.github.abraham054.finalreality.controller;

import com.github.abraham054.finalreality.controller.exceptions.InvalidTransitionException;
import com.github.abraham054.finalreality.controller.exceptions.InvalidTurnException;
import com.github.abraham054.finalreality.controller.handlers.*;
import com.github.abraham054.finalreality.controller.phases.Phase;
import com.github.abraham054.finalreality.controller.phases.StartTurnsPhase;
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
    private AbstractPlayerCharacter selectedPlayer;
    private Enemy selectedEnemy;

    private final IEventHandler beginTurnHandler = new BeginTurnHandler(this);
    private final IEventHandler endTurnHandler = new EndTurnHandler(this);
    private final IEventHandler deadPlayerHandler = new DeadPlayerHandler(this);
    private final IEventHandler deadEnemyHandler = new DeadEnemyHandler(this);

    private Phase phase;

    /**
     * The constructor starts by creating the player characters, enemies and weapon in the inventory
     * then sets the controller's phase to start turn phase and selects the first ally and enemy from their respective lists.
     * */
    public GameController(){
        createPlayer();
        createEnemies();
        setListeners();
        createInventory();
        setPhase(new StartTurnsPhase());
        selectAlly(0);
        selectEnemy(0);
    }

    /**
     * Returns the controller selected ally.
     */
    public AbstractPlayerCharacter getSelectedAlly(){
        return selectedPlayer;
    }

    /**
     * Returns the controller selected enemy.
     */
    public Enemy getSelectedEnemy(){
        return selectedEnemy;
    }

    /**
     * Changes the controller selected ally.
     */
    public void selectAlly(int index){
        selectedPlayer = getAlly(index);
    }

    /**
     * Changes the controller selected enemy.
     */
    public void selectEnemy(int index){
        selectedEnemy = getEnemy(index);
    }

    /**
     * sets the listeners for each enemy and ally.
     */
    private void setListeners() {
        for (AbstractPlayerCharacter playerCharacter:
             playerCharacters) {
            playerCharacter.addDeadListener(deadPlayerHandler);
            playerCharacter.addBeginTurnListener(beginTurnHandler);
            playerCharacter.addEndTurnListener(endTurnHandler);
        }
        for (Enemy enemy :
                enemies) {
            enemy.addDeadListener(deadEnemyHandler);
            enemy.addEndTurnListener(endTurnHandler);
        }
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
     * Gets the ally in the turns head and triggers it's the begin turn listener.
     */
    public void allyTurn(){
        AbstractPlayerCharacter playerCharacter = (AbstractPlayerCharacter) turns.peek();
        playerCharacter.isTurn();
    }

    /**
     * Makes the player character in the turns head attack the controller's selected enemy.
     */
    public void turnAttackAnEnemy(){
        AbstractPlayerCharacter playerCharacter = (AbstractPlayerCharacter) turns.peek();
        attackEnemy(playerCharacter,selectedEnemy);
    }

    /**
     * Makes the enemy in the turns head attack an ally.
     */
    public void turnAttackAPlayer() {
        Enemy enemy = (Enemy) turns.peek();
        attackPlayer(enemy);
    }

    /**
     * Makes a player character attack an enemy, if killed removes it from the enemies and turns list.
     * */
    public void attackEnemy(AbstractPlayerCharacter playerCharacter, Enemy enemy){
        playerCharacter.attack(enemy);
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
    }

    /**
     * Equips the controller's selected ally with a weapon.
     */
    public void equipSelectedAlly(IWeapon weapon){
        int index = playerCharacters.indexOf(selectedPlayer);
        equipWeapon(index,weapon);
    }

    /**
     * Equips a viable weapon to an ally, if the ally already has a weapon equipped it swaps them
     * and adds the free one back to the inventory.
     * */
    public void equipWeapon(int index,IWeapon weapon){
        AbstractPlayerCharacter playerCharacter = getAlly(index);
        IWeapon equippedWeapon = playerCharacter.getEquippedWeapon();
        if (playerCharacter.equipWeapon(weapon)){
            if( equippedWeapon != null){
                equippedWeapon.unEquip();
            }
            weapon.equip();
        }
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
     * Prints the name + a phrase saying that a player character started it's turn.
     */
    public void startedTurn(AbstractPlayerCharacter playerCharacter) {
        System.out.println(playerCharacter.getName()+ " started it's turn");
    }

    /**
     * Receives a character, which can be an enemy or a player character, and end it's turn.
     * */
    public void endedTurn(AbstractCharacter character) {
        System.out.println(character.getName()+ " ended it's turn");
        turns.remove(character);
    }

    /**
     * Tells that a player died and makes the necessary process to erase it from the player list.
     */
    public boolean playerIsDead(AbstractPlayerCharacter playerCharacter) {
        System.out.println(playerCharacter.getName()+ " is dead");
        turns.remove(playerCharacter);
        playerCharacters.remove(playerCharacter);
        playerCharacter.getEquippedWeapon().unEquip();
        return deadAllies();
    }

    /**
     * Tells that an enemy died and makes the necessary process to erase it from the enemy list.
     */
    public boolean enemyIsDead(Enemy enemy){
        System.out.println(enemy.getName()+ " is dead");
        turns.remove(enemy);
        enemies.remove(enemy);
        return deadEnemies();
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
        addEnemy(new GoblinFactory(turns,"Duende verde"));
        addEnemy(new GoblinFactory(turns,"Goblin enano"));
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
    public void addWeapon(IWeaponFactory factory) {
        inventory.add(factory.make());
    }

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

    /**
     * Returns the turns head.
     */
    public ICharacter getTurnsHead(){
        return turns.peek();
    }

    /**
     * Returns true if the turns head is an ally.
     */
    public Boolean isAllyTurn(){
        return getTurnsHead().isAlly();
    }

    /**
     * Changes the controller's phase.
     */
    public void setPhase(Phase phase) {
        this.phase = phase;
        phase.setController(this);
    }

    /**
     * Tries to interact with the controller's phase, if possible goes to start turns phase.
     */
    public void tryGoToMenu(){
        try{
            phase.toStartTurnsPhase();
        } catch (InvalidTransitionException e){
            e.printStackTrace();
        }
    }

    /**
     * Tries to interact with the controller's phase, if possible starts the turns.
     */
    public void tryBeginCombat(){
        if(allTeamEquipped()){
            try{
                phase.StartTurns();
            } catch (InvalidTurnException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * Tries to interact with the controller's phase, if possible starts playing a turn.
     */
    public void tryFight(){
        try{
            phase.playTurn();
        } catch (InvalidTurnException e){
            e.printStackTrace();
        }
    }

    /**
     * Tries to interact with the controller's phase, if possible goes to turn phase.
     */
    public void tryStartTurn() {
        try{
            phase.toTurnPhase();
        } catch (InvalidTransitionException e){
            e.printStackTrace();
        }
    }

    /**
     * Tries to interact with the controller's phase, if possible makes the player in the turn's head attack.
     */
    public void tryPlayerAttack(){
        try{
            phase.attack();
        } catch (InvalidTurnException e){
            e.printStackTrace();
        }
    }

    /**
     * Tries to interact with the controller's phase, checks if the turn's head is an enemy.
     * If it was an enemy makes it attack a player returning true, else returns false.
     */
    public boolean tryEnemyAttack() {
        if (!turns.peek().isAlly()) {
            try {
                phase.attack();
            } catch (InvalidTurnException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    /**
     * Checks if every player in the player's list has a weapon, if so returns true, else returns false.
     */
    public boolean allTeamEquipped() {
        for (AbstractPlayerCharacter playerChar :
                getPlayerCharacters()) {
            if (playerChar.getEquippedWeapon() == null){
                return false;
            }
        }
        return true;
    }

    /**
     * Returns a list with the stats of an specific player from the players list.
     */
    public LinkedList<String> getPlayerStats(int index){
        AbstractPlayerCharacter playerCharacter = getAlly(index);
        return playerCharacter.getStats();
    }

    /**
     * Returns a list with the stats of an specific enemy from the enemies list.
     */
    public LinkedList<String> getEnemyStats(int index){
        Enemy enemy = getEnemy(index);
        return enemy.getStats();
    }

    /**
     * Returns a list with the stats of an specific weapon from the weapons list.
     */
    public LinkedList<String> getWeaponStats(int index){
        return getInventory().get(index).getStats();
    }

    /**
     * Returns a string with the controller's phase name.
     */
    public String getPhaseString(){
        return phase.toString();
    }

    /**
     * Returns the controller's phase.
     */
    public Phase getPhase(){
        return phase;
    }

    /**
     * Checks if the controller's phase allows attacking, returning true if so, else returns false.
     */
    public boolean playerTurn() {
        return phase.canAttack();
    }
}
