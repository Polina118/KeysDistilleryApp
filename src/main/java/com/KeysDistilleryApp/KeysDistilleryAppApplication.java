package com.KeysDistilleryApp;

import com.KeysDistilleryApp.Organization.OrgRepository;
import com.KeysDistilleryApp.Organization.Organization;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class KeysDistilleryAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeysDistilleryAppApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(OrgRepository repository) throws Exception {
		return args -> {

			Document document = Jsoup.connect("https://nablagoe.ru/rostovskaya-oblast").get();
			Elements titles = document.select("h2.entry-title");
			Elements links = document.select("a.post-thumbnail");
			Elements pics = document.select("img.attachment-post-thumbnail.size-post-thumbnail.wp-post-image");
			for (int i=0; i < titles.size(); i++){
//				System.out.println(titles.get(i).text() + " " +
//						links.get(i).attr("href") + " " +
//						pics.get(i).attr("src"));
				repository.save(new Organization(
						titles.get(i).text(),
						links.get(i).attr("href"),
						pics.get(i).attr("src")));
			}
		};
	}

}

