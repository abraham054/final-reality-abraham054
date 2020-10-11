package com.github.abraham054.finalreality.model.weapon;

import com.github.abraham054.finalreality.model.weapon.WeaponTypes.WeaponType;

/**
 * A class that holds all the information of a weapon.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public abstract class Weapon {

  private final String name;
  private final int weight;
  private final int damage;

  /**
   * Creates a weapon.
   * @param name    the weapon's name
   * @param weight  the weapon's weight
   * @param damage  the weapon's damage
   */
  protected Weapon(String name,int weight, int damage) {
    this.name = name;
    this.weight = weight;
    this.damage = damage;
  }

  /**
   * Returns the weapon's name
   * */
  public String getName() {
    return name;
  }

  /**
   * Returns the common weapon's damage
   * */
  public int getDamage(){
    return damage;
  }

  /**
   * Returns the weapon's weight
   * */
  public int getWeight() {
    return weight;
  }

  public abstract WeaponType getType();
}
