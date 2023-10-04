package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Reserve;

public class DaoReserve {

    private Connection connection;

    public DaoReserve(Connection connexion) {
        this.connection = connexion;
    }

    public void save(Reserve reserve) {

        try {

            String sql = "Insert into reserve (nameI, lastname, age, telephone, country, admisionDate, exitDate, valueI, payWay) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                statement.setString(1, reserve.getNameI());
                statement.setString(2, reserve.getLastname());
                statement.setInt(3, reserve.getAge());
                statement.setLong(4, reserve.getTelephone());
                statement.setString(5, reserve.getCountry());
                statement.setDate(6, reserve.getAdmisionDate());
                statement.setDate(7, reserve.getExitDate());
                statement.setString(8, reserve.getValueI());
                statement.setString(9, reserve.getPayWay());

                statement.executeUpdate();

                try (ResultSet resultSet = statement.getGeneratedKeys()) {
                    while (resultSet.next()) {
                        reserve.setId(resultSet.getInt(1));
                    }
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Reserve> listar() {
        List<Reserve> reservas = new ArrayList<>();

        try {

            String sql = "Select id, nameI, lastname, age, telephone, country, admisionDate, exitDate, valueI, payWay from reserve";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.execute();

                transformar(reservas, statement);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return reservas;
    }

    public List<Reserve> listarId(Integer id) {
        List<Reserve> reservas = new ArrayList<>();

        try {

            String sql = "Select id, nameI, lastname, age, telephone, country, admisionDate, exitDate, valueI, payWay from reserve where id=?";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                statement.execute();

                transformar(reservas, statement);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return reservas;
    }

    public void transformar(List<Reserve> reservas, PreparedStatement statement) throws SQLException {
        try (ResultSet resultSet = statement.getResultSet()) {

            while (resultSet.next()) {
                Reserve datos = new Reserve(resultSet.getInt("id"),
                        resultSet.getString("nameI"),
                        resultSet.getString("lastname"),
                        resultSet.getInt("age"),
                        resultSet.getLong("telephone"),
                        resultSet.getString("country"),
                        resultSet.getDate("admisionDate"),
                        resultSet.getDate("exitDate"),
                        resultSet.getString("valueI"),
                        resultSet.getString("payWay"));

                reservas.add(datos);
            }
        }
    }

    public void actualizar(String name, String lastname, Integer age, Long telephone, String country, Date admisionDate,
                           Date exitDate, String valueI, String payWay, Integer id) {

        try {
            String sql = "update reserve set nameI=?, lastname=?, age=?, telephone=?, country=?, admisionDate=?,"
                    + "exitDate=?, valueI=?, payWay=? where id=?";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, name);
                statement.setString(2, lastname);
                statement.setInt(3, age);
                statement.setLong(4, telephone);
                statement.setString(5, country);
                statement.setDate(6, admisionDate);
                statement.setDate(7, exitDate);
                statement.setString(8, valueI);
                statement.setString(9, payWay);
                statement.setInt(10, id);

                statement.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void eliminar(Integer id) {

        String sql = "delete from reserve where id=?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            statement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}