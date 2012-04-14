
/*
 * File: StoneMasonKarel.java
 * ----------------------------------------------------------------------
 * The StoneMasonKarel program instructs Karel to repair a set of arches 
 * on the Quad, which were damaged as a result of the 1989 earthquake, by 
 * fixing each arch column individually, until every column is intact.
 * Karel fixes an arch column by replacing any missing stones, whcih are
 * represented by beepers.  
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {
	public void run() {
		repairArches();
	}

	/**
	 * The method repairArches fixes the damaged arches on the quad by repairing each individual arch column, 
	 * which entails replacing every missing stone, one-by-one, until each column is intact. The precondition
	 * for this method is that Karel is positioned on the corner of First Street and First Avenue, facing east.
	 * The postcondition for this method is that Karel is positioned on First Street at the bottom of the final
	 * column, facing east.  
	 */
	private void repairArches() {
		while (frontIsClear()) {
			repairColumn();
			moveToNextColumn();
		}
		repairColumn();
	}


	/**
	 * The method repairColumn fixes an arch column by replacing every stone missing from it. The precondition
	 * for this method is that Karel is positioned on First Street, at the bottom of a given column, facing east.
	 * The postcondition for this method is that Karel is positioned on First Street at the bottom of the same
	 * column, facing east.  
	 */
	private void repairColumn() {
		ascendAndPatchColumn();
		descendColumn();
	}


	/**
	 * The method ascendAndPatchColumn instructs Karel to ascend a column, repairing it along the way by replacing
	 * every missing stone. The precondition for this method is that Karel is positioned on First Street, at the 
	 * bottom of a given column, facing east. The postcondition for this method is that Karel is positioned at the 
	 * top of the same column, facing north.  
	 */
	private void ascendAndPatchColumn() {
		turnLeft();
		if (noBeepersPresent()) {
			putBeeper();
		}
		while (frontIsClear()) {
			move();
			if (noBeepersPresent()) {
				putBeeper();
			}
		}
	}

	/**
	 * The method descendColumn instructs Karel to descend a column, returning back to the bottom of the column on 
	 * First Street. The precondition for this method is that Karel is positioned at the top of a given column, facing 
	 * north. The postcondition for this method is that Karel is positioned at the bottom of the same column, facing east.  
	 */
	private void descendColumn() {
		turnAround();
		while (frontIsClear()) {
			move();
		}
		turnLeft();
	}

	/**
	 * The method moveToNextColumn instructs Karel to move to the next column for repair, after having just repaired the
	 * previous column. The precondition for this method is that Karel is positioned at the bottom of a given column, facing 
	 * east. The postcondition for this method is that Karel is positioned at the bottom of the next column, facing east.  
	 */
	private void moveToNextColumn() {
		for (int i = 0; i < 4; i ++) {
			move();
		}
	}
}
