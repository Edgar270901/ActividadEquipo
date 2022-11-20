___
o__        o__     |   |\
/|          /\      |   |X\
/ > o        <\     |   |XX\

















public class ColaLinealFutbolistas {
    private Futbolista c[]; // Vector para manejar la fila de ENTEROS
    private int frente, fin; // Apuntadores para el frente y final de la estructura

   
    public boolean estaLlena() {
        if (fin == c.length - 1) {
            return true;
        } else {
            return false;
        }
    }



    public int numElementos() {
        return fin - frente + 1;
    }

    public Futbolista elementoEnFrente() {
        if (estaVacia()) {
            return null;
        } else {
            return c[frente];
        }
    }
    public int totalGoles() {
        
        int sumaGoles = 0;

        System.out.println("\nTotal de goles:".toUpperCase());
        for (int ind = 0; ind < c.length; ind++) {
            if (c[ind] != null) {

                sumaGoles += (c[ind].getGoles());

            }
        }

        return sumaGoles; 
    }

    public String toString() {
        String s = "";
        for (int i = frente; i <= fin; i++) {
            s += c[i] + "\n";
        }
        return s;
    }

    public Futbolista elementoEnFin() {
        if (estaVacia()) {
            return null;
        } else {
            return c[fin];
        }
    }

    public Futbolista[] getC() {
        return c;
    }

    public void setC(Futbolista[] c) {
        this.c = c;
    }

    public int getFrente() {
        return frente;
    }

    public void setFrente(int frente) {
        this.frente = frente;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }
}
