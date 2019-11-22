//package io.turntable.projectwebservice.configurations;
//
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//import java.net.URI;
//import java.net.URISyntaxException;
//
//@Configuration
//public class DatabaseConfig {
//
//    @Bean
//    public DataSource postgresDataSource() {
//        String databaseUrl = System.getenv("DATABASE_URL");
//
//        URI dbUri;      // parent scope access
//        try {
//            dbUri = new URI(databaseUrl);
//        } catch (URISyntaxException uriEx) {
//            System.out.println(uriEx.getMessage());
//            return null;
//        }
//
//        String username = dbUri.getUserInfo().split(":")[0];
//        String password = dbUri.getUserInfo().split(":")[1];
//        String dbUrl = "jdbc:postgresql://" +
//                dbUri.getHost() + ':' +
//                dbUri.getPort() +
//                dbUri.getPath();
//
//        DataSource dataSource = DataSourceBuilder
//                .create()
//                .driverClassName("org.postgresql.Driver")
//                .password(password)
//                .url(dbUrl)
//                .username(username)
//                .build();
//
//        return dataSource;
//    }
//
//}
