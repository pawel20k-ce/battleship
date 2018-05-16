package validaton;

import model.PlayersBoard;
import model.Ship;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AndRuleValidatorTest {

    @Test

    public void whenAllNestValidatorsAcceptThenAccept(){

      Validator nestedValidator1 =  mock(Validator.class);
      Validator nestedValidator2 =  mock(Validator.class);
      Validator nestedValidator3 =  mock(Validator.class);

      when(nestedValidator1.isValid(any(),any())).thenReturn(true);
      when(nestedValidator2.isValid(any(),any())).thenReturn(true);
      when(nestedValidator3.isValid(any(),any())).thenReturn(true);

        AndRuleValidator testedValidator = new AndRuleValidator(nestedValidator1,nestedValidator2,nestedValidator3);

        boolean shipCanBePlaced = testedValidator.isValid(mock(Ship.class), mock(PlayersBoard.class));

        assertTrue(shipCanBePlaced);

    }
        @Test
    public void whenAtLeastOneNestedValidatorRejectsThenRejects(){
            Validator shipValidator1 = mock(Validator.class);
            Validator shipValidator2 = mock(Validator.class);
            when (shipValidator1.isValid(any(),any())).thenReturn(true);
            when (shipValidator2.isValid(any(),any())).thenReturn(false);

            AndRuleValidator testedValidator  = new AndRuleValidator(shipValidator1,shipValidator2);
            boolean shipCanBePlaced = testedValidator.isValid(mock(Ship.class),PlayersBoard.fresh());
            assertFalse(shipCanBePlaced);
        }
@Test
    public void shouldAcceptAnyShipWhenNoNestedrules(){
        AndRuleValidator testedValidator = new AndRuleValidator();
        boolean shipCanBePlaced = testedValidator.isValid(mock(Ship.class), PlayersBoard.fresh());
}
}