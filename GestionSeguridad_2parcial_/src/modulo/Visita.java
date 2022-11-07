package modulo;

public class Visita extends Persona {
	private String empresa;

	public Visita(int id, String apellido, String nombre, int dni, String empresa) {
		super(id, apellido, nombre, dni);
		this.empresa = empresa;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	@Override
	public String toString() {
		return "Visita [id=" + id + ", apellido=" + apellido + ", nombre=" + nombre + ", dni=" + dni + ", empresa="
				+ empresa + "]\n";
	}

}
