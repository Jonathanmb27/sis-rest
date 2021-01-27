package com.innova.config.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

@Configuration
public class TransactionalBDConfig implements TransactionManagementConfigurer {

    @Autowired
    DataSource dataSource;

   /* @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(){
        return new DataSourceTransactionManager(dataSource);
    }*/

    /*
    * general para cualquier tipo de proveedor de implementacion de tansacciones
    * */
    /*
    * @EnableTransactionManagement es más flexible; busca un bean de
    * cualquier tipo que implemente org.springframework.transaction.PlatformTransactionManager,
    * por lo que el nombre no es importante.
     * */
    @Bean
    public PlatformTransactionManager platformTransactionManager(){
        return new DataSourceTransactionManager(dataSource);
    }
    @Bean
    public PlatformTransactionManager platformTransactionManager2(){
        return new DataSourceTransactionManager(dataSource);
    }

    /*
    * Esto es útil, porque en aplicaciones más grandes que requieren más
    * de una fuente de datos, se deben declarar múltiples beans de
    * administrador de transacciones. Si no se especifica el uso
    * predeterminado, Spring no puede elegir por sí mismo, y la primera
    * vez que se ejecuta un método transaccional, la aplicación fallará
    * con una excepción fea y explícita.
    * */
    @Override
    public TransactionManager annotationDrivenTransactionManager() {
        return platformTransactionManager2();
    }
}
