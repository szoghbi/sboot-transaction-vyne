package br.com.vyne.application.config;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.spi.JdbiPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class DatabaseConfiguration {

    @Bean
    public Jdbi jdbi(DataSource dataSource, List<JdbiPlugin> plugins, List<RowMapper<?>> rowMappers) {
    	TransactionAwareDataSourceProxy proxy = new TransactionAwareDataSourceProxy( dataSource );
    	Jdbi jdbi = Jdbi.create( proxy );
    	plugins.forEach( jdbiPlugin -> jdbi.installPlugin( jdbiPlugin ) );
    	rowMappers.forEach( rowMapper -> jdbi.registerRowMapper( rowMapper ) );
    	return jdbi;
    }

    @Bean
    public JdbiPlugin sqlObjectPlugin() {
    	return new SqlObjectPlugin();
    }
}