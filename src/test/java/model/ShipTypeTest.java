package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShipTypeTest {


    @Test
    public void shoudReturnSize4ForBattleship(){

        //given
        ShipType ship = ShipType.BATTLESHIP;
        //when

        Long shipSize = ship.size();
        //then
        assertEquals((Long) 4L, shipSize);
    }

    @Test
    public void shoudReturnSize3ForCruiser(){

        //given
        ShipType ship = ShipType.CRUISER;
        //when

        Long shipSize = ship.size();
        //then
        assertEquals((Long) 3L, shipSize);
    }

    @Test
    public void shoudReturnSize2ForDestroyer(){

        //given
        ShipType ship = ShipType.DESTROYER;
        //when

        Long shipSize = ship.size();
        //then
        assertEquals((Long) 2L, shipSize);
    }

    @Test
    public void shoudReturnSize1ForSubmarine(){

        //given
        ShipType ship = ShipType.SUBMARINE;
        //when

        Long shipSize = ship.size();
        //then
        assertEquals((Long) 1L, shipSize);
    }



}