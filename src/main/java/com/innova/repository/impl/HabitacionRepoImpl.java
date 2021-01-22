package com.innova.repository.impl;

import com.innova.domain.Habitacion;
import com.innova.repository.HabitacionRepo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HabitacionRepoImpl extends AbstractRepoImpl<Habitacion> implements HabitacionRepo {

        public HabitacionRepoImpl(JdbcTemplate jdbcTemplate){
            super(jdbcTemplate);
        }

        @Override
        public void save(Habitacion entity){
            //try{
                String query="insert into habitacion(id,FECHA_INGRESO, NOMBRE, PRECIO) values(?,?,?,?)";
                jdbcTemplate.update(query,entity.getId(),
                        entity.getFechaIngreso(),
                        entity.getNombreHabitacion(),
                        entity.getPrecioHabitacion());
            //}catch (Exception e){
            //    System.out.println("erro impl");
            //}

        }
}
