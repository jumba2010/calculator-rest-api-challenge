package calculator.api.core.amqp;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <b>Classe de Configuracao</b> do AMQP para a comunicacao assincrona
 * @author Judiao Mbaua
 *
 */
@Configuration
public class CalculatorAMQPConfiguration {

	@Value("${calculator.api.amqp.routing.key}")
	private String routingKey;

	@Value("${calculator.api.amqp.queue}")
	private String queue;

	@Value("${calculator.api.amqp.exchange}")
	private String exchangeName;

	@Value("${spring.rabbitmq.username}")
	private String username;

	@Value("${spring.rabbitmq.password}")
	private String password;

	@Bean
	public DirectExchange direct() {
		return new DirectExchange(exchangeName);
	}

	@Bean
	public Queue queue() {
		return new Queue(queue, false);
	}
	
	@Bean
	public Binding binding( Queue queue, DirectExchange exchange){
		return BindingBuilder.bind(queue).to(exchange).with(routingKey);
	}

	@Bean
	  public MessageConverter jackson2MessageConverter() {
	    return new Jackson2JsonMessageConverter();
	  }

	  @Bean
	  public ConnectionFactory connectionFactory() {
		  CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		  connectionFactory.setUsername(username);
		  connectionFactory.setPassword(password);
		  return connectionFactory;
	  }
}
