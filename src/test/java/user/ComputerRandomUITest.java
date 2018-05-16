package user;

import model.Point;
import model.Ship;
import model.ShipType;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class ComputerRandomUITest {

    private ComputerRandomUI ui;

    @Before
    public void init(){
        ui = new ComputerRandomUI();
    }

    @Test

    public void shuldGenerateShip(){
        Ship ship = ui.askUserForShip(ShipType.DESTROYER);
        assertNotNull(ship);
        assertEquals(ShipType.DESTROYER,ship);


    }

    @Test
    public void shouldNotReturnSamePointTwice(){

        // 100 razy zapytac o nowynstrzal
        //kazdy strzal przekonwertowac do stringnw postacjix,y, np: 3;5
        // kazdy string zapisac do setu
        //po 100 strzalach sprawdzic czy wielkosc setu to 100
Set<String> generatedPoints = new HashSet<>();
        for (int i = 0; i < 100; i++) {

            Point point = ui.askUserForShot();
            String pointAsString= point.getX()+";"+point.getY();
            generatedPoints.add(pointAsString);

        }
        assertEquals(100,generatedPoints.size());
    }

}