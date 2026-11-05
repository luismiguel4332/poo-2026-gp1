package pe.edu.upeu.proyect_final_gp1.test;



import pe.edu.upeu.proyect_final_gp1.implementacion.ReservaDaoImpl;
import pe.edu.upeu.proyect_final_gp1.interfaces.IReservaDao;
import pe.edu.upeu.proyect_final_gp1.modelo.Cliente;
import pe.edu.upeu.proyect_final_gp1.modelo.Habitacion;
import pe.edu.upeu.proyect_final_gp1.modelo.Reserva;

import java.time.LocalDate;
import java.util.List;

public class TestReserva {
    static IReservaDao Dao= new ReservaDaoImpl();

    public void insert(){
        Reserva r = new Reserva();
        Cliente c = new Cliente();
        Habitacion h= new Habitacion();

        c.setIdcliente(1);
        r.setCliente(c);

        h.setIdhabitacion(1);
        r.setHabitacion(h);

        r.setFechaReserva(LocalDate.now());
        r.setFechaIngreso(LocalDate.parse("2026-10-23"));
        r.setFechaSalida(LocalDate.parse("2026-10-25"));
        r.setTotal(200);
        r.setEstado("R");
        boolean reult =Dao.insert(r);
        if(reult){
            System.out.println("Reserva succes");
        }else {
            System.out.println("reserva error");
        }


    }
    public void list(){
        List<Reserva> lista= Dao.listAll();
        if (lista != null && !lista.isEmpty()){
            for(Reserva r : lista){
                System.out.println("ID_RESERVA:"+r.getIdreserva());
                System.out.println("FECHA_RESERVA:"+r.getFechaReserva());
                System.out.println("NOMBRE:"+r.getCliente().getNombre());
                System.out.println("FECHA_INGRESO:"+r.getFechaIngreso());
                System.out.println("FECHA_SALIDA:"+r.getFechaSalida());
                System.out.println("NUMERO_HAB:"+r.getHabitacion().getNumeroHabitacion());
                System.out.println("PISO:"+r.getHabitacion().getNumeroPiso());
                System.out.println("PRECIO:"+r.getHabitacion().getPrecio());
                System.out.println("ESTADO:"+r.getEstado());
                System.out.println("-----------------------------------------");




            }


        }else {
            System.out.println("no hay registros");
            System.out.println("_------------------");
        }

    }

    public void updateStatus(){
        Reserva r= new Reserva();
        r.setEstado("O");
        r.setIdreserva(1);
        boolean result= Dao.updateStatus(r);
        if(result){
            System.out.println("update succes");
        }else {
            System.out.println("update error");
        }
    }
    public void validateHab(){
        Reserva r= new Reserva();
        Habitacion h= new Habitacion();
        h.setIdhabitacion(1);
        r.setHabitacion(h);

        r.setFechaIngreso(LocalDate.parse("2026-10-24"));
        r.setFechaIngreso(LocalDate.parse("2026-10-26"));

        boolean result= Dao.ValidateRoom(r);
        if(result){
            System.out.println("update succes");
        }else {
            System.out.println("update error");
        }
    }

    public static void main(String[] args) {
        TestReserva t=new TestReserva();
        //t.insert();
        //t.list();
        //t.updateStatus();
        t.validateHab();
    }
}
