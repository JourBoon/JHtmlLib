package fr.jhtml.html.req;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import fr.jhtml.html.References;

import java.io.IOException;
import java.util.logging.Level;

public class HTMLBody {

    private String mUrl;

    public HTMLBody(String url) throws IOException {
        this.mUrl = url;
        OkHttpClient okHttpClient = new OkHttpClient();

        Request.Builder builder = new Request.Builder().url(this.mUrl);
        Request req = builder.get().build();

        Response res = okHttpClient.newCall(req).execute();

        String body = res.body().string();


        if (body.contains("<body")) {
            String split = body.split("<body")[1].split("</body>")[0];
            System.out.println("<body" + split + "</body>");
            References.logger.log(Level.INFO, "[" + References.NAME + "]: Succesfully got body of " + this.mUrl);
        }

    }
}
