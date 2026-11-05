package pe.edu.upeu.proyect_final_gp1.test;

import pe.edu.upeu.proyect_final_gp1.implementacion.UsuarioDaoImpl;
import pe.edu.upeu.proyect_final_gp1.interfaces.IUsuarioDao;
import pe.edu.upeu.proyect_final_gp1.modelo.Usuario;

public class TestUsuario  {
private static IUsuarioDao dao = new UsuarioDaoImpl();
public  void valid_login(){
    Usuario u = dao.login("admin","admin123");
    if (u != null){
        System.out.println("idUsuario"+u.getIdusuario());
        System.out.println("Nombre"+u.getNombre());
        System.out.println("Usuario"+u.getUser());
        System.out.println("Tipo-user"+u.getTipoUser());
    } else {
        System.out.println("error login");
    }
}

    public static void main(String[] args) {
        TestUsuario t = new TestUsuario();
        t.valid_login();
    }
}
