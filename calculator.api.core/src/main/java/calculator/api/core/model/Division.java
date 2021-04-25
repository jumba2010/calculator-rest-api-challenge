
package calculator.api.core.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 * Classe responsavel por toda a logica de divisao
 * @author Judiao Mbaua
 *
 */
public class Division
	implements Operation
{

	@Override
	public BigDecimal apply(final BigDecimal var1, final BigDecimal var2)
	{
		return var1.divide(var2, 2, RoundingMode.HALF_UP);
	}

}
