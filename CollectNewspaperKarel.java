
/*
 * File: CollectNewspaperKarel.java
 * ---------------------------------------------------------------
 * This program instructs Karel to walk to the door of its house, 
 * pick up the newspaper (represented by a beeper, of course), and 
 * then return to its initial position in the upper left corner of 
 * the house.
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends Karel {
	
	public void run() {
        moveToNewspaper();
        pickUpNewspaper();
        returnToStart();
    }
 
    /**
     * The method moveToNewspaper moves Karel from its start position inside its house
     * to the newspaper located just outside the doorway of its house. The precondition 
     * for this method is that Karel is inside its house, facing east. The postcondition
     * for this method is that Karel outside its house, standing on the same corner as
     * the newspaper, facing east. 
     */
    private void moveToNewspaper() {
        moveToWall();
        moveToDoorAndExit();
    }
     
    /**
     * The method moveToWall moves Karel from its start position, inside its house, to the 
     * opposite wall of its house. The precondition for this method is that Karel is at 
     * the start position, inside its house, facing east. The postcondition for this method 
     * is that Karel is at the opposite wall of its house, facing east. 
     */
    private void moveToWall() {
        while (frontIsClear()) {
            move();
        }
    }
     
    /**
     * The method moveToDoorAndExit moves Karel from the wall opposite its start position, inside its 
     * house, and through the doorway of its house, to the position just outside its house. The 
     * precondition for this method is that Karel is at the opposite wall of its house, facing east. 
     * The postcondition for this method is that Karel is at the position just outside the doorway of 
     * its house, facing east. 
     */
    private void moveToDoorAndExit() {
        turnRight();
        move();
        turnLeft();
        move();
    }
     
    /**
     * The method turnRight turns Karel 90 degrees to the right. The precondition for this method is that 
     * Karel is facing a given direction (in this case east). The postcondition for this method is that Karel 
     * is facing 90 degrees to the right of that direction (in this case south).
     */
    private void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }
     
    /**
     * The method pickUpNewspaper instructs Karel to pick up its newspaper. The precondition for this method
     * is that Karel is standing on the corner on which its newspaper is located, with the newspaper on the 
     * ground. The postcondition for this method is that Karel is standing on the same corner, after having 
     * picked up its paper.
     */
    private void pickUpNewspaper() {
        pickBeeper();
    }
     
    /**
     * The method returnToStart returns Karel to its initial position, inside its house. The precondition 
     * for this method is that Karel is standing on the corner just outside its house, after having picked up 
     * the newspaper, facing east. The postcondition for this method is that Karel is at its initial position
     * inside its house, facing east.
     */
    private void returnToStart() {
        turnAround();
        moveToWall();
        moveToStart();
    }
     
    /**
     * The method turnAround turns Karel 180 degrees to the left. The precondition for this method is that 
     * Karel is facing a given direction (in this case east). The postcondition for this method is that Karel 
     * is facing 180 degrees to the left of that direction (in this case west).
     */
    private void turnAround() {
        turnLeft();
        turnLeft();
    }
     
    /**
     * The method moveToStart moves Karel to its initial position. The precondition for this method is that Karel 
     * is inside its house, position in front of the wall opposite the door, facing west. The postcondition for 
     * this method is that Karel is at its initial position, facing east.
     */
    private void moveToStart() {
        turnRight();
        moveToWall();
        turnRight();
    }
}