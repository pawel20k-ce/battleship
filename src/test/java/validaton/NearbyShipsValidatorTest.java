package validaton;

import model.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NearbyShipsValidatorTest {

    private NearbyShipsValidator validator;

    private PlayersBoard board;

    @Before
    public void init(){
        validator = new NearbyShipsValidator();
        board = PlayersBoard.fresh();
    }

    @Test
    public void shouldAcceptShipTahtDoesNotTouchOtherShips(){
        Ship ship = new Ship(ShipType.BATTLESHIP, Orientation.HORIZONTAL, new Point(3,4));
        boolean isShipProperlyPlaced = validator.isValid(ship,board);

        assertTrue(isShipProperlyPlaced);

    }

    @Test
    public void shouldRejectShipThatOverlapsAnotherShip(){

        Ship existingShip = new Ship(ShipType.BATTLESHIP,Orientation.HORIZONTAL,new Point(3,3));
        board = board.addShip(existingShip);


        Ship shipToBeValidated = new Ship(
                ShipType.BATTLESHIP,Orientation.HORIZONTAL,new Point(4,2));

                boolean isShipProperlyPlaced = validator.isValid(shipToBeValidated,board);
                assertFalse(isShipProperlyPlaced);


    }

}