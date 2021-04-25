
package calculator.api.core.model;

import java.math.BigDecimal;
/**
 * 
 * @author Judiao Mbaua
 *
 */
public interface Operation
{
	public abstract BigDecimal apply(BigDecimal var1, BigDecimal var2);
}