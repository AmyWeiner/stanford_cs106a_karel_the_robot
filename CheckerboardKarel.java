/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {
	public void run()  {
    makeCheckerBoard();
}

/**
 * The method makeCheckerBoard instructs Karel to draw a checkerboard pattern, using
 * beepers to mark alternating spaces on the board. The precondition for this method
 * is that Karel is on the corner of First Street and First Avenue, facing east, and 
 * the checkerboard is empty. The postcondition for this method is that Karel is at 
 * the top of the checkerboard, after having drawn the checkerboard pattern.
 */
private void makeCheckerBoard() {
    while (frontIsClear()) {
        checkerOddRow();
        checkerEvenRow();
    }
    if(frontIsBlocked() && facingEast()) {
        checkerOneColumn();                             //checks for boards one column wide
    }
}

/**
 * The method checkerOddRow instructs Karel to draw a checkerboard pattern on odd rows 
 * of the board, using beepers to mark alternating spaces. The precondition for this 
 * method is that Karel is on the First Avenue of any given row, facing east, and the 
 * row is empty. The postcondition for this method is that Karel is at the end of the 
 * same row, facing east, after having drawn the checkerboard pattern.
 */
private void checkerOddRow() {
    while (facingEast() && frontIsClear()) {
        putBeeper();
        move();
        if (frontIsBlocked()) {
            moveToNextRow();
        }
        if (frontIsClear() && facingEast()) {
            move();
            if (frontIsBlocked()) {
                putBeeper();
                moveToNextRow();
            }
        } 
    }   
}

/**
 * The method moveToNextRow moves Karel to the next row of the board. The direction Karel 
 * is facing when this method is called will determine whether Karel moves to an even row 
 * or an odd row. If Karel is facing east when this method is called, it moves to an even 
 * row, and if Karel is facing west it moves to an odd row. The precondition for this 
 * method is that Karel is at the end of any given row, having finished checkering the row. 
 * The postcondition for this method is that Karel is at the beginning of the next row, 
 * which is empty.
 */
private void moveToNextRow() {
    if (facingEast()){
        moveToEvenRow();
    }else {
        moveToOddRow();
    }
}

/**
 * The method moveToEvenRow moves Karel to the next even row of the board. The precondition 
 * for this method is that Karel is at the end of any given odd row, facing east, having finished 
 * checkering the odd row. The postcondition for this method is that Karel is at the beginning of 
 * the next even row, which is empty, facing west.
 */
private void moveToEvenRow() {
    turnLeft();
    if (frontIsClear()) {
        move();
        turnLeft();
    }
}

/**
 * The method moveToOddRow moves Karel to the next odd row of the board. The precondition 
 * for this method is that Karel is at the end of any given even row, facing west, having finished 
 * checkering the even row. The postcondition for this method is that Karel is at the beginning of 
 * the next odd row, which is empty, facing east.
 */
private void moveToOddRow() {
    turnRight();
    if(frontIsClear()) {
        move();
        turnRight();
    }
}

/**
 * The method checkerEvenRow instructs Karel to draw a checkerboard pattern on even rows 
 * of the board, using beepers to mark alternating spaces. The precondition for this 
 * method is that Karel is on the last Avenue of any given even row, facing west, and the 
 * row is empty. The postcondition for this method is that Karel is at the end of the 
 * same row, facing west, after having drawn the checkerboard pattern.
 */
private void checkerEvenRow() {
    checkSquareBelow();
    while (frontIsClear()  && facingWest()) {
        putBeeper();
        move();
        if (frontIsBlocked()) {
            moveToNextRow();
        }
        if (frontIsClear() && facingWest()) {
            move();
        }
    }   
}

/**
 * The method checkSquareBelow checks the status of the square directly below the square
 * on which Karel is currently standing in order to determine whether or not the checker 
 * pattern of the row Karel is about to draw should begin with a marked square. If the below
 * square is marked, the row Karel is about to draw begins with an unmarked square, and if
 * the square below is unmarked, the row Karel is about to draw begins with a marked square.
 * The precondition for this method is that Karel is at the beginning of an even row, facing 
 * west. The postcondition for this method is that Karel is on the same even row, facing west,
 * and is either at the beginning of the row, or has moved one square west, after determining
 * that the first square of that row should be left unmarked. 
 */
private void checkSquareBelow() {
    if (frontIsClear()) {
        turnLeft();
        move();
        if (beepersPresent()) {
            turnAround();
            move();
            turnLeft();
            move();
        } else {
            turnAround();
            move();
            turnLeft();
        }
    }
}

/**
 * The method checkerOneColumn instructs Karel to draw a checkerboard pattern on grids of one
 * column in width. The precondition for this method is that Karel is on on the corner of First 
 * Street and First Avenue, facing east, and the grid is empty. The postcondition for this method
 * is that Karel is standing at the end of First Avenue, having drawn the checkerbord pattern.
 */
private void checkerOneColumn () {
    turnLeft();
    while (frontIsClear() && facingNorth()) {
        putBeeper();
        move();
        if (frontIsBlocked()) {
            turnAround();
            move();
            if (beepersPresent()) {
                turnAround();
                move();
                turnLeft();
            } 
        }
        if (frontIsClear() && facingNorth()) {
            move();
            if (frontIsBlocked()) {
                putBeeper();
            }
        } 
    }   
}
}

