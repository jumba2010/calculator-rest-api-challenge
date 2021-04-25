package calculator.api.rest.controller;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import calculator.api.core.dto.OperationDTO;
import calculator.api.rest.exception.BusinessException;
import calculator.api.rest.exception.InvalidOperatorException;
import calculator.api.rest.service.IAMQPSenderService;

/**
 * @author Judiao Mbaua
 *
 */
@RestController
@RequestMapping("/api/calculators")
public class CalculatorRestController {

	@Autowired
	private IAMQPSenderService amqpSenderService;
	private static final String[]operators=new String[]{"add","subtract","multiply","devide"};

	@PostMapping
	public ResponseEntity<?> calculateNumbers(@Valid @RequestBody OperationDTO operation, BindingResult result) {

		if (result.hasErrors()) {
			throw new BusinessException(result.getAllErrors().get(0).getDefaultMessage());
		}

		if (Arrays.stream(operators).noneMatch(op->op.equals(operation.getOperator()))) {
			throw new InvalidOperatorException("O operador informado é invalido");
		}
		try {

			return ResponseEntity.ok(amqpSenderService.sendAndReceiveResponse(operation));

		} catch (InterruptedException | ExecutionException e) {
			return new ResponseEntity<>("O Servidor está temporariamente inacessível", HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
}
