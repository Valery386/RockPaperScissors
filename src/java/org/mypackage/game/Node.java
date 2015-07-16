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
public class Node {

    private Player data;
    private Node down;

    @Override
    public String toString() {
        return "Node{" + "data=" + data + '}';
    }

    public Node(Player data) {
        this.data = data;
    }

    public Player getData() {
        return data;
    }

    public void setData(Player data) {
        this.data = data;
    }

    public Node getDown() {
        return down;
    }

    public void setDown(Node down) {
        this.down = down;
    }

}
