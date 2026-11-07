package in.strikes.crud_project_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;


// as we are using the jpa and mysql connector dependencies then due to the @EnableAutoConfiguration all the required beans which is needed got up and as they don't get any db url to connect so it returns error.
@SpringBootApplication()
public class CrudProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(CrudProject1Application.class, args);
		System.out.print("Hyy");




	}


}
