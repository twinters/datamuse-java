package be.thomaswinters.datamuse.constraints;

/**
 * a Hypernym
 * @author Thomas Winters
 *
 */
public class KindOfConstraint extends AStringConstraint {

	public KindOfConstraint(String word) {
		super("rel_spc",word);
	}

}
