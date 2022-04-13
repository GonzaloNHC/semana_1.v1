package semana2;

public class ejemplo {
    public static void main(String[] args){
        var valor = dividir(5,0);
        System.out.println(valor);
    }
    public static int dividir(int dividiendo,int divisor){
        try {
            return dividirInterno(dividiendo, divisor);
        }catch (ArithmeticException e){
            System.err.println("No se puede divir cero");
        }
        return 0;
    }

    public static int dividirInterno(int dividiendo, int divisor){
        if(esCero(divisor)){
            throw new ArithmeticException();
        }
        return dividiendo/divisor;
    }

    public static int[] crearArray(int dimension){
        try {
            return crearArrayInterno(dimension);
        }catch (NegativeArraySizeException e){
            System.err.println("La dimension ingresada no es valida: " +e.getMessage() );
        }
        return new int[0];
    }

    private static int[] crearArrayInterno(int dimension){
        if(esNegativo(dimension)){
            dimension=0;
        }
        return new int[dimension];
    }

    public static boolean esCero(int divisor){ return divisor==0;}
    public static boolean esNegativo(int dimension){
        return dimension<0;
    }
}
