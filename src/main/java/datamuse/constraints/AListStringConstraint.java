package datamuse.constraints;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableList;

abstract class AListStringConstraint implements IDatamuseConstraint {
	private final String code;
	private final ImmutableList<String> words;

	public AListStringConstraint(String code, Collection<? extends String> words) {
		this.code = code;
		this.words = ImmutableList.copyOf(words);
	}

	public List<String> getWords() {
		return words;
	}

	public String getArgumentWords() {
		return words.stream().map(e -> e.replaceAll(" ","+")).collect(Collectors.joining(","));
	}
	
	@Override
	public String toArgument() {
		return code+"="+getArgumentWords();
	}

}
