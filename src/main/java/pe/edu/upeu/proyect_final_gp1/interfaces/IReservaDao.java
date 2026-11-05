package pe.edu.upeu.proyect_final_gp1.interfaces;



import pe.edu.upeu.proyect_final_gp1.modelo.Reserva;

import java.util.List;

public interface IReservaDao {
    public boolean insert(Reserva r);

    public boolean update(Reserva r);

    public Reserva searchById(int id);

    public boolean delete(Reserva r);
    public List<Reserva> listAll();

    public boolean updateStatus(Reserva r);

    public boolean ValidateRoom(Reserva r);

}
