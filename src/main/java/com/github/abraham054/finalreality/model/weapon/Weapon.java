package com.github.abraham054.finalreality.model.weapon;

import java.util.Objects;

/**
 * A class that holds all the information of a weapon.
 *
 * @author Ignacio Slater Muñoz.
 * @author <Your name>
 */
public class Weapon {

  private final String name;
  private final int weight;
  private final int damage;

  /**
   * Creates a weapon
   * @param name
   *     the weapon's name
   * @param weight
   *     the weapon's weight
   */
  public Weapon(String name,int weight, int damage) {
    this.name = name;
    this.weight = weight;
    this.damage = damage;
  }

  /**
   * Returns the weapon's name
   * */
  private String getName() {
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

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Weapon)) {
      return false;
    }
    final Weapon weapon = (Weapon) o;
    return getDamage() == weapon.getDamage() &&
        getWeight() == weapon.getWeight() &&
        getName().equals(weapon.getName()) &&
        getType() == weapon.getType();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getDamage(), getWeight(), getType());
  }
}
