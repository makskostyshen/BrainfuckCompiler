package exceptions;

/**
 * exceptions with wrong number or
 * wrong position of cycle brackets -
 * incorrect cycle representing
 */

public class BracketsException extends IllegalArgumentException{

    public BracketsException(){
        super();
    }
    public BracketsException(String errorMessage){
        super(errorMessage);
    }
}
