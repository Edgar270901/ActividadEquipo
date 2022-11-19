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
            
            opc = Integer.parseInt(JOptionPane.showInputDialog("\nMenu de opciones\n "+
            "1)Insertar futbolista\n"+
            "2)Mostrar jugadores profesionales\n"+
            "3)Mostrar jugadores amateur\n"+
            "4)Eliminar un jugador profesional\n"+
            "5)Pasar jugadores de amateur a profesional \n"+
            "6)Suma total de goles"+
            "\n7)Salir"+
            "\nIngrese la opcion :"));
            switch (opc) {

                case 1:
                    if (!amateur.estaLlena() || !profesional.estaLlena()) {
                        
                        
                        nombre = JOptionPane.showInputDialog("Ingrese la nombre del jugador");
                       equipo = JOptionPane.showInputDialog("Ingrese el equipo:\n"
                                + "Opciones\n"
                                + "Barcelona\n"
                                + "Valencia\n"
                                + "Sevilla\n");
                       
                         goles =Integer.parseInt( JOptionPane.showInputDialog("Cantidad de goles del jugador:"));
                      
                       
                        categoria =Integer.parseInt(JOptionPane.showInputDialog("Que categoria es el futbolista?\n"
                                + "1)Profesional\n"
                                + "2)Amateur"));
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
                            JOptionPane.showMessageDialog(null,"favor de ingresar un dato valido\n".toUpperCase());
                        }

                    } else {
                        JOptionPane.showMessageDialog(null,"las filas estan llenas\n".toUpperCase());
                    }

                    break;

                case 2:
                    if (!profesional.estaVacia()) {
                        JOptionPane.showMessageDialog(null,"Jugadores Profesionales:\n " + profesional.toString());

                    } else {
                        JOptionPane.showMessageDialog(null,"No hay jugadores".toUpperCase());
                    }

                    break;

                case 3:
                    if (!amateur.estaVacia()) {
                        JOptionPane.showMessageDialog(null,"Jugadores Amateurs:\n " + amateur.toString());

                    } else {
                        JOptionPane.showMessageDialog(null,"No hay jugadores".toUpperCase());
                    }

                    break;

                case 4:

                    if (!profesional.estaVacia()) {
                        JOptionPane.showMessageDialog(null,profesional.eliminar());

                    } else {
                        JOptionPane.showMessageDialog(null,"no hay jugadores profesionales".toUpperCase());
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
                        JOptionPane.showMessageDialog(null,"No hay jugadores registrados".toUpperCase());
                     }
                    

                    break;

                case 6:

                    if (!profesional.estaVacia() || !amateur.estaVacia()) {
                        int sumaTotal = profesional.totalGoles() + amateur.totalGoles();
                        JOptionPane.showMessageDialog(null,"Suma total de goles\n"
                                + sumaTotal);
                    } else {
                        JOptionPane.showMessageDialog(null,"No hay jugadores registrados".toUpperCase());
                    }

                    break;

               
                case 7:
                JOptionPane.showMessageDialog(null,"Saliendo del programa...");
                    break;
            }

        } while (opc != 7);

    }

}

