package deTendresAnimaux.application;

import org.jboss.jandex.Main;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableWebMvc
@ComponentScan("deTendresAnimaux")
public class App {

	public static void main(String[] args) throws InterruptedException{
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
		Main applic = context.getBean(Main.class);
		applic.start();
		//context.close();

	}

}
