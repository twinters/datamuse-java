package datamuse.constraints;

/**
 * Hint which words appear to the left of the target word in a sentence
 * @author Thomas Winters
 */
public class LeftContextHint extends AStringConstraint {

	public LeftContextHint(String word) {
		super("lc", word);
	}

}
