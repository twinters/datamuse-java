package be.thomaswinters.datamuse.constraints;

/**
 * Limit the amount of results
 * @author Thomas Winters
 */
public class MaximumNumberConstraint extends AIntegerConstraint {
	public MaximumNumberConstraint(int number) {
		super("max", number);
	}
}
