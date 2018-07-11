# Datamuse-Java
A Java interface to the Datamuse API, written by Thomas Winters

## Requirements

You need to use [Gradle](https://gradle.org/) in order to get this project to compile, as it automatically downloads the required dependencies.
This tool is usually already installed when using  [IntellIJ](https://www.jetbrains.com/idea/).

## Example usage
```
DatamuseCaller caller = new DatamuseCaller();
DatamuseQuery query = (new DatamuseQuery())
        .relatedAdjectiveFor("water")
        .withinTopicHint("ocean","temperature")
        .startingWith("s");
List<DatamuseWord> words = caller.call(query);
```
