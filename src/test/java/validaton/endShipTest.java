package validaton;

import model.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class endShipTest {

    private endShip validator;
    private PlayersBoard board;
    @Before
    public void init(){

        validator= new endShip();
        board = PlayersBoard.fresh();
    }

    @Test

    public void shuldAcceptShipThatEndsOnBoard(){



        Ship ship = new Ship(ShipType.BATTLESHIP, Orientation.HORIZONTAL,new Point(3,4));

        boolean isShipProperlyPlaced = validator.isValid(ship,board);


        assertTrue(isShipProperlyPlaced);
    }

}