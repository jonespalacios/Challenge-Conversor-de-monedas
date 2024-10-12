import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class ConsultaMonedaBase {
  /*  public String monedaBase ( String monedaBase ) throws IOException, InterruptedException {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/cf40f0bb5507012094583b4c/latest/"+monedaBase);


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

     //   HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

     //   return response.body();
      */
        //Prueba pasando json a class para extraer todos los rate conversion map

    public MonedaAll baseToAll () {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/cf40f0bb5507012094583b4c/latest/USD");
            URI direccion2 = URI.create("https://v6.exchangerate-api.com/v6/cf40f0bb5507012094583b4c/codes");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion2)
                .build();
        try {

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            //System.out.println(response.body());
            return new Gson().fromJson(response.body(), MonedaAll.class);

        } catch (Exception e) {
            throw new RuntimeException("Moneda no encontrada");
        }
    }
}
