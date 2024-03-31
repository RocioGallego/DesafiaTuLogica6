package DesafiaTuLogica6;

import java.time.LocalDateTime;

public class Jugador {
/*
 * Tiene 4 atributos que son:
i. Nombre
ii. Arma
iii. Habitación
iv. HoraPartida
 */
	//Atributos:
	private String nombre;
	private String arma;
	private String habitacion;
	private LocalDateTime horaPartida;
	
	//Constructor sin parametros:
	public Jugador() {
		
	}
	
	//Constructor con parametros:
	public Jugador (String nombre, String arma, String habitacion) {
     this.nombre = nombre;
     this.arma = arma;
     this.habitacion = habitacion;
     this.horaPartida = LocalDateTime.now();//Asignar la hora actual
	}

	
	//Métodos:
	
	public String getNombre() {
		return nombre;
	}
    public void setNombre (String nombre) {
    	this.nombre = nombre;
    }
    public String getArma() {
    	return arma;
    }
    public void setArma(String arma) {
    	this.arma = arma;
    }
    public String getHabitacion() {
    	return habitacion;
    }
    public void setHabitacion(String habitacion) {
    	this.habitacion = habitacion;
    }
    public LocalDateTime getHoraPartida() {
    	return horaPartida;
    }
    public void setHoraPartida(LocalDateTime horaPartida) {
    	this.horaPartida = horaPartida;
    }
    public String toString() {
    	return  "Personaje:'" + nombre + '\'' +
                ", arma:'" + arma + '\'' +
                ", habitacion:'" + habitacion + '\'' +
                ", horaDePartida:" + horaPartida;
    	
    }
}
