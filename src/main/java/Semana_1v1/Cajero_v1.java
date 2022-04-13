package Semana_1v1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class Cajero_v1 {

    //Un cajero se usa para depositar, sacar y mostrar dinero.
    //Tambien se les solicita mostrar el historial de los movimientos realizados
    //y la cantidad de veces que se ha realizado dichos movimiento.
    //a los estudiante de POO ufro
    //Considere que debe hacer un menu y las valoraciones correspondinete

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.println("Bienvenidos al cajero");

        //o representa la opcion ingresada
        int o = -1;
        //d dinero que hay en la cuenta
        int d = 0;

        String[] c = {"[1] depositar dinero.", "[2] sacar dinero.","[3] Mostrar dinero de la cuenta","[4] Salir."};

        //l representa a la lista que contiene los movimientos realizados
        ArrayList<String> l = new ArrayList<>();

        //co representa un contador que lleve la cantidad de veces que se ha realizado un movimiento

        int[] co = {0,0,0,0};

        while(o != 4){//mientras no salir

            System.out.println("*******MENU*******");
            System.out.println("");
            System.out.println("Seleccione la opcion correspondiente");
            System.out.println(c[0]);
            System.out.println(c[1]);
            System.out.println(c[2]);
            System.out.println(c[3]);

            o = s.nextInt();//Asignamos la opcion

            if(o == 1){//Si ingresa dinero
                System.out.println("Ingrese la cantidad de dinero a depositar");
                int t = s.nextInt();

                if(t>0) {
                    d += t;

                }else{
                    System.out.println("No se puede deñpositar dinero negativo");
                }
                co[0] +=1;//Aumentamos el contador del movimiento
                l.add(c[0]);//agragamos el movimiento
            }else if(o == 2) {//Si se saca dinero
                System.out.println("Ingrese la cantidad de dinero a sacar");
                int t = s.nextInt();

                if (t >= 0) {//el dinero a sacar es valido
                    if (d - t >= 0) {
                        d -= t;
                    } else {
                        System.out.println("No se puede tener dinero negativo");
                    }
                }else {
                    System.out.println("No se puede sacar dinero negativo");
                }
                co[1] +=1;//Aumentamos contador
                l.add(c[1]);//Agragamos movimiento
            }else if (o ==3){//mostrar dinero
                System.out.println("El monto disponible es: ");
                System.out.println(d);
                co[2]=+1;
                l.add(c[2]);//agregamos movimiento
            }else if(o == 4) {//si la opcion es invalida
                System.out.println("Opcion incorrecta");
                System.out.println("Escoja otra");
            }
        }
        System.out.println("Gracias por usar el cajero automatico");
        l.add(c[3]);//agregamos el movimiento final.
        co[3]=+1;
        System.out.println("Sus acciones realizadas han sido: ");
        for(int i = 0;i<l.size();i++){
            System.out.println(l.get(i));
        }
        for(int i = 0; i< co.length; i++){
            if(co[i]>0){
                System.out.println("La cantidad de veces que se ha realizado el movimiento: "+c[i].substring(o, c[i].length()-1)+ " es:" + co[i]);
            }else{
                System.out.println("No se han ejecutado acciones de tipo : "+c[i]);

            }
        }
        System.out.println("Que tenga un wen dia caballero");
    }
}
