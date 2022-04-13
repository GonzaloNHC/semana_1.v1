package Semana_1v2;

import java.util.ArrayList;
import java.util.Scanner;


    public class Cajero_v2 {

        static int saldo=0;
        static ArrayList<String> historial;
        static String[] MOVIMIENTOS = {"[1] Depositar dinero", "[2] Sacar dinero", "[3] Mostrar dinero","[4] Salir"};
        static int[] contadorMovimiento = {0, 0, 0, 0};

        public static void main (String[] args){

            Scanner teclado = new Scanner(System.in);
            historial  = new ArrayList<>();
            int opcion = -1;

            System.out.println("Bienvenido al cajero");
            do {
                System.out.println("********MENU*******");
                System.out.println();
                System.out.println("Seleccion la opcion correspondiente");
                System.out.println(MOVIMIENTOS[0]);
                System.out.println(MOVIMIENTOS[1]);
                System.out.println(MOVIMIENTOS[2]);
                System.out.println(MOVIMIENTOS[3]);

                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1 : {
                        System.out.println("Ingrese la cantidad de dinero a depositar");
                        int deposito = teclado.nextInt();
                        saldo = depositar(deposito);
                        contadorMovimiento[0] +=1;
                        historial.add(MOVIMIENTOS[0]);
                        break;
                    }
                    case 2 : {
                        System.out.println("Ingrese la cantidad de dinero a sacar");
                        int retiro = teclado.nextInt();
                        saldo -= sacar(retiro);
                        contadorMovimiento[1] += 1;
                        historial.add(MOVIMIENTOS[1]);
                        break;
                    }
                    case 3: {
                        System.out.println("Mostrar dinero");
                        mostrarSaldo();
                        contadorMovimiento[2] +=1;
                        historial.add(MOVIMIENTOS[2]);
                        break;
                    }
                    default: {
                        System.out.println("opcion incorrecta");
                        System.out.println("escoja otra opcion");
                        break;
                    }
                }
            }while (opcion !=4);
            System.out.println("Gracias por usar el cajero.");
            historial.add(MOVIMIENTOS[3]);
            contadorMovimiento[3] +=1;
            System.out.println();
            mostrarHistorial();
            System.out.println();
            mostrarNroMovimiento();
            System.out.println("Que tenga un buen dia");

        }

        public static int depositar(int deposito){

            int retorno = 0;

            if (deposito>0){
                retorno = saldo + deposito;
            }else {
                System.out.println("No se puede depositar valor negativo");
                retorno = saldo;
            }
            return retorno;
        }

        public static int sacar(int retiro){

            int retorno = 0;

            if(retiro>=0){
                if (saldo-retiro >=0) {
                    retorno = saldo - retiro;
                }else {
                    System.out.println("No se puede tener dinero negativo");
                    retorno = saldo;
                }
            }else{
                System.out.println(" No se puede sacar dinero negativo");
                retorno = saldo;
            }
            return retorno;
        }
        public static void mostrarSaldo(){
            System.out.println(saldo);
        }

        public static void mostrarHistorial(){
            System.out.println("Sus acciones realizadas han sido: ");
            for (int i = 0; i< historial.size();i++){
                System.out.println(historial.get(i));
            }
        }

        public static void mostrarNroMovimiento(){
            for (int i = 0; i  < contadorMovimiento.length; i++) {
                if(contadorMovimiento[i] > 0){
                    System.out.println("La cantidad de veces realizado el movimiento" + MOVIMIENTOS[i]);
                }else{
                    System.out.println("No se han ejecutados accion de tipo"+ MOVIMIENTOS[i]);
                }
            }
        }


    }
