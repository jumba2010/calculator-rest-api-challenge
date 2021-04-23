package calculator.api.rest.amqp;



import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @author Judiao Mbaua
 *
 */
@Configuration
public class CalculatorAMQPConfiguration {

	@Value("${calculator.api.amqp.exchange}")
	private String exchangeName;

	@Bean
	public DirectExchange direct() {
		return new DirectExchange(exchangeName);
	}
	
	 @Bean
	  public AsyncRabbitTemplate asyncRabbitTemplate(
	               RabbitTemplate rabbitTemplate){
	    return new AsyncRabbitTemplate(rabbitTemplate);
	  }

	@Bean
	  public MessageConverter jackson2MessageConverter() {
	    return new Jackson2JsonMessageConverter();
	  }
}
