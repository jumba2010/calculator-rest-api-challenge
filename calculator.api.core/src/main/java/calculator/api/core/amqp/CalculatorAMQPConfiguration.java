package calculator.api.core.amqp;



import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
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

	@Value("{calculator.api.amqp.routing.key}")
	private String routingKey;

	@Value("{calculator.api.amqp.queue}")
	private String queue;

	@Value("{calculator.api.amqp.exchange}")
	private String exchangeName;

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
}
