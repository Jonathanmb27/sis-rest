package com.innova.rest;

import com.innova.config.template.JdbcTemplateConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = JdbcTemplateConfig.class)
@ActiveProfiles("jdbc")
public class AppRest {


}
