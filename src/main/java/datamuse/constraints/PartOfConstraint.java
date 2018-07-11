package datamuse.constraints;

/**
 * The resulting words are a part of the given word: meronym
 * @author Thomas Winters
 */
public class PartOfConstraint extends AStringConstraint {

	public PartOfConstraint(String word) {
		super("rel_par",word);
	}

}
