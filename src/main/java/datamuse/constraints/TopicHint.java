package datamuse.constraints;

import java.util.Arrays;
import java.util.Collection;
/**
 * Constrain the result to have some relevant topics
 * @author Thomas Winters
 */
public class TopicHint extends AListStringConstraint {

	public TopicHint(Collection<? extends String> words) {
		super("topics", words);
	}

	public TopicHint(String... words) {
		this(Arrays.asList(words));
	}
}
