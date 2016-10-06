package tr.biz.vardar;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        System.out.println("ServletInitializer");
		return application.sources(CustomTableApplication.class);
	}

}
