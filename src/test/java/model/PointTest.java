package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test

    public void shouldBeAbleToCreatePointFromTwoIntegers(){

        //given

        Integer x = 3;
        Integer y = 5;

        //when
        Point point = new Point(x, y);

        //then
        assertEquals(x, point.getX());
        assertEquals(y, point.getY());

    }

    @Test(expected = IllegalArgumentException.class)

    public void shouldThrowExceptionWhenXisNull(){

        //given
        Integer x = null;

        Integer y  = 7;

        //when
        new Point(x,y);
        //then



    }


}