package calculator.api.rest.exception;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
/**
 * Classe Global para tratamento de erros na api
 * @author Judiao Mbaua
 *
 */
@RestControllerAdvice
@Configuration
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ExceptionResponseDTO> handleInvalidArgumentException(BusinessException ex, WebRequest request) {
        String errorMessage = ex.getMessage();
        ExceptionResponseDTO exceptionResponseDTO=ExceptionResponseDTO.build().setTitle("Erro de Validacao").addDetail(errorMessage);
        return new ResponseEntity<ExceptionResponseDTO>(exceptionResponseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidOperatorException.class)
    public ResponseEntity<ExceptionResponseDTO> handleInvalidOperatorException(InvalidOperatorException ex, WebRequest request) {
        String errorMessage = ex.getMessage();
        ExceptionResponseDTO exceptionResponseDTO=ExceptionResponseDTO.build().setTitle("Operador Invalido").addDetail(errorMessage);
        return new ResponseEntity<ExceptionResponseDTO>(exceptionResponseDTO, HttpStatus.BAD_REQUEST);
    }
}
