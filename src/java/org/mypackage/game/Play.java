/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.game;

import java.util.ArrayList;

/**
 *
 * @author Valery
 */
public class Play {

    private Stack played = new Stack();

    public String championship(ArrayList<String> list) {
        int status = 0; // uninitiated/ this is a flag to know where the file is being read
        String result = "test";
        for (String s : list) {
            s = s.trim();
            if (s.length() == 1) {
                char c = s.charAt(0);
                switch (c) {
                    case '[':
                        status = 1; //new element
                        break;
                    case ',':
                        status = 2;// change element
                        break;
                    case ']':
                        switch (status) {
                            case 1:// It should have included a play
                                // do nothing because it is the first play stack included ...
                                break;
                            case 2: //play
                                Player two = played.pop();
                                Player one = played.pop();
                                if (two == null) {
                                    if (one == null) {
                                        return "Championship badly formed";
                                    } else {
                                        return "" + one;
                                    }
                                } else {
                                    play(one, two);
                                }
                        }
                        break;
                    case 3://make the game
                        break;
                }
            } else {//has more text the line
                for (int i = 1; i < s.length(); i++) {
                    char c = s.charAt(i);
                    switch (c) {
                        case '[':
                            status = 1;
                            break;
                        case ']':

                        case ',':
                            status = 2;
                            break;
                        case '"': //we must seek player
                            s = s.substring(i + 1);
                            int last = s.indexOf("\"");//I am seeking the closing quotation mark of the name
                            if (last == -1) {
                                return "Badly formed file, name";
                            } else {
                                String name = s.substring(0, last - 1);
                                s = s.substring(last + 1);//I cut the string ... no longer has the name
                                last = s.indexOf("\"");// start seeking quotes Object
                                if (last == -1) {
                                    return "Badly formed file, object";
                                } else {
                                    s = s.substring(last + 1); //cut the string, now the string does not have the quotes start object
                                    last = s.indexOf("\"");//Seek the closing quotation mark object
                                    if (last == -1) {
                                        return "Badly formed file, object";
                                    } else {
                                        char object = s.charAt(0);
                                        // I keep the play in the stack of plays
                                        played.push(new Player(name, object));
                                        s = s.substring(last + 1);  // reset values for the for
                                        i = 0;
                                    }
                                }
                            }
                    }

                }

            }
        }
        return result;
    }

    public void play(Player one, Player two) {
        char plaOne = one.getOption();
        char plaTwo = two.getOption();
        switch (plaOne) {
            case 'R': // Player one has ROCK
                switch (plaTwo) {
                    case 'P':   // Player two has PAPER, wins Player two
                        played.push(two);
                        break;
                    case 'S':  // Player two has SCISSORS
                        played.push(one);
                    case 'R': // Player two has ROCK
                        played.push(one);
                        break;
                }
                break;
            case 'P':  // Player one has PAPER
                switch (plaTwo) {
                    case 'P':   // Player two has PAPER, wins Player one
                         played.push(one);
                        break;
                    case 'S':  // Player two has SCISSORS, wins Player two
                        played.push(two);
                        break;
                    case 'R': //  Player two has ROCK, wins Player one
                        played.push(one);
                        break;
                }
                break;
            case 'S':  // Player one has SCISSORS
                switch (plaTwo) {
                    case 'P':   // Player two has PAPER, wins Player one
                         played.push(one);
                        break;
                    case 'S':  // Player two has SCISSORS, wins Player one
                        played.push(one);
                        break;
                    case 'R': //Player two has ROCK, wins Player two
                         played.push(two);
                        break;
                }
                break;
        }
    }

}
