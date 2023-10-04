package controller;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import dao.DaoReserve;
import factory.ConnectionFactory;
import model.Reserve;

public class ControllerReserve {

    private DaoReserve daoReserve;

    public ControllerReserve() {
        Connection connexion= new ConnectionFactory().respawnConnection();
        this.daoReserve = new DaoReserve(connexion);
    }

    public void save(Reserve reserve) {
        this.daoReserve.save(reserve);
    }

    public List<Reserve> list(){
        return this.daoReserve.listar();
    }

    public List<Reserve> listId(Integer id){
        return this.daoReserve.listarId(id);
    }

    public void update(String nombre, String apellido, Integer edad, Long telefono, String pais, Date fecha_ent,
                       Date fecha_sal, String valor, String forma_pago, Integer id) {
        this.daoReserve.actualizar(nombre,apellido,edad,telefono,pais,fecha_ent,fecha_sal,valor,forma_pago,id);
    }

    public void delete(Integer id) {
        this.daoReserve.eliminar(id);
    }

}
