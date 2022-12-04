package dam2.dii.p12;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Form
 */
@WebServlet("/edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Edit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		Almacen almacen = new Almacen();
		ArrayList<Contacto> listado = new ArrayList<>();

		int contador = 0;
		int id = Integer.parseInt(request.getParameter("id"));
		int i = 0;
		
		//Se cargan los contactos
		listado = almacen.getListaContactos();
		int idContacto = (listado.size()-1);
		
		//Se busca la id del contacto a editar
		for (Contacto contacto : listado) {
			if(contacto.getId() == id) {
				idContacto = contador;
			}
			contador++;
		}
		
		//Se obtienen los datos del contacto a editar para mostrarlos al usuario.
		String nombre = almacen.getListaContactos().get(idContacto).getNombre();
		String apellidos = almacen.getListaContactos().get(idContacto).getApellidos();
		String email = almacen.getListaContactos().get(idContacto).getEmail();
		Integer telefono = almacen.getListaContactos().get(idContacto).getTelefono();
		String tlf = telefono.toString();
		String comentarios = almacen.getListaContactos().get(idContacto).getComentarios();
		request.setAttribute("nombre",nombre);
		request.setAttribute("apellidos",apellidos);
		request.setAttribute("email",email);
		request.setAttribute("telefono",tlf);
		request.setAttribute("comentarios",comentarios);
		request.getRequestDispatcher("./jsp/edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Almacen almacen = new Almacen();
		ArrayList<Contacto> listado = new ArrayList<>();
		
		int contador = 0;
		String email = request.getParameter("email");

		//Se cargan los datos
		listado = almacen.getListaContactos();
		int idContacto = (listado.size()-1);
		
		//Se busca por email el contacto a editar
		for (Contacto contacto : listado) {
			if(contacto.getEmail().equals(email)) {
				idContacto = contador;
			}
			contador++;
		}
		
		//Se obtienen los datos a editar y se insertan en la posición correspondiente del arraylist.
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		int telefono = Integer.parseInt(request.getParameter("telefono"));
		String comentarios = request.getParameter("comentarios");

			listado.get(idContacto).setNombre(nombre);
			listado.get(idContacto).setApellidos(apellidos);
			listado.get(idContacto).setTelefono(telefono);
			listado.get(idContacto).setComentarios(comentarios);
		
		request.setAttribute("listaContactos", listado);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
