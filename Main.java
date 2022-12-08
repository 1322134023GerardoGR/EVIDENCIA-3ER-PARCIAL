import java.util.*;
public class Main {
    public static void main(String[] args){
        ArrayList<String>nombres=new ArrayList<String>();
        ArrayList<Integer>barcos=new ArrayList<Integer>();
        ArrayList<Integer>puntuacion=new ArrayList<Integer>();
        Scanner leer=new Scanner(System.in); //PARA STRING
        Scanner leer1=new Scanner(System.in); //PARA INT
        Scanner leer2=new Scanner(System.in);
        int tamanioTablero=0, cantBarcos1=0, cantBarcos2=0, ganador=0;
        String[][] TJugador1=null;
        String[][] TJugador2=null;
        String[][] TableroVacio_J1=null;
        String[][] TableroVacio_J2=null;
        String nameJugador;
        int puntuacionJugador1=0,puntuacionJugador2=0,p=0;
        System.out.println("Bienvenido a Batalla Naval");
        while(p==0) {
            System.out.print("Ingresa el tamaño del tablero(minimo 2)(lxl): ");
            tamanioTablero = leer.nextInt();
            if(tamanioTablero>1){
                p=1;
            }
            else{
                System.out.println("valor no permitido\n intentalo de nuevo");
            }
        }
        TJugador1= new String[tamanioTablero] [tamanioTablero];
        TJugador2= new String[tamanioTablero] [tamanioTablero];
        TableroVacio_J1= new String[tamanioTablero] [tamanioTablero];
        TableroVacio_J2= new String[tamanioTablero] [tamanioTablero];
        System.out.println("El tablero queda de la siguiente forma");
        TJugador1=Creartablero(TJugador1);
        TJugador2=Creartablero(TJugador2);
        TableroVacio_J1=Creartablero(TableroVacio_J1);
        TableroVacio_J2=Creartablero(TableroVacio_J2);
        imprimirTablero(TJugador1);
        System.out.println("-------------JUGADOR 1-------------");
        System.out.print("Ingrese el nombre del primer jugador:");
        nameJugador=leer1.nextLine();
        nombres.add(nameJugador);
        System.out.println("\nJUGADOR 1 tienes un limite de 4 barcos\n");
        int si=0;
        while (si==0){
            System.out.print("Ingresa cuantos barcos tendras: ");
            cantBarcos1=leer.nextInt();
            if (cantBarcos1>0 && cantBarcos1<=4){
                barcos.add(cantBarcos1);
                System.out.println( );
                si=1;
                System.out.println("JUGADOR 1 tendras "+cantBarcos1+" barcos");
            }else{
                System.out.println("No se pueden este numero de barcos ... \nVUELVE A INGRESAR\n");
            }
        }
        Barcos(TJugador1, leer1, cantBarcos1);

        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n   ");
        //JUGADOR 2 TABLERO
        System.out.println("---------------------------------------------------------------------");
        System.out.println("-------------JUGADOR 2--------------");
        System.out.print("Ingresa el nombre del segundo jugador:");
        nameJugador=leer2.nextLine();
        nombres.add(nameJugador);
        System.out.println(" ");
        System.out.println("JUGADOR 2 tienes un limite de 4 barcos");
        System.out.println(" ");
        int si2=0;
        while (si2==0){
            System.out.print("Ingresa cuantos barcos deseas tener: ");
            cantBarcos2=leer.nextInt();
            if (cantBarcos2>0 && cantBarcos2<=4){
                barcos.add(cantBarcos2);
                System.out.println( );
                si2=1;
                System.out.println("JUGADOR 1 tendras "+cantBarcos2+" barcos");
            }else{
                System.out.println("No se pueden este numero de barcos ... ");
                System.out.println("VUELVE A INGRESAR");
            }
        }
        Barcos(TJugador2, leer1, cantBarcos2);
        //HACERLO POR BARCOS
        System.out.println("Jugadores en Juegos"+nombres);
        System.out.println("-------------------------------------------------------\n");
        Rondas(TJugador1, TJugador2, leer, leer1, nombres, puntuacionJugador1, TableroVacio_J1, TableroVacio_J2,puntuacionJugador2,  ganador,cantBarcos1,cantBarcos2);
        puntuacion.add(puntuacionJugador1);
        puntuacion.add(puntuacionJugador2);
        System.out.println("--------------------------GANADOR-------------------------");
        System.out.print("Nombre: ");
        System.out.println(nombres.get(ganador));
        System.out.print("Puntuacion: ");
        System.out.println(puntuacion.get(ganador));
        System.out.println("------------------GRACIAS POR JUGAR------------------------");
    }

    public static String[][] Creartablero(String[][] tablero_jugador){
        for (int a=0; a<tablero_jugador.length; a++){
            for (int j=0; j<tablero_jugador.length; j++){
                tablero_jugador[a][j]="°";
            }
        }
        return tablero_jugador;
    }


    //imprimir tablero jugador 1
    public static void imprimirTablero(String[][] tablero_jugador){
        int b=0;
        int c=0;
        System.out.print("   ");
        for (int i = 0; i < tablero_jugador.length; i++) {//Coordenadas de arriba
            c++;

            if (i<=8){
                System.out.print(" "+c+"   ");
            }else{
                System.out.print(" "+c+"  ");
            }
        }
        System.out.println(" ");
        for (int i = 0; i < tablero_jugador.length; i++) { //Coordenadas de los de los lados
            b++;
            if (i<=8){
                System.out.print(" "+b);
            }else{
                System.out.print(b);
            }
            for (int j = 0; j < tablero_jugador[0].length; j++) {

                if (j == 0 || j == tablero_jugador.length - 1) {
                    if (j == 0) {
                        System.out.print("| " + tablero_jugador[i][j]+"  ");

                    }
                    if (j == tablero_jugador.length - 1) {
                        System.out.print("  "+tablero_jugador[i][j] + "  |");
                    }
                } else {
                    System.out.print("  " + tablero_jugador[i][j] + "  ");
                }
            }
            System.out.println(" ");
        }

    }
    // imprimir tablero jugador 2

    public static void Barcos(String[][] tablero_jugador, Scanner leer, int numBarco1){
        int barcoporponer=1;
        while (numBarco1>0){
            if (barcoporponer==1){
                barcoporponer+=1;
                System.out.println("------------------------------------------------------");
                System.out.println("-----------------PON TU PRIMER BARCO------------------");
                int otra=0;
                while (otra==0){
                    System.out.println("Ingresa la columna donde quieres poner tu barco");
                    int x= leer.nextInt();
                    if (x>0 && x<=tablero_jugador[0].length ){
                        int comprobarfila=0;
                        while (comprobarfila==0){
                            System.out.println("Ingresa la fila donde quieres poner tu barco");
                            int y=leer.nextInt();
                            if (y>0 && y<=tablero_jugador[0].length ){
                                y=y-1;
                                x=x-1;
                                tablero_jugador[y][x]="A";
                                imprimirTablero(tablero_jugador);
                                numBarco1=numBarco1-1;
                                otra=1;
                                comprobarfila=1;
                            }else{
                                System.out.println("NO ES UNA FILA CORRECTA");
                            }
                        }
                    }else{
                        System.out.println("NO ES UNA COLUMNA CORRECTA");
                    }
                }

            }else if (barcoporponer==2){
                System.out.println("------------------------------------------------------");
                System.out.println("----------------PON TU SEGUNDO BARCO------------------");
                int otra=0;
                while (otra==0){
                    System.out.println("Ingresa la columna donde quieres poner tu barco");
                    int x= leer.nextInt();
                    if (x>0 && x<=tablero_jugador[0].length ){

                        int comprobarfila=0;
                        while (comprobarfila==0){
                            System.out.println("Ingresa la fila donde quieres poner tu barco");
                            int y=leer.nextInt();
                            if (y>0 && y<=tablero_jugador[0].length ){
                                y=y-1;
                                x=x-1;
                                tablero_jugador[y][x]="B";
                                otra=1;
                                comprobarfila=1;
                                imprimirTablero(tablero_jugador);
                            }else{
                                System.out.println("NO ES UNA FILA CORRECTA");
                            }
                        }
                    }else{
                        System.out.println("NO ES UNA COLUMNA CORRECTA");
                    }
                }


                barcoporponer++;
                numBarco1=numBarco1-1;
            }else if (barcoporponer==3) {
                System.out.println("------------------------------------------------------");
                System.out.println("----------------PON TU TERCER BARCO-------------------");
                int otra=0,verificacion1=0;
                while (otra==0){
                    while(verificacion1==0) {
                        System.out.println("Ingresa la columna donde quieres poner tu barco");
                        int x = leer.nextInt();
                        if (x > 0 && x <= tablero_jugador[0].length) {
                            verificacion1 = 1;

                            int comprobarfila = 0;
                            while (comprobarfila == 0) {
                                System.out.println("Ingresa la fila donde quieres poner tu barco");
                                int y = leer.nextInt();
                                if (y > 0 && y <= tablero_jugador[0].length) {
                                    y = y - 1;
                                    x = x - 1;
                                    tablero_jugador[y][x] = "C";

                                    otra = 1;
                                    comprobarfila = 1;
                                    imprimirTablero(tablero_jugador);
                                } else {
                                    System.out.println("NO ES UNA FILA CORRECTA");
                                }
                            }
                        } else {
                            System.out.println("NO ES UNA COLUMNA CORRECTA\n Vuelva a ingresar intentarlo");
                        }
                    }
                }


                barcoporponer++;
                numBarco1=numBarco1-1;
            }else if (barcoporponer==4){
                System.out.println("------------------------------------------------------");
                System.out.println("-----------------PON TU CUARTO BARCO-------------------");

                int otra=0;
                while (otra==0){
                    System.out.println("Ingresa la columna donde quieres poner tu barco");
                    int x= leer.nextInt();
                    if (x>0 && x<=tablero_jugador[0].length ){

                        int comprobarfila=0;
                        while (comprobarfila==0){
                            System.out.println("Ingresa la fila donde quieres poner tu barco");
                            int y=leer.nextInt();
                            if (y>0 && y<=tablero_jugador[0].length ){
                                y-=1;
                                x-=1;
                                tablero_jugador[y][x]="D";
                                otra=1;
                                comprobarfila=1;
                                imprimirTablero(tablero_jugador);
                            }else{
                                System.out.println("NO ES UNA FILA CORRECTA");
                            }
                        }
                    }else{
                        System.out.println("NO ES UNA COLUMNA CORRECTA");
                    }
                }

                barcoporponer++;
                numBarco1=numBarco1-1;
            }
        }
    }

    public static void Rondas(String[][] tablero_jugador1, String[][] tablero_jugador2, Scanner leer, Scanner leer1, ArrayList<String> nombres,int puntuacionJugador1, String[][] tablero_nadajugador1, String[][] tablero_sinmodifjugador2,int puntuacionJugador2,int ganador,int cantbarcos1,int cantbarcos2){
        int rondas=0,barcosrestantes1=cantbarcos1,barcosrestantes2=cantbarcos2;

        puntuacionJugador1=0;
        puntuacionJugador2=0;
        ArrayList <Integer> puntos=new ArrayList<Integer>();
        puntos.add(puntuacionJugador1);
        puntos.add(puntuacionJugador2);
        while (rondas==0) {
            int ronda1 = 0;
            int ronda2 = 0;
            while (ronda1 == 0) {
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n   ");
                System.out.println("============TURNO JUGADOR 1============");
                System.out.print("Jugador 1: ");
                System.out.println(nombres.get(0));
                System.out.println(" EL TABLERO DEL ENEMIGO ES EL SIGUIENTE CON POSICIONES DONDE ATACASTE: ");
                imprimirTablero(tablero_sinmodifjugador2);
                System.out.println("ESTE ES TU TABLERO: ");
                imprimirTablero(tablero_jugador1);
                int verificador1 = 0;
                while (verificador1 == 0) {
                    System.out.println("Pon columna para atacar");
                    int x = leer.nextInt();
                    if (x > 0 && x <= tablero_jugador2[0].length) {
                        int comprobarfila = 0;
                        verificador1 = 1;
                        while (comprobarfila == 0) {
                            System.out.println("Pon fila para atacar");
                            int y = leer.nextInt();
                            if (y > 0 && y <= tablero_jugador2[0].length) {
                                y = y - 1;
                                x = x - 1;
                                if (!tablero_jugador2[y][x].equals("X")) {
                                    if (tablero_jugador2[y][x].equals("A") | tablero_jugador2[y][x].equals("B") | tablero_jugador2[y][x].equals("C") | tablero_jugador2[y][x].equals("D")) {
                                        System.out.println(" LE DISTE A UN BARCO GANASTE 200 PUNTOS");
                                        System.out.println("=========================================");
                                        tablero_jugador2[y][x] = "X";
                                        tablero_sinmodifjugador2[y][y] = "X";
                                        puntuacionJugador1+=200;
                                        comprobarfila = 1;
                                        ronda1 = 1;
                                        barcosrestantes2--;
                                    } else {
                                        System.out.println("NO LE DISTE A NINGUN BARCO");
                                        tablero_jugador2[y][x] = "X";
                                        tablero_sinmodifjugador2[y][x] = "X";
                                        ronda1 = 1;
                                        comprobarfila = 1;
                                    }
                                }
                                else{
                                    System.out.println("ya tiraste en esta posicion");
                                    verificador1=0;
                                }
                            } else {
                                System.out.println("NO ES UNA FILA CORRECTA\n vuelve a intentar");
                            }
                        }
                    } else {
                        System.out.println("NO ES UNA COLUMNA CORRECTA\n vuelve a intentar");
                    }
                }
            }
            int t = 0;
            for (int a = 0; a < tablero_jugador2.length; a++) {
                for (int j = 0; j < tablero_jugador2.length; j++) {
                    if(barcosrestantes2==0) {
                        if (!tablero_jugador2[a][j].equals("A") && !tablero_jugador2[a][j].equals("B") && !tablero_jugador2[a][j].equals("C") && !tablero_jugador2[a][j].equals("D") && t == 0) {
                            System.out.println("JUGADOR 1 GANO EL JUEGO");
                            ganador = 0;
                            rondas = 1;
                            t = 1;
                        }
                    }
                }
            }
            if (ganador != 0) {
                //if para buscar letras
                while (ronda2 == 0) {
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n   ");
                    System.out.println("============TURNO JUGADOR 2============");
                    System.out.print("Jugador 2: ");
                    System.out.println(nombres.get(1));
                    System.out.println(" EL TABLERO DEL ENEMIGO ES EL SIGUIENTE CON POSICIONES DONDE ATACASTE: ");
                    imprimirTablero(tablero_nadajugador1);
                    System.out.println("ESTE ES TU TABLERO: ");
                    imprimirTablero(tablero_jugador2);
                    System.out.println("Pon columna para atacar");
                    int x = leer.nextInt();
                    if (x > 0 && x <= tablero_jugador1[0].length) {
                        int comprobarfila = 0;
                        while (comprobarfila == 0) {
                            System.out.println("Pon fila para atacar");
                            int y = leer.nextInt();
                            if (y > 0 && y <= tablero_jugador1[0].length) {
                                y = y - 1;
                                x = x - 1;
                                if (tablero_jugador1[y][x].equals("A") | tablero_jugador1[y][x].equals("B") | tablero_jugador1[y][x].equals("C") | tablero_jugador1[y][x].equals("D")) {
                                    System.out.println(" LE DISTE A UN BARCO GANASTE 200 PUNTOS");
                                    System.out.println("--------------------------------------------");
                                    tablero_jugador1[y][x] = "X";
                                    tablero_nadajugador1[y][x] = "X";
                                    puntuacionJugador2 += 200;
                                    comprobarfila = 1;
                                    ronda2 = 1;
                                    barcosrestantes1--;
                                    System.out.println("--------------------------------------------");
                                } else {
                                    System.out.println("NO LE DISTE A NINGUN BARCO");
                                    tablero_jugador1[y][x] = "X";
                                    tablero_nadajugador1[y][x] = "X";
                                    ronda2 = 1;
                                    comprobarfila = 1;
                                }
                            } else {
                                System.out.println("NO ES UNA FILA CORRECTA");
                            }
                        }
                    } else {
                        System.out.println("NO ES UNA COLUMNA CORRECTA");
                    }
                }
            }
            //if para buscar letras
            if(ganador!=0) {
                int r = 0;
                for (int a = 0; a < tablero_jugador1.length; a++) {
                    for (int j = 0; j < tablero_jugador1.length; j++) {
                        if(barcosrestantes1==0) {
                            if (tablero_jugador1[a][j] != "A" && tablero_jugador1[a][j] != "B" && tablero_jugador1[a][j] != "C" && tablero_jugador1[a][j] != "D" && r == 0) {
                                System.out.println("JUGADOR 2 GANO EL JUEGO");
                                ganador = 1;
                                rondas = 1;
                                r = 1;
                            }
                        }
                    }
                }
            }
        }//while cierra
    }
}