package com.example.epidemicsimulator;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Player {
    // Static Vars for player
    private static Player sPlayer;
    private int pHealth,mHealth;
    private int drink,weapon,food,toy,medicine;




    public static Player get(Context context){
        if(sPlayer==null){
            sPlayer=new Player(context);
        }
        return sPlayer;
    }

    private Player(Context context){
        pHealth=100;
        mHealth=100;
        drink=0;
        weapon=0;
        food=0;
        toy=0;
        medicine=0;
    }

    public int getPHealth() {
        return pHealth;
    }

    public void setPHealth(int pHealth) {
        this.pHealth = pHealth;
    }

    public int getMHealth() {
        return mHealth;
    }

    public void setMHealth(int health) {
        mHealth = health;
    }

    public int getDrink() {
        return drink;
    }

    public void setDrink(int drink) {
        this.drink = drink;
    }

    public int getWeapon() {
        return weapon;
    }

    public void setWeapon(int weapon) {
        this.weapon = weapon;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getToy() {
        return toy;
    }

    public void setToy(int toy) {
        this.toy = toy;
    }

    public int getMedicine() {
        return medicine;
    }

    public void setMedicine(int medicine) {
        this.medicine = medicine;
    }
}
