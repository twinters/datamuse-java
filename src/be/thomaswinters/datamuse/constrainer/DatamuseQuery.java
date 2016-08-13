package be.thomaswinters.datamuse.constrainer;

import java.util.Collection;

import com.google.common.collect.ImmutableList;

import be.thomaswinters.datamuse.constraints.AntonymConstraint;
import be.thomaswinters.datamuse.constraints.ApproximateRhymeConstraint;
import be.thomaswinters.datamuse.constraints.ComprisesConstraint;
import be.thomaswinters.datamuse.constraints.ConsonantMatchConstraint;
import be.thomaswinters.datamuse.constraints.FrequentlyAfterConstraint;
import be.thomaswinters.datamuse.constraints.FrequentlyBeforeConstraint;
import be.thomaswinters.datamuse.constraints.HomophoneConstraint;
import be.thomaswinters.datamuse.constraints.IDatamuseConstraint;
import be.thomaswinters.datamuse.constraints.KindOfConstraint;
import be.thomaswinters.datamuse.constraints.LeftContextHint;
import be.thomaswinters.datamuse.constraints.MaximumNumberConstraint;
import be.thomaswinters.datamuse.constraints.MeaningLikeConstraint;
import be.thomaswinters.datamuse.constraints.MoreGeneralThanConstraint;
import be.thomaswinters.datamuse.constraints.PartOfConstraint;
import be.thomaswinters.datamuse.constraints.PerfectRhymeConstraint;
import be.thomaswinters.datamuse.constraints.RelatedAdjectiveForNounConstraint;
import be.thomaswinters.datamuse.constraints.RelatedNounForAdjectiveConstraint;
import be.thomaswinters.datamuse.constraints.RightContextHint;
import be.thomaswinters.datamuse.constraints.SoundsLikeConstraint;
import be.thomaswinters.datamuse.constraints.SpelledLikeConstraint;
import be.thomaswinters.datamuse.constraints.SynonymConstraint;
import be.thomaswinters.datamuse.constraints.TopicHint;

/**
 * Use this immutable class to chain constraints together using a more intuitive
 * interface than just the dry constraints eg: (new
 * DatamuseConstrainer).spelledLike("a*").meansLike("duck").topic("temperature")
 * .max(10);
 * 
 * Please note: In order to create clean queries, every query is immutable. When
 * calling a method that adds a constraint, it will in fact create a new query.
 * 
 * @author Thomas Winters
 */
public class DatamuseQuery {
	private final ImmutableList<IDatamuseConstraint> constraints;

	/*-********************************************-*
	 *  Constructor
	 *-********************************************-*/
	private DatamuseQuery(ImmutableList<IDatamuseConstraint> constraints) {
		this.constraints = constraints;
	}

	public DatamuseQuery() {
		this(ImmutableList.of());
	}
	/*-********************************************-*/

	/*-********************************************-*
	 *  Getter
	 *-********************************************-*/
	public ImmutableList<IDatamuseConstraint> getConstraints() {
		return constraints;
	}
	/*-********************************************-*/

	/*-********************************************-*
	 *  Util
	 *-********************************************-*/
	private DatamuseQuery add(IDatamuseConstraint constraint) {
		return new DatamuseQuery(
				new ImmutableList.Builder<IDatamuseConstraint>().addAll(constraints).add(constraint).build());
	}
	/*-********************************************-*/

	/*-********************************************-*
	 *  All constraints
	 *-********************************************-*/
	public DatamuseQuery antonymOf(String string) {
		return add(new AntonymConstraint(string));
	}

	public DatamuseQuery approximatelyRhymesWith(String string) {
		return add(new ApproximateRhymeConstraint(string));
	}

	public DatamuseQuery comprises(String string) {
		return add(new ComprisesConstraint(string));
	}

	public DatamuseQuery matchesConsonantsOf(String string) {
		return add(new ConsonantMatchConstraint(string));
	}

	public DatamuseQuery frequentlyUsedAfter(String string) {
		return add(new FrequentlyAfterConstraint(string));
	}

	public DatamuseQuery frequentlyUsedBefore(String string) {
		return add(new FrequentlyBeforeConstraint(string));
	}

	public DatamuseQuery homophoneOf(String string) {
		return add(new HomophoneConstraint(string));
	}

	public DatamuseQuery kindOf(String string) {
		return add(new KindOfConstraint(string));
	}

	public DatamuseQuery hasLeftContext(String wordsToTheLeft) {
		return add(new LeftContextHint(wordsToTheLeft));
	}

	public DatamuseQuery hasRightContext(String wordsToTheRight) {
		return add(new RightContextHint(wordsToTheRight));
	}

	public DatamuseQuery maximumAnswers(int number) {
		return add(new MaximumNumberConstraint(number));
	}

	public DatamuseQuery meaningLike(String string) {
		return add(new MeaningLikeConstraint(string));
	}

	public DatamuseQuery moreGeneralThan(String string) {
		return add(new MoreGeneralThanConstraint(string));
	}

	public DatamuseQuery partOf(String string) {
		return add(new PartOfConstraint(string));
	}

	public DatamuseQuery perfectlyRhymes(String string) {
		return add(new PerfectRhymeConstraint(string));
	}

	public DatamuseQuery relatedAdjectiveFor(String noun) {
		return add(new RelatedAdjectiveForNounConstraint(noun));
	}

	public DatamuseQuery relatedNounFor(String adjective) {
		return add(new RelatedNounForAdjectiveConstraint(adjective));
	}

	public DatamuseQuery soundsLike(String string) {
		return add(new SoundsLikeConstraint(string));
	}

	public DatamuseQuery spelledLike(String string) {
		return add(new SpelledLikeConstraint(string));
	}

	public DatamuseQuery startingWith(String string) {
		return add(SpelledLikeConstraint.createStartingWith(string));
	}

	public DatamuseQuery endingWith(String string) {
		return add(SpelledLikeConstraint.createEndingWith(string));
	}

	public DatamuseQuery maxAmountOfCharacters(int number) {
		return add(SpelledLikeConstraint.createMaxCharactersConstraint(number));
	}

	public DatamuseQuery synonymFor(String string) {
		return add(new SynonymConstraint(string));
	}

	public DatamuseQuery withinTopicHint(String... topicHints) {
		return add(new TopicHint(topicHints));
	}

	public DatamuseQuery withinTopicHint(Collection<? extends String> topicHints) {
		return add(new TopicHint(topicHints));
	}

	/*-********************************************-*/

}
