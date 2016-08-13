package be.thomaswinters.datamuse.constraints;

public class MoreGeneralThanConstraint extends AStringConstraint {

	public MoreGeneralThanConstraint(String word) {
		super("rel_gen",word);
	}

}
