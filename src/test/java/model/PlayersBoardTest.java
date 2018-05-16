package model;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PlayersBoardTest {

    @Test

    public void shuldcontainNoShipsAfterCreation() {
        //given
        PlayersBoard board = PlayersBoard.fresh();

        //when

        List<Ship> shipsOnBoard = board.getShips();


        //then
        assertNotNull(shipsOnBoard);
        assertEquals(0, shipsOnBoard.size());
    }

    @Test
    public void shouldContainOnlyWaterAfterCreation() {

        PlayersBoard board = PlayersBoard.fresh();

        for (int x = 0; x < 0; x++) {
            for (int y = 0; y < 10; y++) {
                Point point = new Point(x, y);
                BoardField field = board.getSeaElement(point);

                assertEquals(BoardField.WATER, field);
            }
        }

    }

    @Test
    public void shouldBeAbleToChangeSeaElementValue() {
        // given
        PlayersBoard board = PlayersBoard.fresh();
        Point point = new Point(3, 7);
        BoardField miss = BoardField.MISS;
        // when
        PlayersBoard updatedBoard = board.upDateSea(point, miss);
        // then
        assertEquals(miss, updatedBoard.getSeaElement(point));
    }

    @Test
    public void shouldBeAbleToAddNewShip() {
        // given
        PlayersBoard board = PlayersBoard.fresh();
        Ship ship = new Ship(ShipType.DESTROYER, Orientation.HORIZONTAL, new Point(3, 4));
        // when
        PlayersBoard updatedBoard = board.addShip(ship);
        // then
        assertEquals(1, updatedBoard.getShips().size());
    }


    @Test

    public void shouldReturnNewInstanceAfterSeaChange() {
        //given
        PlayersBoard board = PlayersBoard.fresh();
        Point point = new Point(1, 2);
        BoardField newSeaValue = BoardField.SHIP;
        //when

        PlayersBoard updatedBoard = board.upDateSea(point, newSeaValue);
        //then
        assertTrue(board != updatedBoard);

    }

    @Test
    public void shouldReturnNewOBjectWhenWeAddNewShip() {
        //given
        Ship ship = new Ship(ShipType.CRUISER, Orientation.HORIZONTAL, new Point(5, 1));
        PlayersBoard board = PlayersBoard.fresh();
        //when
        PlayersBoard updateBoard = board.addShip(ship);

        //then
        assertTrue(updateBoard != board);
    }

    @Test
    public void shouldNotModifyExistingInstanceAfterSeaUpdate() {
        PlayersBoard board = PlayersBoard.fresh();
        Point pointToBeUpdated = new Point(7, 8);
        BoardField seaElementToBeSet = BoardField.SHIP;

        board.upDateSea(pointToBeUpdated, seaElementToBeSet);

        assertEquals(BoardField.WATER, board.getSeaElement(pointToBeUpdated));
    }

    @Test
    public void shouldNotModifyExistingInstance() {
        PlayersBoard board = PlayersBoard.fresh();
        Ship shipToBeAdded = new Ship(ShipType.CRUISER, Orientation.HORIZONTAL, new Point(3, 3));

        board.addShip(shipToBeAdded);

        assertEquals(0, board.getShips().size());
    }

    @Test
    public void shouldMarkShipOnSea() {
        //poterzeba planszy
        PlayersBoard board = PlayersBoard.fresh();
        //potrzba statku - niech to bedzie niszczyciel,poziomo
        Ship shipToBeAdded = new Ship(ShipType.DESTROYER, Orientation.HORIZONTAL, new Point(3, 6));
        //z dziobem w punkcie x=3,y=6
        // dodaj ten statek do planszy , i sprawdz czy zwrocona kopia zawiera:
        //w punkcie x = 3 oraz y=6 jestnwpisany BoardField.SHIP
        //w punkcie x =4 oraz y =6 jest wpisany BoardField.SHIP
        PlayersBoard updatedBoard = board.addShip(shipToBeAdded);

        assertEquals(updatedBoard.getSeaElement(new Point(3, 6)), BoardField.SHIP);
        assertEquals(updatedBoard.getSeaElement(new Point(4, 6)), BoardField.SHIP);

    }

    @Test
    public void shouldMarkVerticalShipOnSea() {
        //statek typu Cruiser , pionowez dziobem w punkcie x=2 y=4
    }

    @Test
    public void shuldNotBePossibleToChangeElementBeyondSea() {
        PlayersBoard board = PlayersBoard.fresh();
        Point pointToBeUpdated = new Point(11,3);
        BoardField seaElementToBeSet = BoardField.MISS;
        PlayersBoard playersBoard = board.upDateSea(pointToBeUpdated, seaElementToBeSet);
        assertEquals(playersBoard.getSeaElement(pointToBeUpdated),BoardField.NONE);
    }


}