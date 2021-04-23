package calculator.api.rest.controller;

import java.util.concurrent.ExecutionException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import calculator.api.rest.dto.OperationDTO;
import calculator.api.rest.service.IAMQPSenderService;
/**
 * @author Judiao Mbaua
 *
 */
@RestController("api/calculators")
public class CalculatorRestController {

	@Autowired
	private IAMQPSenderService amqpSenderService;

	@PostMapping
	public ResponseEntity<?> calculateNumbers(@Valid @RequestBody OperationDTO operation, BindingResult result) {

		if (result.hasErrors()) {
			return new ResponseEntity<>(
					"", 
				      HttpStatus.BAD_REQUEST);
		}
		
		try {
			OperationDTO resp=amqpSenderService.sendAndReceiveResponse(operation);
			return new ResponseEntity<>(
					resp, 
				      HttpStatus.OK);
			
		}catch (InterruptedException |ExecutionException e) {
			return new ResponseEntity<>(
					"", 
				      HttpStatus.BAD_REQUEST);
		} 
	}
}
