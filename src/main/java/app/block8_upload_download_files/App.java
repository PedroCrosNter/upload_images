package app.block8_upload_download_files;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
//		SpringApplication.run(App.class, args);

		String filePath = args.length > 0 ? args[0] : "C:/Users/pedro.cros/Desktop/saveFiles_default";
		SpringApplication.run(App.class, filePath);
	}
}
