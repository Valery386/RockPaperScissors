/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.game;

/**
 *
 * @author Valery
 */
public class Player {

    private String name;
    private char option;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getOption() {
        return option;
    }

    public void setOption(char option) {
        this.option = option;
    }

    public Player(String name, char option) {
        this.name = name;
        this.option = option;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", option=" + option + '}';
    }

}
