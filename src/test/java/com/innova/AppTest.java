package com.innova;

import static org.junit.Assert.assertNotNull;


import com.innova.config.template.JdbcTemplateConfig;
import com.innova.config.template.TestDBConfig;
import com.innova.repository.InquilinoRepo;
import com.innova.repository.TrabajoRepo;
import com.innova.service.HabitacionService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = JdbcTemplateConfig.class)
//@ActiveProfiles("jdbc")
public class AppTest {



    @Autowired
    HabitacionService habitacionService;

    @Before
    public void setUp(){
        assertNotNull(habitacionService);

    }
    @Test
    public void verificarNotNull(){
        habitacionService.findAll().forEach(s-> System.out.println(s.getPrecioHabitacion()));
    }

}
