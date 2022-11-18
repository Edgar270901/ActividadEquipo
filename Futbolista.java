public class Futbolista {
    String nombre;
    String equipo;
    int goles;
    
    
    public Futbolista(String nombre, String equipo, int goles){
        this.equipo=equipo;
        this.goles=goles;
        this.nombre=nombre;
    }
	
	public String getNombre() {
		return nombre;
	}
	
	
	public String getEquipo() {
		return equipo;
	}
        public int getGoles() {
		return goles;
	}
	
	
	public void setNombre(String nuevoNombre) {
		this.nombre=nuevoNombre;
		
	}
	
	public void setEquipo(String nuevoEquipo) {
		this.equipo=nuevoEquipo;
	}
        
        public void setGoles(int nuevoGoles) {
		this.goles=nuevoGoles;
	}
        
        
	
	public String toString() {
		return"\nEl nombre del jugador es:\n"+ nombre
			+"\nEl equipo es:\n"+equipo
                        +"\nLos goles del jugador son:\n" + goles;
		
	}

}
