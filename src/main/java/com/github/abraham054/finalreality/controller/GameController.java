package com.github.abraham054.finalreality.controller;

import com.github.abraham054.finalreality.model.character.*;
import com.github.abraham054.finalreality.model.character.player.IPlayerCharacter;
import com.github.abraham054.finalreality.model.weapon.IWeapon;
import com.github.abraham054.finalreality.utils.characterFactories.EnemyFactory.*;
import com.github.abraham054.finalreality.utils.characterFactories.PlayerFactory.*;
import com.github.abraham054.finalreality.utils.weaponFactory.*;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;

public class GameController {
    private final LinkedList<IPlayerCharacter> playerCharacters = new LinkedList<>();
    private final LinkedList<Enemy> enemies = new LinkedList<>();
    private final LinkedList<IWeapon> inventory = new LinkedList<>();
    private BlockingQueue<ICharacter> turns;

    GameController(){
        createPlayer();
        createEnemies();
        createInventory();
    }

    private void createPlayer(){
        addPlayerCharacter(new BlackMageFactory(turns, "Mago oscuro"));
        addPlayerCharacter(new EngineerFactory(turns,"El industrial"));
    }

    private void createEnemies(){
        addEnemy(new GoblinFactory(turns,"Goblin"));
        addEnemy(new DemonFactory(turns,"Demonio"));
        addEnemy(new TrollFactory(turns,"Troll"));
    }

    private void createInventory(){
        addWeapon(new StaffFactory("Baston magico"));
        addWeapon(new AxeFactory("Hacha enana"));
    }

    public void addPlayerCharacter(IPlayerFactory factory){
        playerCharacters.add(factory.make());
    }

    public void addEnemy(IEnemyFactory factory){
        enemies.add(factory.make());
    }

    public void addWeapon(IWeaponFactory factory) { inventory.add(factory.make());}

}
