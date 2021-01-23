package com.innova.repository.impl;

import com.innova.domain.Habitacion;
import com.innova.repository.HabitacionRepo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class HabitacionRepoImpl extends AbstractRepoImpl<Habitacion> implements HabitacionRepo {

    private RowMapper<Habitacion> rowMapper = new HabitacionRowMapper();

    public HabitacionRepoImpl(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public void save(Habitacion entity) {
        String query = "insert into habitacion(id,FECHA_INGRESO, NOMBRE, PRECIO) values(?,?,?,?)";
        jdbcTemplate.update(query, entity.getId(),
                entity.getFechaIngreso(),
                entity.getNombreHabitacion(),
                entity.getPrecioHabitacion());
    }

    @Override
    public List<Habitacion> findAll() {
        String query = "select id,FECHA_INGRESO, NOMBRE, PRECIO from habitacion";
        return jdbcTemplate.query(query, rowMapper);
    }

    @Override
    public Optional<Habitacion> update(Habitacion entity) {
        try {
            String query = "update habitacion set FECHA_INGRESO = ?, NOMBRE = ?, PRECIO = ? where ID = ?";
            jdbcTemplate.update(query,
                    entity.getFechaIngreso(),
                    entity.getNombreHabitacion(),
                    entity.getPrecioHabitacion(),
                    entity.getId());
            return Optional.of(entity);
        } catch (Exception e) {
            return Optional.empty();
        }



    }

    @Override
    public int deleteById(Long entityId) {
        String query = "delete from Habitacion where id=?";
        return jdbcTemplate.update(query, entityId);

    }

    @Override
    public Optional<Habitacion> findById(Long entityId) {
        String query = "select id,FECHA_INGRESO, NOMBRE, PRECIO from habitacion where id=?";
        try {
            return Optional.of(jdbcTemplate.queryForObject(query, rowMapper, entityId));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    private class HabitacionRowMapper implements RowMapper<Habitacion> {

        @Override
        public Habitacion mapRow(ResultSet resultSet, int i) throws SQLException {

            Habitacion habitacion = new Habitacion();
            habitacion.setId(resultSet.getLong("ID"));
            habitacion.setNombreHabitacion(resultSet.getString("NOMBRE"));
            habitacion.setPrecioHabitacion(resultSet.getInt("PRECIO"));
            habitacion.setFechaIngreso(resultSet.getTimestamp("FECHA_INGRESO").toLocalDateTime().toLocalDate());
            return habitacion;
        }
    }
}
