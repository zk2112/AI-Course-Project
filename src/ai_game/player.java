/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_game;

/**
 *
 * @author God
 */
public class player {
    int x,y;
    constant.player type;
    
    public player(int x,int y,constant.player type){
        this.x=x;
        this.y=y;
        this.type=type;
    }
    @Override
    public String toString(){
        return "x= "+ x+", y="+y+" ,type ="+type+"\n";
    }
    @Override
    public boolean equals(Object obj){
        return this.x==((player)obj).x
                && this.y==((player)obj).y
                && this.type==((player)obj).type;
    }
   
}
