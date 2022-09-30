package generics;

import generics.weapon.Bow;
import generics.weapon.Sword;
import generics.weapon.Weapon;

public class WeaponRunner {
    public static void main(String[] args) {
        Archer<Bow> bowArcher = new Archer<Bow>("Legolas", 15);
        bowArcher.setWeapon(new Bow());

        Warrior<Sword> warrior = new Warrior<>("Boromir", 10);
        warrior.setWeapon(new Sword());

        printWeaponDamage(bowArcher);
    }

    public static void printWeaponDamage(Hero<? extends Weapon> hero) {
        System.out.println(hero.getWeapon().getDamage());
    }
}
