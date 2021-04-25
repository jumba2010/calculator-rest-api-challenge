package calculator.api.rest.service;

import java.util.concurrent.ExecutionException;

import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import calculator.api.core.dto.OperationDTO;

/**
 * Classe responsavel pelo envio das mensagens ao rabbitMq
 * 
 * @author Judiao Mbaua
 *
 */
@Service(IAMQPSenderService.NAME)
public class AMQPSenderServiceImpl implements IAMQPSenderService {

	@Autowired
	private AsyncRabbitTemplate asyncRabbitTemplate;

	@Value("${calculator.api.amqp.routing.key}")
	private String routingKey;

	@Value("${calculator.api.amqp.exchange}")
	private String exchange;

	@Override
	public OperationDTO sendAndReceiveResponse(final OperationDTO operation)
			throws InterruptedException, ExecutionException {

		return asyncRabbitTemplate.convertSendAndReceiveAsType(exchange, routingKey, operation,
				new ParameterizedTypeReference<OperationDTO>() {
				}).get();
	}

}
