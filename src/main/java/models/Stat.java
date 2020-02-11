package models;
import java.io.Serializable;

public class Stat{      //refactored score and is win / lose conditions into a class stat
   public int score = 0;          //creating class attribute
    public boolean is_win = false;
    public boolean is_lose = false;
    boolean noMove = false;
    public int getScore(){
        return this.score;
    }
    public void setScore(int score){
        this.score = score;
    }

    public boolean getWin(){
        return this.is_win;
    }

    public void    setWin(boolean b){
        this.is_win = b;
    }

    public boolean  getLose(){
        return this.is_lose;
    }

    public void     setLose(boolean z){
        this.is_lose = z;
    }

    public boolean getnoMove(){
        return this.noMove;
    }

    public void     setnoMove(boolean x){
        this.noMove = x;
    }
}