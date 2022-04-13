package Semana4;

public class RetiroNegativoException extends RuntimeException{
    public RetiroNegativoException(int retiro){
        super("No se puede realizar un retiro negativo. El retiro ha sido "+ retiro);
    }

}

