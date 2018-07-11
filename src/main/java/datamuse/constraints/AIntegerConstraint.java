package datamuse.constraints;

abstract class AIntegerConstraint implements IDatamuseConstraint {
	private final String code;
	private final int number;

	public AIntegerConstraint(String code, int number) {
		this.code = code;
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
	
	@Override
	public String toArgument() {
		return code+"="+number;
	}
}
