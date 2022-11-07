package modulo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Persona> lstaPersona;
	private List<Seguridad> lstaSeguridad;

	public Sistema() {

		this.lstaPersona = new ArrayList<Persona>();
		this.lstaSeguridad = new ArrayList<Seguridad>();
	}

//metodos
	public boolean agregarEmpleado(String apellido, String nombre, int dni, int nroLegajo) {
		int proxId = 1;
		if (this.lstaPersona.size() > 0) {
			proxId = this.lstaPersona.get(lstaPersona.size() - 1).getDni() + 1;
		}
		return this.lstaPersona.add(new Empleado(proxId, apellido, nombre, dni, nroLegajo));
	}

	public boolean agregarVisita(String apellido, String nombre, int dni, String empresa) {
		int proxId = 1;
		if (this.lstaPersona.size() > 0) {
			proxId = lstaPersona.get(lstaPersona.size() - 1).getDni() + 1;
		}
		return this.lstaPersona.add(new Visita(proxId, apellido, nombre, dni, empresa));
	}

	public Persona traerPersona(int id) {
		Persona pe = null;
		int i = 0;
		while (i < lstaPersona.size() && pe == null) {
			if (lstaPersona.get(i).getId() == id) {
				pe = this.lstaPersona.get(i);
			}
			i++;
		}
		return pe;
	}

	public List<Seguridad> traerSeguridad(LocalDate fecha, Persona persona) {
		List<Seguridad> lista = new ArrayList<Seguridad>();
		for (int i = 0; i < this.lstaSeguridad.size(); i++) {
			if (this.lstaSeguridad.get(i).getFecha().equals(fecha)
					&& this.lstaSeguridad.get(i).getPersona().getNombre().equals(persona.getNombre())) {
				lista.add(this.lstaSeguridad.get(i));
			}

		}
		return lista;
	}
	
	public boolean agregarSeguridad(LocalDate fecha, LocalTime hora, boolean entrada, Persona persona)
			throws Exception {

		List<Seguridad> listaSeguridad = traerSeguridad(fecha, persona);
		if (listaSeguridad.size() > 0) {
			if (listaSeguridad.get(listaSeguridad.size() - 1).isEntrada() == entrada) {
				throw new Exception("ERROR: Se esta intentando marcar dos veces la entrada o salida.");
			}
		}

		int proxId = 1;
		if (this.lstaSeguridad.size() > 0) {
			proxId = this.lstaSeguridad.get(this.lstaSeguridad.size() - 1).getId() + 1;
		}
		return this.lstaSeguridad.add(new Seguridad(proxId, fecha, hora, entrada, persona));
	}

	
	public List<Seguridad> traerVisitas(LocalDate fecha) {
		List<Seguridad> lista = new ArrayList<Seguridad>();

		for (int i = 0; i < this.lstaSeguridad.size(); i++) {
			if (this.lstaSeguridad.get(i).getFecha().equals(fecha)
					&& this.lstaSeguridad.get(i).getPersona() instanceof Visita) {
				lista.add(this.lstaSeguridad.get(i));
			}
		}

		return lista;
	}
	
	
	public List<Persona> getLstaPersona() {
		return lstaPersona;
	}

	public List<Seguridad> getLstaSeguridad() {
		return lstaSeguridad;
	}

	@Override
	public String toString() {
		return "Sistema [lstaPersona=" + lstaPersona + ", lstaSeguridad=" + lstaSeguridad + " " + super.toString();
	}

}
