package datamuse.connection;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Optional;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import datamuse.data.DatamuseWord;

/**
 * Custom GSON deserialisation for DatamuseWord objects from the JSON file the Datamuse API returns.
 *  
 * @author Thomas Winters
 */
public class DatamuseDeserializer implements JsonDeserializer<DatamuseWord> {

	private static final Gson GSON = new Gson();
	private static final Type STRING_COLLECTION_TYPE = new TypeToken<Collection<String>>() {}.getType();

	@Override
	public DatamuseWord deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		if (!json.isJsonObject()) {
			throw new IllegalArgumentException("Not a JSON object: " + json);
		}
		if (!typeOfT.equals(DatamuseWord.class)) {
			throw new IllegalArgumentException("Not the DatamuseWord type:" + typeOfT);
		}

		JsonObject object = json.getAsJsonObject();

		String word = object.get("word").getAsString();
		Optional<Integer> score = object.has("score")
				? Optional.of(object.get("score").getAsInt()) : Optional.empty();
		Optional<Integer> numberOfSyllables = object.has("numSyllables")
				? Optional.of(object.get("numSyllables").getAsInt()) : Optional.empty();
		Optional<Collection<String>> tags = object.has("tags")
				? Optional.of(GSON.fromJson(object.get("tags"), STRING_COLLECTION_TYPE)) : Optional.empty();

		return new DatamuseWord(word, score, numberOfSyllables, tags);
	}

}
