package calculator.api.core.amqp;

import java.math.BigDecimal;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import calculator.api.core.dto.OperationDTO;
import calculator.api.core.model.Operator;
import calculator.api.core.service.ICalculatorService;

/**
 * @author Judiao Mbaua
 *
 */
@Component
public class CalculatorConsumer {

	@Autowired
	private ICalculatorService calculatorService;

	@RabbitListener(queues = "${calculator.api.amqp.queue}")
	public OperationDTO receiveMessage(OperationDTO operationDTO) throws IllegalAccessException {

			BigDecimal result = calculatorService.calculate(operationDTO.getVar1(), operationDTO.getVar2(),
					Operator.valueOf(operationDTO.getOperator().toUpperCase()));
			
			OperationDTO newOperationDTO=new OperationDTO(operationDTO.getVar1(),
					operationDTO.getVar2(), 
					operationDTO.getOperator());
			newOperationDTO.setResult(result);
			
			return newOperationDTO;
		
	}
}
