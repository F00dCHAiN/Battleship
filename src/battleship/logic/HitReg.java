
package battleship.logic;

public final class HitReg {
    final int MAX_HITS = 3;////////////DO NOT
    public final int MAX_MISSES = 3;///CHANGE THESE
    public boolean isSunk = false;
    boolean isHit = false;
    public int numOfHits = 0;
    public int numOfMisses = 0;
    private Ships ships;
    private Player player;
    public boolean guiLabel;//used in NumberButtonListener class
    
    public HitReg(Player player, Ships ships){
        setTarget(player, ships);
    }
    
    void setTarget(Player player, Ships ships){
        this.player = player;
        this.ships = ships;
    }
    
    public void checkHits(){
        for(int i : ships.getPos()){
            if(player.getPlayerGuess() == i){
                System.out.println("HIT!");
                guiLabel = true;
                isHit = true;
                numOfHits++;
                ships.deletePos(i);
                break;
            }
        }
        if(isHit != true){
            System.out.println("MISS!");
            guiLabel = false;
            numOfMisses++;
        }
        isHit = false;
        if(numOfHits == MAX_HITS){
            this.isSunk = true;
            Stats stats = new Stats(numOfHits, numOfMisses);
            end();
        }
        if(numOfMisses == MAX_MISSES){
            this.isSunk = false;
            Stats stats = new Stats(numOfHits, numOfMisses);
            end();
        }
    }
    
    void end(){
        if(isSunk == true){
            numOfHits = 0;
            System.out.println("YOU WIN!");//console log
        }
        else{
            numOfHits = 0;
            System.out.println("YOU LOST!");//console log
        }
    }
}






























