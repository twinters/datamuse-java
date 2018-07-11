package be.thomaswinters.datamuse.connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import be.thomaswinters.datamuse.constraints.IDatamuseConstraint;
import be.thomaswinters.datamuse.data.DatamuseWord;
import be.thomaswinters.datamuse.query.DatamuseQuery;

/**
 * This class can call  the datamuse api using a DatamuseQuery
 * @author Thomas Winters
 *
 */
public class DatamuseCaller {

	private static final String DATAMUS_API = "https://api.datamuse.com/words?";
	private static final Type DATAMUSWORD_COLLECTION_TYPE = new TypeToken<Collection<DatamuseWord>>() {
	}.getType();
	private static final Gson GSON;

	// Initialize GSON
	static {
		// Start building the gson parser
		GsonBuilder gsonBuilder = new GsonBuilder();
		// Register datamuse word deserializer
		gsonBuilder.registerTypeAdapter(DatamuseWord.class, new DatamuseDeserializer());
		// Create gson
		GSON = gsonBuilder.create();
	}

	/*-********************************************-*
	 *  Connect to Datamuse through HTTP
	 *-********************************************-*/
	
	public ImmutableList<DatamuseWord> call(DatamuseQuery constrainer) throws IOException {
		return call(constrainer.getConstraints());
	}

	public ImmutableList<DatamuseWord> call(Collection<? extends IDatamuseConstraint> constraints) throws IOException {
		return call(constraints.stream().map(e -> e.toArgument()).collect(Collectors.joining("&")));
	}

	public ImmutableList<DatamuseWord> call(String arguments) throws IOException {
		URL datamusRequest = new URL(DATAMUS_API + arguments);
		JsonElement root = getJSON(datamusRequest);
		ImmutableList<DatamuseWord> result = convertJSONtoDatamus(root);

		return result;
	}

	private JsonElement getJSON(URL url) throws IOException {
		HttpURLConnection request = (HttpURLConnection) url.openConnection();
		request.connect();

		// Convert to a JSON object to print data
		JsonParser jp = new JsonParser();

		// Convert the input stream to a json element
		JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));

		return root;
	}

	/*-********************************************-*/

	/*-********************************************-*
	 *  Converting JSON to DatamuseWord Collection
	 *-********************************************-*/
	private ImmutableList<DatamuseWord> convertJSONtoDatamus(JsonElement root) {
		if (!root.isJsonArray()) {
			throw new RuntimeException("Given root is not an array: " + root);
		}
		Collection<DatamuseWord> converted = GSON.fromJson(root.getAsJsonArray(), DATAMUSWORD_COLLECTION_TYPE);
		return ImmutableList.copyOf(converted);
	}

	/*-********************************************-*/
}