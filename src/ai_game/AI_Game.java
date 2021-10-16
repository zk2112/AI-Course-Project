
package ai_game;

import java.util.Scanner;


public class AI_Game {

  static action action;
    public static void main(String[] args) {
        
        level();
        boolean flag;
        state current=new state(new player(4,0,constant.player.max),new player(4,8,constant.player.min),10,10);
      
      System.out.print(current);
        while(!current.terminal_test()){
            flag=false;
            System.out.println("enter 2,4,6,8,7,9,1,3 to move and 0 to insert a wall");
            Scanner scan = new Scanner(System.in);
            switch (scan.nextInt()){
            case 8 :  flag=current.moveMin(new action(constant.act.U));  break;
            case 2 :  flag=current.moveMin(new action(constant.act.D));  break;  //todo JD,LD,RD
            case 4 : flag=current.moveMin(new action(constant.act.L));  break;   
            case 6 : flag=current.moveMin(new action(constant.act.R));  break; 
            case 7 :flag= current.moveMin(new action(constant.act.UL));  break;
            case 9 : flag=current.moveMin(new action(constant.act.UR));  break;
            case 1 : flag=current.moveMin(new action(constant.act.DL));  break;
            case 3 : flag=current.moveMin(new action(constant.act.DR));  break;
                
            case 0 : action a = new action(constant.act.insert);
                System.out.println( "enter x "); 
                a.x=scan.nextInt();
                System.out.println( "enter y "); 
                a.y=scan.nextInt();
                System.out.println( "enter h or v");
                if(scan.next().equalsIgnoreCase("h")) a.isHorizontal=true;
                else a.isHorizontal=false;
                flag=current.moveMin(a);  break;  
            default    : continue;
            }
          if(!flag) continue;  
          System.out.print(current); 
          if (current.terminal_test()) break;
          action = search (current);
          current=current.result(action, constant.player.max);
          System.out.print(current);
        }
        if(current.player_max.y>8) System.out.print("max wins!");
        if(current.player_min.y<0) System.out.print("min wins!");
    }

    public static void level(){
        System.out.println("level :  1 or 2 or 3 ?");
        Scanner scan=new Scanner(System.in) ;
        switch (scan.nextInt()){
            case 1 : constant.max_depth=1; break;
            case 2 : constant.max_depth=2;break;
            case 3 : constant.max_depth=4;   break;
        }
    }
    public static action search(state state){
        max_value(state,Integer.MIN_VALUE,Integer.MAX_VALUE,0);
        return action;
    }
    public static int max_value(state s,int a , int b, int d ){
        if( s.cutoff(d)) return s.eval();
        int v=Integer.MIN_VALUE;
        int v1;
        for(action act : s.actions(constant.player.max)){
          v1=  min_value(s.result(act,constant.player.max),a,b,d+1);
          if (v1>v){
              v=v1;
              if(d==0)action=act;
          }   
          if(v>=b) {
               if(d==0)action=act;
              return v;
          }
          a=Integer.max(a, v);
        }
        return v;
    }
    public static int min_value(state s,int a , int b, int d ){
        if( s.cutoff(d)) return s.eval();
        int v=Integer.MAX_VALUE;
        int v1;
        for (action act : s.actions(constant.player.min)){
           v=Integer.min(v, max_value(s.result(act, constant.player.min),a,b,d+1));
            if (v<=a){
                return v;
            }
            b=Integer.min(b, v);
        }
        return v;
    }
    
}
