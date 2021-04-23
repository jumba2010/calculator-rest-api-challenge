package calculator.api.rest.service;

import java.util.concurrent.ExecutionException;

import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import calculator.api.rest.dto.OperationDTO;
/**
 * @author Judiao Mbaua
 *
 */
@Service(IAMQPSenderService.NAME)
public class AMQPSenderServiceImpl implements IAMQPSenderService {

	private AsyncRabbitTemplate  asyncRabbitTemplate;

	@Override
	public OperationDTO sendAndReceiveResponse(final OperationDTO operation) throws InterruptedException, ExecutionException {

		return asyncRabbitTemplate.convertSendAndReceiveAsType("${calculator.api.amqp.exchange}",
				"${calculator.api.amqp.routing.key}",
				operation, 
				new ParameterizedTypeReference<OperationDTO>() {
		}).get();
	}

}
