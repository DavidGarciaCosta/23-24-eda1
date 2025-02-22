import java.util.Scanner;

public class VisiCalc {
    public static void main(String[] args) {
        int posX = 0;
        int posY = 0;
        int filas = 15;
        int columnas = 10;

        String[][] hojaCalculo = new String[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                hojaCalculo[i][j] = "       ";
            }
        }


        System.out.println("    A       B       C       D       E       F       G       H       I       J");
        System.out.println("+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
        for (int i = 0; i < filas; i++) {
            System.out.print("|");
            for (int j = 0; j < columnas; j++) {
                if (i == posX && j == posY) {
                    System.out.print("[     ]");
                } else {
                    System.out.print(hojaCalculo[i][j]);
                }
                if (j < columnas - 1) {
                    System.out.print("|");
                }
            }
            System.out.println("|");
        }
        System.out.println("+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("Celda actual : " + (posX + 1) + "  -  " + (posY + 1));

        System.out.println("Utilice las teclas a,w,s,d para moverse.");
        System.out.println("Utilice la tecla e para ingresar un valor.");
        System.out.println("Utilice la tecla q para finalizar el programa.");

        Scanner scanner = new Scanner(System.in);

        while (true) {

            char movimiento = scanner.next().charAt(0);

            switch (movimiento) {
                case 'a':
                    if (posY > 0)
                        posY--;
                    break;
                case 'w':
                    if (posX > 0)
                        posX--;
                    break;
                case 'd':
                    if (posY < columnas - 1)
                        posY++;
                    break;
                case 's':
                    if (posX < filas - 1)
                        posX++;
                    break;
                case 'e':
                    System.out.print("Ingrese un valor (numérico o carácter, máximo 7 caracteres): ");
                    scanner.nextLine();
                    String valor = scanner.nextLine();
                    valor = valor.length() > 7 ? valor.substring(0, 7) : valor;
                    hojaCalculo[posX][posY] = String.format("%7s", valor);
                    break;
                case 'q':
                    System.out.println("Programa finalizado.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Entrada no válida. Usa a, w, d, s para moverte.");
                    break;
            }


            System.out.println("    A       B       C       D       E       F       G       H       I       J");
            System.out.println("+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
            for (int i = 0; i < filas; i++) {
                System.out.print("|");
                for (int j = 0; j < columnas; j++) {
                    if (i == posX && j == posY) {
                        System.out.print("[     ]");
                    } else {
                        System.out.print(hojaCalculo[i][j]);
                    }
                    if (j < columnas - 1) {
                        System.out.print("|");
                    }
                }
                System.out.println("|");
            }
            System.out.println("+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
            System.out.println("Celda actual  : " + (posX + 1) + "  -  " + (posY + 1));
            System.out.println("Utilice las teclas a,w,s,d para moverse.");
            System.out.println("Utilice la tecla e para ingresar un valor.");
            System.out.println("Utilice la tecla q para salir.");
        }
    }
}