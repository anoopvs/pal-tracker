package io.pivotal.pal.tracker;


import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PalTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PalTrackerApplication.class, args);
    }
    
   @Bean
    TimeEntryRepository timeEntryRepository(){
    	return new InMemoryTimeEntryRepository();
    }
   
   @Bean("jdbcRepo")
   JdbcTimeEntryRepository jdbcTimeEntryRepository(DataSource ds){
   	return new JdbcTimeEntryRepository(ds);
   }
}