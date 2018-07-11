package datamuse.constraints;

public class HomophoneConstraint extends AStringConstraint {

	public HomophoneConstraint(String word) {
		super("rel_hom",word);
	}

}
