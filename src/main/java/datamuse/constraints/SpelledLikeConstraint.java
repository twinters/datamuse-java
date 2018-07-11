package datamuse.constraints;

/**
 * Class for making constraints like a*, *b, a*b, a??b etc. See
 * http://www.onelook.com/?c=faq#patterns for more info
 * 
 * @author Thomas Winters
 */
public class SpelledLikeConstraint extends AStringConstraint {

	/**
	 * Specify how what a word is spelled like.
	 * 
	 * @param spellingRestriction
	 *            Specify using the following syntax: * : Any amount of any
	 *            characters on this position ? : One character, doesn't matter
	 *            which one, but only one on this exact position # : Matches a
	 *            consonant @ : Matches a vowel Any letter : This letter must be
	 * on this position.
	 */
	public SpelledLikeConstraint(String spellingRestriction) {
		super("sp", spellingRestriction);
	}

	public static SpelledLikeConstraint createMaxCharactersConstraint(int amount) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < amount; i++) {
			builder.append("$");
		}
		return new SpelledLikeConstraint(builder.toString());
	}

	public static IDatamuseConstraint createStartingWith(String string) {
		return new SpelledLikeConstraint(string+"*");
	}

	public static IDatamuseConstraint createEndingWith(String string) {
		return new SpelledLikeConstraint("*"+string);
	}

}
