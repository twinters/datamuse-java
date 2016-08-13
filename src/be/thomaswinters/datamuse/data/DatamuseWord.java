package be.thomaswinters.datamuse.data;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableList;

public class DatamuseWord {
	private final String word;
	private final Optional<Integer> score;
	private final Optional<Integer> numberOfSyllables;
	private final Optional<ImmutableList<String>> tags;

	/*-********************************************-*
	 *  Constructor
	 *-********************************************-*/
	public DatamuseWord(String word, Optional<Integer> score, Optional<Integer> numberOfSyllables,
			Optional<? extends Collection<String>> tags) {
		super();
		this.word = word;
		this.score = score;
		this.numberOfSyllables = numberOfSyllables;
		this.tags = tags.isPresent() ? Optional.of(ImmutableList.copyOf(tags.get()))
				: Optional.empty();
	}
	/*-********************************************-*/

	/*-********************************************-*
	 *  Getters
	 *-********************************************-*/
	public String getWord() {
		return word;
	}

	public Optional<Integer> getScore() {
		return score;
	}

	public Optional<Integer> getNumberOfSyllables() {
		return numberOfSyllables;
	}

	public Optional<ImmutableList<String>> getTags() {
		return tags;
	}

	/*-********************************************-*/

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		builder.append("\"word\":\"" + word);
		if (score.isPresent()) {
			builder.append(",\"score\":\"" + score.get());
		}
		if (numberOfSyllables.isPresent()) {
			builder.append(",\"numSyllables\":\"" + numberOfSyllables.get());
		}
		if (tags.isPresent()) {
			builder.append(",\"tags\":["
					+ tags.get().stream().map(e -> "\"" + e + "\"").collect(Collectors.joining(",")) + "]");
		}
		builder.append("}");

		return builder.toString();
	}

	/*-********************************************-*
	 *  Hashcode & Equals
	 *-********************************************-*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numberOfSyllables == null) ? 0 : numberOfSyllables.hashCode());
		result = prime * result + ((score == null) ? 0 : score.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DatamuseWord other = (DatamuseWord) obj;
		if (numberOfSyllables == null) {
			if (other.numberOfSyllables != null)
				return false;
		} else if (!numberOfSyllables.equals(other.numberOfSyllables))
			return false;
		if (score == null) {
			if (other.score != null)
				return false;
		} else if (!score.equals(other.score))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}
	/*-********************************************-*/

}
