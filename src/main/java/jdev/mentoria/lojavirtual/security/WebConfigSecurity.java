package jdev.mentoria.lojavirtual.security;

import javax.servlet.http.HttpSessionListener;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebConfigSecurity extends WebSecurityConfigurerAdapter implements HttpSessionListener {

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.GET, 
				"/salvarAcesso", 
				"/deleteAcesso", 
				"/deleteAcessoPorId/", 
				"/obterAcesso/**", 
				"/buscarPorDesc/**")
		
				.antMatchers(HttpMethod.POST, 
						"/salvarAcesso", 
						"/deleteAcesso", 
						"/deleteAcessoPorId/", 
						"/obterAcesso/**")
				
				.antMatchers(HttpMethod.DELETE, 
						"/deleteAcessoPorId/");
		
		/* Ingnorando URL no momento para nao autenticar */
	}

}
