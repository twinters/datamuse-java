package be.thomaswinters.datamuse.constraints;

public class FrequentlyAfterConstraint extends AStringConstraint {

	public FrequentlyAfterConstraint(String word) {
		super("rel_bga",word);
	}

}
