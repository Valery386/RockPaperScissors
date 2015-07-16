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
public class Stack {
    private Node top;
    
    public void push(Player p){
        if(top!=null) {
            top=new Node(p);
        }else {
            Node aux= new Node(p);
            aux.setDown(top);
            top = aux;
        }
    }
    
    public Player pop (){
        Player p = top.getData();
        if (top!=null){
            top=top.getDown();
        }
        return p;
    }
    
}
