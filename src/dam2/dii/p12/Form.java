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
@WebServlet("/form")
public class Form extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Almacen almacen = new Almacen();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Form() {
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
		int idContacto = 0;
		int id = Integer.parseInt(request.getParameter("id"));
		int i = 0;

//		do {
			//Se cargan los contactos
			listado = almacen.getListaContactos();
//			i++;
//		}while(almacen.getListaContactos().size()>i);

			
		//Se busca la id del contacto a eliminar
		for (Contacto contacto : listado) {
			if(contacto.getId() == id) {
				idContacto = contador;
			}
			contador++;
		}
		almacen.getListaContactos().remove(idContacto);
		request.setAttribute("listaContactos", almacen.getListaContactos());
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String texto = "";
		boolean emailExiste = false;
		
		//Se leen los datos para el alta del nuevo contacto
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String email = request.getParameter("email");
		int telefono = Integer.parseInt(request.getParameter("telefono"));
		String comentarios = request.getParameter("comentarios");

			// Se comprueba si ya existe ese usuario (a través del email, nuestra primary key).
			emailExiste = comprobarEmail(email);
			if (!emailExiste) {
				Contacto contacto = new Contacto(nombre, apellidos, email, telefono, comentarios);
				almacen.getListaContactos().add(contacto);
				texto = "Contacto " + email +  " registrado correctamente.";
			} else {
				texto = "El email ya está registrado.";
			}
		
		request.setAttribute("texto", texto);
		request.setAttribute("listaContactos", almacen.getListaContactos());
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	public boolean comprobarEmail(String email) {
		for(int i = 0; i<almacen.getListaContactos().size(); i++) {
			if(email.equals(almacen.getListaContactos().get(i).getEmail()))
				return true;
		}
		return false;
	}

}
