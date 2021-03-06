package calculator.api.core.calculator.api.core;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import calculator.api.core.model.Operator;
import calculator.api.core.service.ICalculatorService;
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CalculatorServiceTest {
	@Autowired
	private ICalculatorService calculatorService;
	
	@Test
	public void testFailOperation() throws IllegalAccessException {
		BigDecimal var1=new BigDecimal(34.05);
		BigDecimal var2=new BigDecimal(16.05);
		Assertions.assertThrows(IllegalArgumentException.class,()->calculatorService.calculate(var1, var2, Operator.valueOf("ADDS")));
	}
	
	@Test
	public void testAdd() throws IllegalAccessException {
		BigDecimal var1=new BigDecimal(34);
		BigDecimal var2=new BigDecimal(16);
		
		BigDecimal result=calculatorService.calculate(var1, var2, Operator.valueOf("ADD"));
		Assertions.assertEquals(50.0, result.doubleValue());
	}
	
	@Test
	public void testSubtract() throws IllegalAccessException {
		BigDecimal var1=new BigDecimal(30);
		BigDecimal var2=new BigDecimal(16);
		
		BigDecimal result=calculatorService.calculate(var1, var2,Operator.valueOf("SUBTRACT"));
		Assertions.assertEquals(14.0, result.doubleValue());
	}
	
	@Test
	public void testMultiply() throws IllegalAccessException {
		BigDecimal var1=new BigDecimal(2);
		BigDecimal var2=new BigDecimal(5);
		
		BigDecimal result=calculatorService.calculate(var1, var2, Operator.valueOf("MULTIPLY"));
		Assertions.assertEquals(10.0, result.doubleValue());
	}
	
	@Test
	public void testDevide() throws IllegalAccessException {
		BigDecimal var1=new BigDecimal(50);
		BigDecimal var2=new BigDecimal(5);
		
		BigDecimal result=calculatorService.calculate(var1, var2,Operator.valueOf("DEVIDE"));
		Assertions.assertEquals(10.0, result.doubleValue());
	}

}
