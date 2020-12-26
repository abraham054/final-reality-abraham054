package com.github.abraham054.finalreality.model.weapon;

import com.github.abraham054.finalreality.utils.weaponStates.Available;
import com.github.abraham054.finalreality.utils.weaponStates.Occupied;
import com.github.abraham054.finalreality.utils.weaponStates.WeaponState;

/**
 * A class that holds all the information of a weapon.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public abstract class AbstractWeapon implements IWeapon{

  private final String name;
  private final int weight;
  private final int damage;
  protected WeaponState weaponState;

  /**
   * Creates a weapon.
   *
   * @param name    the weapon's name
   * @param weight  the weapon's weight
   * @param damage  the weapon's damage
   */
  protected AbstractWeapon(String name, int weight, int damage) {
    this.name = name;
    this.weight = weight;
    this.damage = damage;
    unEquip();
  }

  @Override
  public void equip(){
    weaponState = new Occupied();
  }

  @Override
  public void unEquip(){
    weaponState = new Available();
  }
  /**
   * Returns the weapon's name
   * */
  @Override
  public String getName() {
    return name;
  }

  /**
   * Returns the weapon's damage
   * */
  @Override
  public int getDamage(){
    return damage;
  }

  /**
   * Returns the weapon's weight
   * */
  @Override
  public int getWeight() {
    return weight;
  }

  @Override
  public boolean getIfAvailable(){
    return weaponState.isAvailable();
  }

  @Override
  public WeaponState getWeaponState(){
    return weaponState;
  }

}
