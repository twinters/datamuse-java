package datamuse.constraints;

abstract class AStringConstraint implements IDatamuseConstraint {
	private final String code;
	private final String word;

	public AStringConstraint(String code, String word) {
		this.code = code;
		this.word = word;
	}

	public String getWord() {
		return word;
	}
	
	public String getArgumentWord() {
		return word.replaceAll(" ", "+");
	}
	
	@Override
	public String toArgument() {
		return code+"="+getArgumentWord();
	}

}
