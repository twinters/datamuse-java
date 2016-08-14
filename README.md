# Datamuse-Java
A Java interface to the Datamuse API, written by Thomas Winters

## Requirements

You need to use Maven in order to get this project to compile. This library requires GSON and Guava, which should be automatically downloaded when using Maven.

## Example usage

DatamuseCaller caller = new DatamuseCaller();
DatamuseQuery query = (new DatamuseQuery())
        .relatedAdjectiveFor("water")
        .withinTopicHint("ocean","temperature")
        .startingWith("s");

List<DatamuseWord> words = caller.call(query);