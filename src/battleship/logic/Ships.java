
package battleship.logic;

public final class Ships {
    //dont change these
    final int MIN = 1;
    final int MAX = 9;
    final int MAX_SHIPS = 3;
    int shipPos;
    int uniqueValueCheck;
    int[] allPos = new int[MAX_SHIPS];
    
    public Ships(){
        setPos();
    }
    
    //returns random int (may contain duplicate)
    int getRandom(){
        return shipPos = (int) (Math.random() * ((MAX - MIN)+1) + MIN );
    }
    
    void setPos(){
        allPos[0] = getRandom();
        
        //eliminates duplicate
        uniqueValueCheck = getRandom();
        while(uniqueValueCheck == allPos[0]){
            uniqueValueCheck = getRandom();
        }
        allPos[1] = uniqueValueCheck;
        
        uniqueValueCheck = getRandom();
        while(uniqueValueCheck == allPos[0] || uniqueValueCheck == allPos[1]){
            uniqueValueCheck = getRandom();
        }
        allPos[2] = uniqueValueCheck;
    }
    
    public int[] getPos(){
        return allPos;
    }
    
    void deletePos(int pos){
        for(int i = 0; i<MAX_SHIPS; i++){
            if(allPos[i] == pos){
                allPos[i] = -1;
            }
        }
    }  
}












