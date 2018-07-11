package be.thomaswinters.datamuse.constraints;

public class AntonymConstraint extends AStringConstraint {

	public AntonymConstraint(String word) {
		super("rel_ant",word);
	}

}
