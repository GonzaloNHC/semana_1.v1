package Semana4;

public class IngresoSaldoNegativoException extends  RuntimeException{

    public IngresoSaldoNegativoException(int deposito){
        super("No se puede realizar un deposito negativo. El Deposito ha sido: "+ deposito);
    }

}
