package validaton;

import model.PlayersBoard;
import model.Ship;

import java.util.Arrays;
import java.util.List;


public class AndRuleValidator implements Validator {
    public AndRuleValidator(Validator...validators ) {

        this.validators = Arrays.asList(validators);
}
    private List<Validator> validators;
    @Override
    public boolean isValid(Ship ship, PlayersBoard board) {
        return false;
    }
}
