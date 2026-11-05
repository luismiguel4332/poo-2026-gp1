package pe.edu.upeu.proyect_final_gp1.modelo;

public class UserSession {
    private static UserSession instance;
    private Usuario userLogger;
    private UserSession(){}
    public static UserSession getInstance(){
        if (instance == null){
            instance = new UserSession();
        }
        return instance;

    }
    public Usuario getUserLogger(){
        return  userLogger;
    }
    public void setUserLogger(Usuario usuario){
        this.userLogger = usuario;
    }
    public void cleanSesion(){
        userLogger = null;
    }

}
