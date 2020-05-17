package swsports.usuarios;

import java.util.List;

import swsports.modelo.TransferUsuario;
import swsports.modelo.Usuario;

/**
 * Clase que sirve como fachada del m�dulo Usuarios. Todas las operaciones que
 * tengan que ver con dicho m�dulo se realizan mediante llamadas a los m�todos
 * de esta clase.
 */
public class FachadaUsuarios implements IFachadaUsuarios {

	private ISAUsuarios sa;

	public FachadaUsuarios() {
		sa = new SAUsuarios();
	}

	/**
	 * Devuelve una lista de los usuarios que se adhieren a los par�metros de
	 * b�squeda proporcionados. Los par�metros que sean nulos no se usar�n para la
	 * b�squeda.
	 */
	@Override
	public List<Usuario> busquedaUsuarios(TransferUsuario tUsu) {
		return sa.busquedaUsuarios(null);
	}

	/**
	 * Cierra la sesi�n actual.
	 */
	@Override
	public boolean cerrarSesion() {
		return sa.cerrarSesion();
	}

	/**
	 * Devuelve los datos de un usuario dado su identificador (id).
	 */
	@Override
	public Usuario consultaUsuario(String id) {
		return sa.consultaUsuario(id);
	}

	/**
	 * Da de baja a un usuario dado su identificador (id).
	 */
	@Override
	public boolean darDeBajaUsuario(String id) {
		return sa.darDeBajaUsuario(id);
	}

	/**
	 * Edita los datos de un usuario. Su identificador (id) se usar� para buscar el
	 * usuario que se quiere editar y se sobrescribir�n el resto de datos.
	 */
	@Override
	public boolean editarUsuario(TransferUsuario usu) {
		return sa.editarUsuario(usu);
	}

	/**
	 * Inicia la sesi�n de un usuario dado su identificador (id) y su contrase�a.
	 */
	@Override
	public boolean login(String id, String contrasenya) {
		return sa.login(id, contrasenya);
	}

	/**
	 * Da de alta un usuario y lo registra en la apliaci�n.
	 */
	@Override
	public boolean registroUsuario(Usuario usu) {
		return sa.registroUsuario(usu);
	}

}
