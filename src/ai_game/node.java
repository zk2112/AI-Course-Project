/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_game;

import java.util.ArrayList;

/**
 *
 * @author God
 */
public class node  {
    
   node  parent ;
  constant.player player;
   state state;
  int cost=0;
   
   public node (node parent,state state,constant.player player,int cost){
    this.player=player;
   this.parent=parent;
   this.state = state;
  this.cost=cost;
   }
   public ArrayList<action> actions(){
       ArrayList<action> actions = new ArrayList<action> ();
       if(player==constant.player.max && state.player_max.y<9){
       if(state.player_max.x<8  && state.v_walls[state.player_max.y][state.player_max.x] == false){ //samt rast divar nist
            actions.add(new action(constant.act.R));}
        if(state.player_max.x>0  && state.v_walls[state.player_max.y][state.player_max.x-1] == false){ //samt rast divar nist
            actions.add(new action(constant.act.L));}
        if( state.player_max.y==8  ){ 
            actions.add(new action(constant.act.U));}
         if(state.player_max.y<8  && state.h_walls[state.player_max.y][state.player_max.x] == false){ //samt rast divar nist
            actions.add(new action(constant.act.U));}
        
         if(state.player_max.y>0  && state.h_walls[state.player_max.y-1][state.player_max.x] == false){ //samt rast divar nist
            actions.add(new action(constant.act.D));} 
       }
       else  if(player==constant.player.min && state.player_min.y>-1){
       if(state.player_min.x<8  && state.v_walls[state.player_min.y][state.player_min.x] == false){ //samt rast divar nist
            actions.add(new action(constant.act.R));}
        if(state.player_min.x>0  && state.v_walls[state.player_min.y][state.player_min.x-1] == false){ //samt rast divar nist
            actions.add(new action(constant.act.L));}
       
         if(state.player_min.y<8  && state.h_walls[state.player_min.y][state.player_min.x] == false){ //samt rast divar nist
            actions.add(new action(constant.act.U));}
         if(state. player_min.y==0  ){ 
            actions.add(new action(constant.act.D));}
         if(state.player_min.y>0  && state.h_walls[state.player_min.y-1][state.player_min.x] == false){ //samt rast divar nist
            actions.add(new action(constant.act.D));} 
       }
         return actions;
   }
   
   public node childNode(action action){
      state childState = state.result(action, player); //todo
      return new node(this,childState,player,cost+1);
      
   }
   @Override
  public boolean equals(Object obj){
       if (obj instanceof state){
           return   this.state.equals(((state)obj)) ;
       }
       if (obj instanceof node){
           return this.cost==((node)obj).cost && this.parent.equals(((node)obj).parent) &&
           this.state.equals(((node)obj).state) && this.player.equals(((node)obj).player) ;
                   
       } 
       return false;
   }

   
    
}
