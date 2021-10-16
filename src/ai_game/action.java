/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_game;


public class action {
    
     //public static enum actions { R,L,U,D,UL,UR,DL,DR,JR,JL,JU,JD,Insert};
    constant.act act;
    int x=-1,y=-1;
    boolean isHorizontal =false;
    
    public action(constant.act act){
        this.act=act;
        
    }
    public action(){
        
    }
            
     
    
}
