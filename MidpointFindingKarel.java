
/*
 * File: MidpointFindingKarel.java
 * ----------------------------------------------------------------
 * The MidpointFindingKarel class determines the midpoint of the 
 * length of a given rectangular-shaped grid by instructing Karel 
 * to place a beeper on the center corner of First Street (or on
 * one of the two corners closest to the center) for a given world.
 * The world may be of any size, but it is assumed that it is at 
 * least as tall as it is wide. The programs ends with Karel standing
 * over the beeper on the center corner, facing east.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {

	public void run () {
        depositRowOfBeepers();
        findMidpoint();
    }
 
    /**
     * The method depositRowOfBeepers instructs Karel to place a beeper on every corner of 
     * First Street for a given rectangular-shaped Karel world. The precondition for this
     * method is that Karel is standing on the corner of First Street and First Avenue,
     * facing east, prior to Karel placing any beepers on the street. The postcondition of
     * this method is that Karel is standing at the end of First Street, facing east, after
     * having just placed a beeper on every corner of the street. 
     */
    private void depositRowOfBeepers() {
        while (frontIsClear()) {
            putBeeper();
            move();
        }
        putBeeper();
    }
 
    /**
     * The method findMidpoint determines the center corner of First Street by removing every
     * pair of end beepers, until only one beeper remains in the center of the street. The 
     * precondition for this method is that Karel is standing at the end of First Street,
     * facing east, after having just placed down a row of beepers on the street. The 
     * postcondition of this method is that Karel is standing over the beeper on the center
     * corner of the street, facing east. 
     */
    private void findMidpoint() {
        removeEndBeepers();
        if (frontIsClear()) {
        removeNewEndBeeper();
        }
    }
     
    /**
     * The method removeEndBeepers removes the first pair of end beepers from First Street. The 
     * precondition for this method is that Karel is standing at the end of First Street,
     * facing west, after having just placed down a row of beepers on the street. The 
     * postcondition of this method is that Karel is standing on the corner of First Street and
     * First Avenue, facing east, after having just picked up the two beepers on the corners at
     * each end of the street.  
     */
    private void removeEndBeepers() {
        turnAround();
        if (frontIsClear()) {
        pickBeeper();
        moveToWall();
        turnAround();
        pickBeeper();
        move();
        }
    }
 
    /**
     * The method moveToWall moves Karel to the wall on the opposite end of First Street. The 
     * precondition for this method is that Karel is standing at the end of First Street,
     * facing west, after having just picked up the beeper at the end of the street. The 
     * postcondition of this method is that Karel is standing on the corner of First Street and
     * First Avenue, facing west, after having just moved to the opposite side of the street.  
     */
    private void moveToWall() {
        while (frontIsClear()) {
            move();
        }
    }
 
    /**
     * The method removeNewEndBeeper removes each subsequent pair of end beepers until only one 
     * beeper remains at the center of First Street. The precondition for this method is that 
     * Karel is standing on the western-most corner of a line of beepers,facing east, after having 
     * just picked up the beeper adjacent to the wall on the western edge of the world, and then
     * moving one space. The postcondition of this method is that Karel is standing over a beeper on 
     * the center corner of First Street First Avenue, facing east, after having just removed all of
     * the other beepers.  
     */
    private void removeNewEndBeeper() {
        while (beepersPresent()) {
            move();
            if (noBeepersPresent()) {
                turnAround();
                move();
                pickBeeper();
                move();
            }
        }
        turnAround();
        move();
        putBeeper();
    }
}
 
    