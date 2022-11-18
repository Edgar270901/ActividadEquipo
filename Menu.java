import java.util.Scanner;

/**
 *
 * @author Edgar Robles
 */
public class Menu {

    public static void main(String[] args) {

        ColaLinealFutbolistas profesional = new ColaLinealFutbolistas(15);
        ColaCircularFutbolistas amateur = new ColaCircularFutbolistas(15);
        Scanner entrada = new Scanner(System.in);

        int opc = 0;
        String nombre;
        String equipo;
        int goles = 0;
        int categoria;

        do {
            System.out.println("\nMenu de opciones".toUpperCase() + "\n");
            System.out.println("1)Insertar futbolista");
            System.out.println("2)Mostrar jugadores profesionales");
            System.out.println("3)Mostrar jugadores amateur");
            System.out.println("4)Eliminar un jugador profesional");
            System.out.println("5)Pasar jugadores de amateur a profesional ");
            System.out.println("6)Suma total de goles");
            System.out.println("7)Jugador amateur con mas goles");
            System.out.println("8)Jugadores de un equipo");
            System.out.println("9)Salir\n");
            System.out.println("\nIngrese la opcion :");
            opc = entrada.nextInt();
            switch (opc) {

                case 1:
                    if (!amateur.estaLlena() || !profesional.estaLlena()) {
                        System.out.println("Ingrese la nombre del jugador");
                        entrada.nextLine();
                        nombre = entrada.nextLine();
                        System.out.println("Ingrese el equipo:\n"
                                + "Opciones\n"
                                + "\nBarcelona\n"
                                + "Valencia\n"
                                + "Sevilla\n");
                        equipo = entrada.nextLine();
                        System.out.println("Cantidad de goles del jugador:");
                        goles = entrada.nextInt();
                        System.out.println("Que categoria es el futbolista?\n"
                                + "1)Profesional\n"
                                + "2)Amateur");
                        categoria = entrada.nextInt();
                        if (!amateur.estaLlena() || !profesional.estaLlena()) {
                            if (categoria > 0 && categoria <= 2) {
                                if (categoria == 1) {
                                    profesional.insertar(new Futbolista(nombre, equipo, goles));
                                }
                                if (categoria == 2) {
                                    amateur.insertar(new Futbolista(nombre, equipo, goles));
                                }
                            }
                        } else {
                            System.out.println("favor de ingresar un dato valido\n".toUpperCase());
                        }

                    } else {
                        System.out.println("las filas estan llenas\n".toUpperCase());
                    }

                    break;

                case 2:
                    if (!profesional.estaVacia()) {
                        System.out.println("Jugadores Profesionales:\n " + profesional.toString());

                    } else {
                        System.out.println("No hay jugadores".toUpperCase());
                    }

                    break;

                case 3:
                    if (!amateur.estaVacia()) {
                        System.out.println("Jugadores Amateurs:\n " + amateur.toString());

                    } else {
                        System.out.println("No hay jugadores".toUpperCase());
                    }

                    break;

                case 4:

                    if (!profesional.estaVacia()) {
                        System.out.println(profesional.eliminar());

                    } else {
                        System.out.println("no hay jugadores profesionales".toUpperCase());
                    }

                    break;

                case 5:
                    if (!profesional.estaVacia() && !amateur.estaVacia()) {
                        int a = 1, frente = profesional.getFrente();
                        int fin = profesional.getFin(), contador = amateur.getContador();

                        for (int id = frente; id <= fin; id++) {
                            Futbolista elementoborrado = amateur.eliminar();
                            profesional.insertar(elementoborrado);
                        }
                        
                    }else {
                        System.out.println("No hay jugadores registrados".toUpperCase());
                     }
                    

                    break;

                case 6:

                    if (!profesional.estaVacia() || !amateur.estaVacia()) {
                        int sumaTotal = profesional.totalGoles() + amateur.totalGoles();
                        System.out.println("Suma total de goles\n"
                                + sumaTotal);
                    } else {
                        System.out.println("No hay jugadores registrados".toUpperCase());
                    }

                    break;

                case 7:
                    
                    break;

                case 8:
                    
                    break;

                case 9:
                    System.out.println("Saliendo del programa...");
                    break;
            }

        } while (opc != 9);

    }

}

