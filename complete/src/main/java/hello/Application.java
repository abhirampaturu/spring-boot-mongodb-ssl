package hello;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoIterable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	MongoClient mongo;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		MongoIterable<String> strings = mongo.listDatabaseNames();
		for (String str:strings) {
			System.out.println(str);
		}
		System.out.println("databaseList --------" + strings);
	}

}
