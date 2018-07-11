package datamuse.constraints;

/**
 * The resulting words are a part of the given word: Holonym
 * @author Thomas Winters
 */
public class ComprisesConstraint extends AStringConstraint {

	public ComprisesConstraint(String word) {
		super("rel_com",word);
	}

}
