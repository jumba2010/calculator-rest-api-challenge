package calculator.api.core.model;

public enum Operator {
ADD("add"),SUBTRACT("subtract"),MULTIPLY("multiply"),DEVIDE("devide");
	
private final String operation;

private Operator(String operation){
		this.operation=operation;
	}

public String getOperation(){
	return this.operation;
}
}
