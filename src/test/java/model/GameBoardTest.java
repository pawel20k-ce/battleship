package model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import validaton.NearbyShipsValidator;
import validaton.Validator;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class GameBoardTest {
    private GameBoard gameBoard;

    @Mock
    private Validator validator;

    @Before //bedzie robione zawsze przed testem
    public void init() {

        PlayersBoard humanBoard = PlayersBoard.fresh();
        PlayersBoard computerBoard = PlayersBoard.fresh();
        gameBoard = new GameBoard(humanBoard, computerBoard,validator);
    }


    @Test
    public void shouldSetMissValueWhenShotIntoWaterOnComputerboard() {


        Point shootLocation = new Point(3, 5);


        gameBoard.shotComputerBoard(shootLocation);

        BoardField shotField = gameBoard.getComputerBoardElement(shootLocation);
        assertEquals(BoardField.MISS, shotField);


    }


    @Test
    public void whenShotIntoWaterThenChangeFieldToMiss() {

        Point shootLocation = new Point(3, 5);


        gameBoard.shotHumanBoard(shootLocation);

        BoardField shotField = gameBoard.getHumanBoardElement(shootLocation);
        assertEquals(BoardField.MISS, shotField);

    }

    @Test
    public void shouldSetShipHitWhenShotIntoShipOnHumanPlayersBoard(){
        when(validator.isValid(any(),any())).thenReturn(Boolean.TRUE);
        Point shootLocation = new Point(3,5);
        Ship ship = new Ship(ShipType.BATTLESHIP,Orientation.HORIZONTAL,shootLocation);
        gameBoard.addHumanShip(ship);

        gameBoard.shotHumanBoard(shootLocation);

        BoardField shotField = gameBoard.getHumanBoardElement(shootLocation);
        assertEquals(BoardField.SHIP_HIT, shotField);
    }
    @Test
    public void shouldSetShipHitWhenShotIntoShipOnComputerPlayersBoard(){
        when(validator.isValid(any(),any())).thenReturn(Boolean.TRUE);
        Point shootLocation = new Point(3,5);
        Ship ship = new Ship(ShipType.BATTLESHIP,Orientation.HORIZONTAL,shootLocation);
        gameBoard.addComputerShip(ship);

        gameBoard.shotComputerBoard(shootLocation);

        BoardField shotField = gameBoard.getComputerBoardElement(shootLocation);
        assertEquals(BoardField.SHIP_HIT, shotField);
    }
    @Test
    public void shouldreturnpreviusSeaElementStateOnHumanShot(){

        Point shootLocation = new Point(3,5);

        BoardField previousshootField  =  gameBoard.shotHumanBoard(shootLocation);

        assertEquals(BoardField.WATER,previousshootField);

    }

    @Test
    public void shouldreturnpreviusSeaElementStateOnComputerShot(){

        Point shootLocation = new Point(3,5);

        BoardField previousshootField  =  gameBoard.shotComputerBoard(shootLocation);

        assertEquals(BoardField.WATER,previousshootField);

    }
        @Test
    public void whenComputerShipIsAddThenUpdateObserver() {
            when(validator.isValid(any(),any())).thenReturn(Boolean.TRUE);
            GameBoardObserver observer = mock(GameBoardObserver.class);
            Ship ship = new Ship(ShipType.DESTROYER, Orientation.HORIZONTAL, new Point(2, 3));
            gameBoard.register(observer);
            gameBoard.addComputerShip(ship);

            verify(observer).update(eq(gameBoard));

        }


@Test
        public void whenhumanShipIsAddthenUpdateObserver(){

        when(validator.isValid(any(),any())).thenReturn(Boolean.TRUE);
                GameBoardObserver observer = mock(GameBoardObserver.class);
    Ship ship = new Ship(ShipType.DESTROYER, Orientation.HORIZONTAL, new Point(2, 3));
                gameBoard.register(observer);
                gameBoard.addHumanShip(ship);
               // gameBoard.shotComputerBoard(new Point(2,4));

                verify(observer).update(eq(gameBoard));
            }
//@Test uzupelnic test na oddanie strzalu


@Test
    public void whenobserverIsunregisterthenObserverReceivesNoUpdates(){
    GameBoardObserver observer = mock(GameBoardObserver.class);
    Ship ship = new Ship(ShipType.DESTROYER, Orientation.HORIZONTAL, new Point(2, 3));

        gameBoard.register(observer);
        gameBoard.unregister(observer);
        gameBoard.addHumanShip(ship);

        verify(observer,times(0)).update(any());

        verify(observer,never()).update(any());
        verifyZeroInteractions(observer);

}
@Test //5.2
    public void whenValidatorRejectShipThenHumanPlayerBoardIsNotChanged(){

    Ship ship = new Ship(ShipType.DESTROYER, Orientation.HORIZONTAL, new Point(2, 3));

    gameBoard.addHumanShip(ship);

    BoardField potencialShipStart = gameBoard.getHumanBoardElement(new Point(2, 3));
assertFalse(potencialShipStart.equals(BoardField.SHIP));
assertNotEquals(BoardField.SHIP,potencialShipStart);

}
@Test //5.1

    public void whenValidatoraddShipthenddshiptoPlayerBoard(){
    when(validator.isValid(any(),any())).thenReturn(Boolean.TRUE);
    Ship ship = new Ship(ShipType.DESTROYER, Orientation.HORIZONTAL, new Point(2, 3));

    gameBoard.addHumanShip(ship);
    BoardField potencialShipStart = gameBoard.getHumanBoardElement(new Point(2, 3));
    assertTrue(potencialShipStart.equals(BoardField.SHIP));
    assertEquals(BoardField.SHIP,potencialShipStart);

}

@Test
    public void whenHumanAddShipthenTrue(){

    when(validator.isValid(any(),any())).thenReturn(Boolean.TRUE);
    Ship ship = new Ship(ShipType.DESTROYER, Orientation.HORIZONTAL, new Point(2, 3));

    assertTrue(gameBoard.addHumanShip(ship));

}

    @Test
    public void whenHumanAddShipthenFalse(){

      //  when(validator.isValid(any(),any())).thenReturn(Boolean.FALSE);
        Ship ship = new Ship(ShipType.DESTROYER, Orientation.HORIZONTAL, new    Point(2, 3));

        assertFalse(gameBoard.addHumanShip(ship));

    }


        }
