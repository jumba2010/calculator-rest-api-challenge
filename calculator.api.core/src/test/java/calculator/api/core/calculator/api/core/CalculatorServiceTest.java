package calculator.api.core.calculator.api.core;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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
		
		BigDecimal result=calculatorService.calculate(var1, var2, "add");
		Assertions.assertEquals(50.10, result.doubleValue());
	}
	
	@Test
	public void testAdd() throws IllegalAccessException {
		BigDecimal var1=new BigDecimal(34.05);
		BigDecimal var2=new BigDecimal(16.05);
		
		BigDecimal result=calculatorService.calculate(var1, var2, "add");
		Assertions.assertEquals(50.10, result.doubleValue());
	}
	
	@Test
	public void testSubtract() throws IllegalAccessException {
		BigDecimal var1=new BigDecimal(34.05);
		BigDecimal var2=new BigDecimal(16.05);
		
		BigDecimal result=calculatorService.calculate(var1, var2, "subtract");
		Assertions.assertEquals(50.1, result.doubleValue());
	}
	
	@Test
	public void testMultiply() throws IllegalAccessException {
		BigDecimal var1=new BigDecimal(2);
		BigDecimal var2=new BigDecimal(5);
		
		BigDecimal result=calculatorService.calculate(var1, var2, "multiply");
		Assertions.assertEquals(10.0, result.doubleValue());
	}
	
	
	@Test
	public void testDevide() throws IllegalAccessException {
		BigDecimal var1=new BigDecimal(50);
		BigDecimal var2=new BigDecimal(5);
		
		BigDecimal result=calculatorService.calculate(var1, var2, "devide");
		Assertions.assertEquals(10.0, result.doubleValue());
	}

}
