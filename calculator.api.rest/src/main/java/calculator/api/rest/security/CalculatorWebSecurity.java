package calculator.api.rest.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
/**
 * Classe responsavel pela seguranca das rotas. Para efeitos de testes estamos a permitir todas
 * 
 * @author Judiao Mbaua
 *
 */
@Configuration
public class CalculatorWebSecurity extends WebSecurityConfigurerAdapter {

protected void configure(HttpSecurity http) throws Exception{
    http.authorizeRequests().antMatchers("/api/**").permitAll().and().csrf().disable();
}
    
}
