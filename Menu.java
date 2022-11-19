import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Edgar Robles y JULian
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
            
            opc = Integer.parseInt(JOptionPane.showInputDialog("\nMenu de opciones\n 1)Insertar futbolista\n2)Mostrar jugadores profesionales\n3)Mostrar jugadores amateur\n4)Eliminar un jugador profesional\n5)Pasar jugadores de amateur a profesional \n6)Suma total de goles7)Salir\n\nIngrese la opcion :"));
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
                    System.out.println("Saliendo del programa...");
                    break;
            }

        } while (opc != 7);

    }

}

