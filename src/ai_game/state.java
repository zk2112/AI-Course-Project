/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_game;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class state {
    player player_max,player_min;
    int n_max,n_min;
   // int depth=0;
    boolean[][] v_walls = new boolean[9][8];
    boolean[][] h_walls = new boolean[8][9];
    
    public state(player max,player min,boolean[][] v_walls,boolean[][] h_walls,int n_max,int n_min){
       this.player_max=max;
       this.player_min=min;
        this.h_walls=h_walls;
        this.v_walls=v_walls;
       this.n_max=n_max;
       this.n_min=n_min;
    }
    public state(player max,player min,int n_max,int n_min){
        this.player_max=max;
        this.player_min=min;
        this.n_max=n_max;
       this.n_min=n_min;
     //   this.depth=depth;
        for(int i=0;i<9;i++){
            for(int j=0;j<8;j++){
              v_walls[i][j]=false;  
            }
        }
        for(int i=0;i<8;i++){
            for(int j=0;j<9;j++){
              h_walls[i][j]=false;  
            }
        }
        //h_walls[0][3]=h_walls[0][4] = true;
    }
    
    public ArrayList<action> actions (constant.player p){
        //todo joda kardan min va max
        ArrayList<action> actions = new ArrayList<action> ();
      //  player player,player1;
 
        if(p==constant.player.max){
            
        //   player=player_max;
        //   player1 = player_min;
        
           if(player_max.y == 8){
               actions.add(new action(constant.act.U));
               return actions;
           }
            if(player_max.y<8  && h_walls[player_max.y][player_max.x] == false){ //samt jolo divar nist
                 if( !(player_min.x==player_max.x && player_min.y==player_max.y+1))
                      actions.add(new action(constant.act.U));
                 if(player_max.y<7  &&(player_min.x==player_max.x && player_min.y==player_max.y+1)){  // min jolo max ast
                      if(h_walls[player_max.y+1][player_max.x] == false )
                            actions.add(new action(constant.act.JU));
                      else {
                           if(v_walls[player_max.y+1][player_max.x] == false )
                               actions.add(new action(constant.act.UR));
                            if(v_walls[player_max.y+1][player_max.x-1] == false )
                               actions.add(new action(constant.act.UL));
                      }
                 }
            }
            
            
            
             //aghab
            if(player_max.y>0  && h_walls[player_max.y-1][player_max.x] == false){ //samt aghab divar nist
                 if( !(player_min.x==player_max.x && player_min.y==player_max.y-1))
                      actions.add(new action(constant.act.D));
                 if(player_max.y>1  &&(player_min.x==player_max.x && player_min.y==player_max.y-1)){  // min posht max ast
                      if(h_walls[player_max.y-2][player_max.x] == false )
                            actions.add(new action(constant.act.JD));
                      else {
                           if(v_walls[player_max.y-1][player_max.x] == false )
                               actions.add(new action(constant.act.DR));
                            if(v_walls[player_max.y-1][player_max.x-1] == false )
                               actions.add(new action(constant.act.DL));
                      }
                 }
            }
         //rast
            if(player_max.x<8  && v_walls[player_max.y][player_max.x] == false){ //samt rast divar nist
                 if( !(player_min.x==player_max.x+1 && player_min.y==player_max.y))
                      actions.add(new action(constant.act.R));
                 if(player_max.x<7  &&(player_min.x==player_max.x+1 && player_min.y==player_max.y)){  // min rast max ast
                      if(v_walls[player_max.y][player_max.x+1] == false )
                            actions.add(new action(constant.act.JR));
                      else {
                           if(h_walls[player_max.y][player_max.x+1] == false )
                               actions.add(new action(constant.act.UR));
                            if(h_walls[player_max.y-1][player_max.x+1] == false )
                               actions.add(new action(constant.act.DR));
                      }
                 }
            }
            
             //chap
            if(player_max.x>0 &&v_walls[player_max.y][player_max.x-1] == false){ //samt chap divar nist
                 if( !(player_min.x==player_max.x-1 && player_min.y==player_max.y))
                      actions.add(new action(constant.act.L));
                 if(player_max.x>2  &&(player_min.x==player_max.x-1 && player_min.y==player_max.y)){  // min chap max ast
                      if(v_walls[player_max.y][player_max.x-2] == false )
                            actions.add(new action(constant.act.JL));
                      else {
                           if(h_walls[player_max.y][player_max.x-1] == false )
                               actions.add(new action(constant.act.UL));
                            if(h_walls[player_max.y-1][player_max.x-1] == false )
                               actions.add(new action(constant.act.DL));
                      }
                 }
            }
              insert(actions,player_max);
            
           
       }
       else{
            
            if(player_min.y == 0){
               actions.add(new action(constant.act.D));
               return actions;
           }
              if(player_min.y<8  && h_walls[player_min.y][player_min.x] == false){ //samt bala divar nist
                 if( !(player_min.x==player_max.x && player_min.y+1==player_max.y))
                      actions.add(new action(constant.act.U));
                 if(player_min.y<7  &&(player_min.x==player_max.x && player_min.y+1==player_max.y)){  // max balaye min ast
                      if(h_walls[player_min.y+1][player_min.x] == false )
                            actions.add(new action(constant.act.JU));
                      else {
                           if(v_walls[player_min.y+1][player_min.x] == false )
                               actions.add(new action(constant.act.UR));
                            if(v_walls[player_min.y+1][player_min.x-1] == false )
                               actions.add(new action(constant.act.UL));
                      }
                 }
            }
            
            
            
             //aghab
            if(player_min.y>0  && h_walls[player_min.y-1][player_min.x] == false){ //max payin min ast
                 if( !(player_min.x==player_max.x && player_min.y-1==player_max.y))
                      actions.add(new action(constant.act.D));
                 if(player_min.y>1  &&(player_min.x==player_max.x && player_min.y-1==player_max.y)){  // min posht max ast
                      if(h_walls[player_min.y-2][player_min.x] == false )
                            actions.add(new action(constant.act.JD));
                      else {
                           if(v_walls[player_min.y-1][player_min.x] == false )
                               actions.add(new action(constant.act.DR));
                            if(v_walls[player_min.y-1][player_min.x-1] == false )
                               actions.add(new action(constant.act.DL));
                      }
                 }
            }
         //rast
            if(player_min.x<8  && v_walls[player_min.y][player_min.x] == false){ //samt rast divar nist
                 if( !(player_min.x+1==player_max.x && player_min.y==player_max.y))
                      actions.add(new action(constant.act.R));
                 if(player_min.x<7  &&(player_min.x+1==player_max.x && player_min.y==player_max.y)){  // min rast max ast
                      if(v_walls[player_min.y][player_min.x+1] == false )
                            actions.add(new action(constant.act.JR));
                      else {
                           if(h_walls[player_min.y][player_min.x+1] == false )
                               actions.add(new action(constant.act.UR));
                            if(h_walls[player_min.y-1][player_min.x+1] == false )
                               actions.add(new action(constant.act.DR));
                      }
                 }
            }
            
             //chap
            if(player_min.x>0 &&v_walls[player_min.y][player_min.x-1] == false){ //samt chap divar nist
                 if( !(player_min.x-1==player_max.x && player_min.y==player_max.y))
                      actions.add(new action(constant.act.L));
                 if(player_min.x>2  &&(player_min.x-1==player_max.x && player_min.y==player_max.y)){  // min chap max ast
                      if(v_walls[player_min.y][player_min.x-2] == false )
                            actions.add(new action(constant.act.JL));
                      else {
                           if(h_walls[player_min.y][player_min.x-1] == false )
                               actions.add(new action(constant.act.UL));
                            if(h_walls[player_min.y-1][player_min.x-1] == false )
                               actions.add(new action(constant.act.DL));
                      }
                 }
            }
            insert(actions,player_min);
            
       }
       
         
           
        return actions;
    }
    
    private void insert(ArrayList<action> actions,player player){
        action temp;
   //    if((player.type==constant.player.max &&  n_max>0 )||(player.type==constant.player.min &&  n_min>0 )){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
               if(!h_walls[i][j] && !h_walls[i][j+1]){
                   temp = new action (constant.act.insert);
                   temp.isHorizontal=true;
                   temp.x=j; temp.y=i;
                   if (isValid(temp,player)) actions.add(temp);
               } 
            }
        }
        
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
              if(!v_walls[i][j] && !v_walls[i+1][j]){
                   temp = new action (constant.act.insert);
                   temp.isHorizontal=false;
                   temp.x=j; temp.y=i;
                   if (isValid(temp,player)) actions.add(temp);
               }   
            }
        }
      // }
    }
    
    private boolean isValid(action act,player p){
       // return true;
       
        if( DFS(this.result(act,p.type),player_max.type) && DFS(this.result(act,p.type),player_min.type))
            return true;
        else return false;
        
    }
    
    
    public boolean DFS (state s ,constant.player p){
        AbstractCollection fringe;
        List closed;
        node node = new node (null,s,p,0);
        node child;
        if (s.terminal_test(p)){  //radif akhar
            return true;
        }
        fringe = new Stack<node> ();  //fifo 
        closed = new ArrayList<state>();  //list
        
        fringe.add(node); 
        
        while(true){
           if (fringe.isEmpty()) return false;
           node = (node)((Stack)fringe).pop();
           closed.add(node.state);
            
           for (action action : node.actions()){
              child= node.childNode(action);
              if (! closed.contains(child.state) && !fringe.contains(child.state)){
                  if (child.state.terminal_test(p)) return true;
                  ((Stack)fringe).push(child);
                  
              }
           }
           }
           
        }

    
    
    
     public int BFS (state s,constant.player p){

         node node = new node (null,s,p,0);
        node child;
        AbstractCollection fringe;
        List closed;
        if (s.terminal_test(p)){
            return 0;
        }
        fringe = new LinkedList<node> ();  //fifo 
        closed = new ArrayList<state>();  //list
        
        fringe.add(node); 
       
        while(true){
           if (fringe.isEmpty()) return -1;
           node = (node)((LinkedList)fringe).poll();
           closed.add(node.state);
           for (action action : node.actions()){
              child= node.childNode(action);
              if (! closed.contains(child.state) && !fringe.contains(child.state)){
                  if (child.state.terminal_test(p)) return child.cost;
                  fringe.add(child);
                  }
           }
           
        }
    }
    
    public state result (action a,constant.player p){
        state temp = (state)this.clone();
       // temp.depth++;
        if(p==constant.player.max){
            
        switch (a.act){
            case R : temp.player_max.x++; ; break;
            case L : temp.player_max.x--; ; break;
            case U : temp.player_max.y++; ; break;
            case D : temp.player_max.y--; ; break;
            case UR : temp.player_max.x++;temp.player_max.y++; ; break;
            case UL : temp.player_max.x--;temp.player_max.y++; ; break;
            case DR : temp.player_max.x++;temp.player_max.y--; ; break;
            case DL : temp.player_max.x--;temp.player_max.y--; ; break;
            case JR : temp.player_max.x=temp.player_max.x+2; ; break;
            case JL : temp.player_max.x=temp.player_max.x-2; ; break;
            case JU : temp.player_max.y=temp.player_max.y+2; ; break;
            case JD : temp.player_max.y=temp.player_max.y-2; break;
           
        }
        if(a.act==constant.act. insert ){
             if(a.isHorizontal){
                temp.h_walls[a.y][a.x]=temp.h_walls[a.y][a.x+1]=true;
                n_max--;
            }
            else {
                 temp.v_walls[a.y][a.x]=temp.v_walls[a.y+1][a.x]=true;
                 n_max--;
            }
        }
        }
        else {
            switch (a.act){
            case R : temp.player_min.x++;  break;
            case L : temp.player_min.x--;  break;
            case U : temp.player_min.y++;  break;
            case D : temp.player_min.y--; break;
            case UR : temp.player_min.x++;temp.player_min.y++; break;
            case UL : temp.player_min.x--;temp.player_min.y++; break;
            case DR : temp.player_min.x++;temp.player_min.y--;  break;
            case DL : temp.player_min.x--;temp.player_min.y--;  break;
            case JR : temp.player_min.x=temp.player_min.x+2;  break;
            case JL : temp.player_min.x=temp.player_min.x-2;  break;
            case JU : temp.player_min.y=temp.player_min.y+2;  break;
            case JD : temp.player_min.y=temp.player_min.y-2; break;
        }
            if(a.act==constant.act. insert ){
             if(a.isHorizontal){
                temp.h_walls[a.y][a.x]=temp.h_walls[a.y][a.x+1]=true;
                n_min--;
            }
            else {
                 temp.v_walls[a.y][a.x]=temp.v_walls[a.y+1][a.x]=true;
                 n_min--;
            }
         }
        }
        
        return temp;
    }
   public int eval(){
      
           int test=    distance(player_min) - distance(player_max);
           return test;
  /*     if (player_max.y>8) return Integer.MAX_VALUE-this.depth; // max bord
       if (player_min.y<0) return 0; // min bord
       return Integer.MAX_VALUE-this.depth-(9-player_max.y);// + (player_min.y - (-1)); */
   }
   public int distance(player p){
       return BFS(this,p.type);
      /* if(p.type == constant.player.max){
          return 9-p.y;
       }
       else return p.y+1;*/
   }
   public boolean cutoff(int d){
       return terminal_test() || d>= constant.max_depth;
   }
   
   public boolean moveMin(action action){
       boolean flag=false;
       //JR
       if(action.act == constant.act.R && player_min.x< 7&& !v_walls[player_min.y][player_min.x]
               && player_max.x==player_min.x+1 && player_max.y==player_min.y && !v_walls[player_min.y][player_min.x+1]){ player_min.x+=2; flag=true;}
       //r
       if(action.act == constant.act.R && player_min.x<8 && !v_walls[player_min.y][player_min.x]){ player_min.x++; flag=true;}
      //JL
       else if(action.act == constant.act.L && player_min.x>1 && !v_walls[player_min.y][player_min.x-1]
               && player_max.x==player_min.x-1 && player_max.y==player_min.y && !v_walls[player_min.y][player_min.x-2]) {player_min.x-=2;flag=true;}
      
       //L
       else if(action.act == constant.act.L && player_min.x>0 && !v_walls[player_min.y][player_min.x-1]) {player_min.x--;flag=true;}
       //jd
       else if(action.act == constant.act.D && player_min.y>0 && !h_walls[player_min.y-1][player_min.x] 
               && player_max.x==player_min.x && player_max.y==player_min.y-1) {player_min.y -=2;flag=true;}  //jd 
       //d&& player_max.x==player_min.x && player_max.y==player_min.y-1) {play
       else if(action.act == constant.act.D && player_min.y>0 && !h_walls[player_min.y-1][player_min.x]) {player_min.y --;flag=true;}
       //d
       else if(action.act == constant.act.D && player_min.y==0){ player_min.y --;flag=true;}
       //JU
       else if(action.act == constant.act.U && player_min.y<7 && !h_walls[player_min.y][player_min.x]
              && player_max.x==player_min.x && player_max.y==player_min.y+1 && !h_walls[player_min.y+1][player_min.x] ){ player_min.y ++;flag=true;}
       //u
       else if(action.act == constant.act.U && player_min.y<8 && !h_walls[player_min.y][player_min.x]){ player_min.y ++;flag=true;}
       //ul
       else if(action.act == constant.act.UL && player_min.x>1 && player_min.y<7 &&
               ((!h_walls[player_min.y][player_min.x]&&player_max.x==player_min.x && player_max.y==player_min.y+1
               && h_walls[player_min.y+1][player_min.x] && ! v_walls[player_min.y+1][player_min.x-1]) ||
               ((!v_walls[player_min.y][player_min.x-1]&&player_max.x==player_min.x-1 && player_max.y==player_min.y)
               && v_walls[player_min.y][player_min.x-2] && ! h_walls[player_min.y][player_min.x-1]))){
             player_min.x--;
             player_min.y++;
       }
        //uR
       else if(action.act == constant.act.UR && player_min.x<7 && player_min.y<7 &&
               ((!h_walls[player_min.y][player_min.x]&&player_max.x==player_min.x && player_max.y==player_min.y+1
               && h_walls[player_min.y+1][player_min.x] && ! v_walls[player_min.y+1][player_min.x]) ||
               ((!v_walls[player_min.y][player_min.x]&&player_max.x==player_min.x+1 && player_max.y==player_min.y)
               && v_walls[player_min.y][player_min.x+1] && ! h_walls[player_min.y][player_min.x+1]))){
             player_min.x++;
             player_min.y++;
             flag=true;
       }    
      //DR
       else if(action.act == constant.act.DR && player_min.x<7 && player_min.y>1 &&
               ((!h_walls[player_min.y-1][player_min.x]&&player_max.x==player_min.x && player_max.y==player_min.y-1
               && h_walls[player_min.y-2][player_min.x] && ! v_walls[player_min.y-1][player_min.x]) ||
               ((!v_walls[player_min.y][player_min.x]&&player_max.x==player_min.x+1 && player_max.y==player_min.y)
               && v_walls[player_min.y][player_min.x+1] && ! h_walls[player_min.y-1][player_min.x+1]))){
             player_min.x++;
             player_min.y--;
             flag=true;
       }    
        //DL
       else if(action.act == constant.act.UL && player_min.x>1 && player_min.y>1 &&
               ((!h_walls[player_min.y-1][player_min.x]&&player_max.x==player_min.x && player_max.y==player_min.y-1
               && h_walls[player_min.y-2][player_min.x] && ! v_walls[player_min.y-1][player_min.x-1]) ||
               ((!v_walls[player_min.y][player_min.x-1]&&player_max.x==player_min.x-1 && player_max.y==player_min.y)
               && v_walls[player_min.y][player_min.x-2] && ! h_walls[player_min.y-1][player_min.x-1]))){
             player_min.x--;
             player_min.y--;
             flag=true;
       }
       else if(action.act==constant.act.insert && n_min>0&& isValid(action,player_min)){
           if(action.isHorizontal){
              if(!h_walls[action.y][action.x] && !h_walls[action.y][action.x+1])  {
                  h_walls[action.y][action.x] =  true;
                  h_walls[action.y][action.x+1]=true;
                  n_min--;
                  flag=true;
                  }
              
             }
             else{
                 if(!v_walls[action.y][action.x] && !v_walls[action.y+1][action.x])  {
                     v_walls[action.y][action.x] =  true;
                     v_walls[action.y+1][action.x]=true;
                     n_min--;
                     flag=true;
                  } 
                }
       }
       return flag;
   }
   
    @Override
    public Object clone(){
        boolean[][] v_temp = new boolean[9][8];
         boolean[][] h_temp = new boolean[8][9]; 
         
         for(int i=0;i<9;i++){
             for(int j=0;j<8;j++)
                 v_temp[i][j]=v_walls[i][j];
         }
         
         for(int i=0;i<8;i++){
             for(int j=0;j<9;j++)
                 h_temp[i][j]=h_walls[i][j];
         }
         
        player player1= new player(player_max.x,player_max.y,player_max.type);
        player player2= new player(player_min.x,player_min.y,player_min.type);
         return new state(player1,player2,v_temp,h_temp,n_max,n_min);
    }
    
    @Override
    public String toString(){
        String s="";        
        for(int i=8;i>=0;i--){
            for(int j=0;j<9;j++){
                if(player_max.x==j&&player_max.y==i) s+="*";
                else if (player_min.x == j && player_min.y ==i) s+="@";
                else s+=" ";
                if (j<8 && v_walls[i][j] )   s+="#";
                else if(j<8) s+="|";
            }
            s+="\n";
            if(i>0){
                for(int j=0 ; j<9;j++){
                    if (h_walls[i-1][j]) s+="==";
                    else  s+="--";
                }
            }
            s+="\n";
        }
        return s;
    }
   
    public boolean terminal_test(){
        return player_max.y>8 || player_min.y < 0;
    }
    public boolean terminal_test(constant.player p){
        
        return (p==constant.player.max && player_max.y>8 )||(p==constant.player.min && player_min.y < 0);
    }
    @Override
    public boolean equals(Object obj){
        
        boolean temp=true;
         if (obj instanceof state){
             state s =((state)obj);
        for(int i=0;i<9;i++){
            for(int j=0;j<8;j++){
              if(!v_walls[i][j]==s.v_walls[i][j]){
                  temp=false;
                  break;
              }  
            }
        }
        for(int i=0;i<8;i++){
            for(int j=0;j<9;j++){
             if(!h_walls[i][j]==s.h_walls[i][j]){
                  temp=false;
                  break;
              }  
            }
        }
     
           return temp 
                   && this.player_max.equals(s.player_max)
                   && this.player_min .equals(s.player_min);
       }  
      else if(obj instanceof node){
          return this.equals(((node)obj).state);
      }
      else return false;
    }
    
}
