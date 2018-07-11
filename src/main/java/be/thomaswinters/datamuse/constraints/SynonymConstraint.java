package be.thomaswinters.datamuse.constraints;

public class SynonymConstraint extends AStringConstraint {

	public SynonymConstraint(String word) {
		super("rel_syn",word);
	}

}
