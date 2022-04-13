package semana2.taller;

import java.util.Random;

public class Taller {
    public static void main(String[] args){
        var carrito = generarCarritoCompra();
        darCantidadProducto(carrito);
        mostrarNroProducto(carrito);
        mostrarDetalleCompra(carrito);
    }

    public static int[] generarCarritoCompra(){
        var nroProducto = getNumeroAleatorio(20) +1;
        return new int[nroProducto];
    }

    public static void darCantidadProducto(int[] carrito){
        for(var posicion = 0; posicion < carrito.length; posicion++){
            carrito[posicion] = getNumeroAleatorio(16);
        }
    }

    public static int[] generarPrecios(int cantidad){

        var precios = new int[cantidad];
        var valor = 500;

        for(var indice = 0; indice< precios.length; indice++){
            precios[indice] = valor;
            valor += 150;
        }
        return precios;
    }

    private static int getNumeroAleatorio(int tope){
        var random = new Random();
        return random.nextInt(tope);
    }

    public static void mostrarDetalleCompra(int[] carrito){
        var precios = generarPrecios(carrito.length);
        mostrarSubtotal(carrito, precios);
        mostrarTotal(carrito, precios);
    }

    private static void mostrarSubtotal(int[] carrito, int[] precio){
        for(var posicion = 0; posicion < carrito.length; posicion++){
            mostrarDetalleProducto(posicion, carrito[posicion], precio[posicion]);
        }
    }

    private static void mostrarDetalleProducto(int indice, int producto, int precio){
        System.out.println("cantidad de producto ["+ indice+"]: " + producto + ", Subtotal: "+calcularSubtotal(producto,precio));
    }

    private static int calcularSubtotal(int producto, int precio){return producto*precio;}

    public static void mostrarTotal(int[]carrito, int[] precio){
        System.out.println("Total de compra: "+calcularTotal(carrito,precio));
    }

    private static int calcularTotal(int[] carrito, int[] precio){
        var Total= 0;

        for (var posicion = 0; posicion< carrito.length; posicion++){
            Total += carrito[posicion]*precio[posicion];
        }
        return Total;

    }

    public static void mostrarNroProducto(int[] carrito){
        var numeroProductos = getNroroducto(carrito);
        System.out.println("EL carrito contiene "+numeroProductos + " prodcutos");
    }
    private static int getNroroducto(int[] carrito){

        var  numeroProductos = 0;

        for(var numeroProducto : carrito){
            numeroProductos += numeroProducto;
        }
        return numeroProductos;
    }


}
