package be.thomaswinters.datamuse.constraints;

public class ConsonantMatchConstraint extends AStringConstraint {

	public ConsonantMatchConstraint(String word) {
		super("rel_cns",word);
	}

}
