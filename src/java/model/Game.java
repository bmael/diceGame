/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;

/**
 *
 * @author mael
 */
public class Game {
    private Integer score;
    private int turn;
    private String name;
    private Highscore hscore;
    private int d1;
    private int d2;
    private boolean finished = false;

    public Game(String name) {
        this.turn = 0;
        this.score = 0;
        this.name = name;
        this.hscore = new Highscore();
    }
    
    // GETTERS & SETTERS
    public void setScore(int score) {
        this.score = score;
    }
    public void setTurn(int turn) {
        this.turn = turn;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setHscore(Highscore hscore) {
        this.hscore = hscore;
    }
    public int getScore() {
        return score;
    }
    public int getTurn() {
        return turn;
    }
    public String getName() {
        return name;
    }
    public Highscore getHscore() {
        return hscore;
    }
    
    public int getD1() {
        return d1;
    }
    
    public int getD2() {
        return d2;
    }
    
    // METHODS
    public void play(){
        if(this.turn <10){
            this.roll();
            this.computeScore();
            this.turn ++;
        }else {
            this.hscore.add(this.name, this.score);
            this.finished = true;
        }
    }

    public boolean isFinished() {
        return finished;
    }
    
    private void roll(){
        Random r = new Random();
        this.d1 = 1 + r.nextInt(6);
        this.d2 = 1 + r.nextInt(6);

    }


    
    private void computeScore() {
        if(this.d1 + this.d2 == 7){
            this.score += 10;
        }
    }
}
