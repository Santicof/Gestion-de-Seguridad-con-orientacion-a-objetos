package modulo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Seguridad {
	private int id;
	private LocalDate fecha;
	private LocalTime hora;
	private boolean entrada;
	private Persona persona;

	public Seguridad(int id, LocalDate fecha, LocalTime hora, boolean entrada, Persona persona) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.entrada = entrada;
		this.persona = persona;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public boolean isEntrada() {
		return entrada;
	}

	public void setEntrada(boolean entrada) {
		this.entrada = entrada;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Seguridad [id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", entrada=" + entrada + ", persona="
				+ persona + "]";
	}

}
