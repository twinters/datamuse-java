package be.thomaswinters.datamuse.comparators;

import java.util.Comparator;

import be.thomaswinters.datamuse.data.DatamuseWord;

public class DescendingDatamuseScoreComparator implements Comparator<DatamuseWord> {

	@Override
	public int compare(DatamuseWord o1, DatamuseWord o2) {
		if (o1.getScore().isPresent() && o2.getScore().isPresent()) {
			return o2.getScore().get() - o1.getScore().get();			
		}
		return 0;
	}


}
