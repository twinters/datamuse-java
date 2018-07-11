package datamuse.constraints;

/**
 * Hint which words appear to the right of the target word in a sentence
 * @author Thomas Winters
 */
public class RightContextHint extends AStringConstraint {

	public RightContextHint(String word) {
		super("rc", word);
	}

}
