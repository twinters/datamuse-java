package datamuse.comparators;

import java.util.Comparator;

import datamuse.data.DatamuseWord;

public class AscendingDatamuseScoreComparator implements Comparator<DatamuseWord> {

	@Override
	public int compare(DatamuseWord o1, DatamuseWord o2) {
		if (o1.getScore().isPresent() && o2.getScore().isPresent()) {
			return o1.getScore().get() - o2.getScore().get();			
		}
		return 0;
	}

}
