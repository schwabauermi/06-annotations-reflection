package ohm.softa.a06;

import ohm.softa.a06.model.Joke;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

/**
 * @author Peter Kurfer
 * Created on 11/10/17.
 */
public class App {

	public static void main(String[] args) throws IOException {
		Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com/").build();

		ICNDBApi service = retrofit.create(ICNDBApi.class);

		Call<Joke> call = service.limitByCategory(new String[] {"nerdy"});
		Response<Joke> resp = call.execute();
		Joke j = resp.body();
	}

}
