package com.innova.repository.impl;

import com.innova.domain.Cancelado;
import com.innova.repository.CanceladoRepo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CanceladoRepoImpl extends AbstractRepoImpl<Cancelado> implements CanceladoRepo {
//public class TrabajoRepoImpl  extends AbstractRepoImpl<Trabajo> implements TrabajoRepo
    private RowMapper<Cancelado> rowMapper=new CanceladoRowMapper();

    public CanceladoRepoImpl(JdbcTemplate jdbcTemplate){
        super(jdbcTemplate);
    }


    @Override
    public List<Cancelado> findAll() {
        try{
            String query="select id,fecha,monto,inquilino_id from cancelado";
            return jdbcTemplate.query(query,rowMapper);
        }catch (Exception e){
           return new ArrayList<>();
        }
    }
    private class CanceladoRowMapper implements RowMapper<Cancelado> {

        @Override
        public Cancelado mapRow(ResultSet resultSet, int i) throws SQLException {
            Cancelado cancelado=new Cancelado();
            cancelado.setId(resultSet.getLong("id"));
           // cancelado.setFechaCancelado(resultSet.getTimestamp("fecha").toLocalDateTime().toLocalDate());
            cancelado.setMontoCancelado(resultSet.getInt("monto"));
            cancelado.setInquilinoId(resultSet.getLong("inquilino_id"));
           // cancelado.set
            return cancelado;
        }
    }
}
