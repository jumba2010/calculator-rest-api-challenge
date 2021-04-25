package calculator.api.rest.exception;

import java.util.List;
import java.util.ArrayList;

/**
 * Classe responsavel por fornecer uma mensagem de erro ao utilizador de uma
 * forma mais elegante
 * 
 * @author Judiao Mbaua
 *
 */
public class ExceptionResponseDTO {

    private String title;

    private List<String> details = new ArrayList<String>();

    private ExceptionResponseDTO() {
        super();
    }

    public static ExceptionResponseDTO build() {
        return new ExceptionResponseDTO();
    }

    public ExceptionResponseDTO setTitle(final String title) {
        this.title = title;
        return this;
    }

    public ExceptionResponseDTO addDetail(final String detail) {
        details.add(detail);
        return this;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getDetails() {
        return details;
    }

}
