package dam2.dii.p12;

import java.util.ArrayList;

public class Almacen {
	// Inicializamos con 4 contactos.
	private static ArrayList<Contacto> listaContactos = new ArrayList<Contacto>() {{
		add(new Contacto("Angel", "Sanchez", "Chaip@gmail.com", 666111222, "Lorem ipsum"));
		add(new Contacto("Clara", "Sanchez", "Clara@gmail.com", 666222111, "Comentando"));
		add(new Contacto("Manu", "Sanchez", "Manu@gmail.com", 666666666, "Comentario de Manu"));
		add(new Contacto("Miguel", "Sanchez", "Miguel@gmail.com", 666999555, "Sin comentarios..."));
	}};

	public Almacen() {
		super();
	}

	public ArrayList<Contacto> getListaContactos() {
		return listaContactos;
	}

	public void setListaContactos(Contacto contacto) {
		this.listaContactos.add(contacto);
	}

}