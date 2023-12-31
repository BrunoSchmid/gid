package br.com.gid.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/trabalhos").setViewName("trabalhos");
		registry.addViewController("/trabalhosDet").setViewName("trabalhosDet");
		registry.addViewController("/clientes").setViewName("clientes");
		registry.addViewController("/produtos").setViewName("produtos");
	}
}