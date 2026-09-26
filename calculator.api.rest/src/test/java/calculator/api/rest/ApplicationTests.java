package calculator.api.rest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import calculator.api.core.dto.OperationDTO;
import calculator.api.rest.service.IAMQPSenderService;

/**
 * Web-layer tests for the REST edge service. The AMQP sender is mocked, so the tests
 * need neither a RabbitMQ broker nor the core service to be running.
 */
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private IAMQPSenderService amqpSenderService;

	@Test
	void returnsTheResultComputedByTheCoreService() throws Exception {
		when(amqpSenderService.sendAndReceiveResponse(any())).thenAnswer(invocation -> {
			OperationDTO request = invocation.getArgument(0);
			OperationDTO reply = new OperationDTO();
			reply.setVar1(request.getVar1());
			reply.setVar2(request.getVar2());
			reply.setOperator(request.getOperator());
			reply.setResult(request.getVar1().add(request.getVar2()));
			return reply;
		});

		calculate("{\"var1\":2,\"var2\":5,\"operator\":\"add\"}")
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.result").value(7));
	}

	@Test
	void rejectsUnknownOperatorWithoutPublishing() throws Exception {
		calculate("{\"var1\":2,\"var2\":5,\"operator\":\"pow\"}")
				.andExpect(status().isBadRequest());
		verify(amqpSenderService, never()).sendAndReceiveResponse(any());
	}

	@Test
	void rejectsMissingOperandWithoutPublishing() throws Exception {
		calculate("{\"var2\":5,\"operator\":\"add\"}")
				.andExpect(status().isBadRequest());
		verify(amqpSenderService, never()).sendAndReceiveResponse(any());
	}

	@Test
	void rejectsDivisionByZeroWithoutPublishing() throws Exception {
		calculate("{\"var1\":2,\"var2\":0,\"operator\":\"devide\"}")
				.andExpect(status().isBadRequest());
		verify(amqpSenderService, never()).sendAndReceiveResponse(any());
	}

	@Test
	void returnsServiceUnavailableWhenTheCoreServiceDoesNotReply() throws Exception {
		when(amqpSenderService.sendAndReceiveResponse(any()))
				.thenThrow(new ExecutionException(new IllegalStateException("broker unavailable")));

		calculate("{\"var1\":2,\"var2\":5,\"operator\":\"add\"}")
				.andExpect(status().isServiceUnavailable());
	}

	private ResultActions calculate(String json) throws Exception {
		return mockMvc.perform(post("/api/calculators").content(json).contentType(MediaType.APPLICATION_JSON));
	}
}
