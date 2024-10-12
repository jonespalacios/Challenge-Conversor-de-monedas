import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConsultaMoneda {
    public Moneda buscarMoneda ( String monedaBase, String monedaTarget ) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/cf40f0bb5507012094583b4c/pair/"+monedaBase+"/"+monedaTarget);
    //    URI direccion2 = URI.create("https://v6.exchangerate-api.com/v6/cf40f0bb5507012094583b4c/codes");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
           // System.out.println(response.body());
              return new Gson().fromJson(response.body(), Moneda.class);

        } catch (Exception e) {
            throw new RuntimeException("Moneda no encontrada");
        }

    }
}
