
package calculator.api.core.model;

import java.math.BigDecimal;
/**
 * @author Judiao Mbaua
 *
 */
public class Multiplication
	implements Operation
{

	@Override
	public BigDecimal apply(final BigDecimal var1, final BigDecimal var2)
	{
		return var1.multiply(var2);
	}

}
