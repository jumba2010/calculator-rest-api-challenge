package calculator.api.rest.service;

import java.util.concurrent.ExecutionException;

import calculator.api.rest.dto.OperationDTO;
/**
 * @author Judiao Mbaua
 *
 */
public interface IAMQPSenderService
{

public static final String NAME="calculator.api.rest.service.IAMQPSenderService";

public abstract OperationDTO sendAndReceiveResponse(final OperationDTO operation) throws InterruptedException, ExecutionException;

}
