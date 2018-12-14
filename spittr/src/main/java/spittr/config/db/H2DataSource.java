package spittr.config.db;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class H2DataSource {

	@Bean
	public DataSource dataSource() {
		 return new  EmbeddedDatabaseBuilder()
		 .setType(EmbeddedDatabaseType.H2)
		 .addScript("classpath:spittr/db/jdbc/schema.sql")
		 .addScript("classpath:spittr/db/jdbc/insert-data.sql")
		 .setName("spittrdb")
		 .build();
	}
	
	// Start WebServer, access http://localhost:8082 with connection jdbc:h2:mem:spittrdb
	@Bean(initMethod = "start", destroyMethod = "stop")
	public Server startDBManager() throws SQLException {
		return Server.createWebServer();
	}
}
