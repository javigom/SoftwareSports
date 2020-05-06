package swsports.usuarios;

import java.util.List;

import swsports.modelo.Usuario;

public interface IFachadaUsuarios {
	public boolean registroUsuario(Usuario usu);

	public boolean login(String id, String contrasenya);

	public List<Usuario> busquedaUsuarios(String nombre, String mail, String id, int telefono, String direccion);

	public Usuario consultaUsuario(String id);

	public boolean darDeBajaUsuario(String id);

	public boolean editarUsuario(Usuario usu);

	public boolean hacerAdmin(String id);

	public boolean quitarAdmin(String id);

	public boolean cerrarSesion();
}
