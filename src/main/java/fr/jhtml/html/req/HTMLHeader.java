package fr.jhtml.html.req;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import fr.jhtml.html.References;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HTMLHeader {

    private String mUrl;

    public HTMLHeader(String url) throws IOException {
        this.mUrl = url;
        OkHttpClient okHttpClient = new OkHttpClient();

        Request.Builder builder = new Request.Builder().url(this.mUrl);
        Request req = builder.get().build();

        Response res = null;
        try {
            res = okHttpClient.newCall(req).execute();
            References.logger.log(Level.INFO, "[" + References.NAME + "]: Succesfully got all HTML content of" + this.mUrl + "!");
        } catch (IOException e) {
           References.logger.log(Level.SEVERE, "[" + References.NAME + "]: Could not get HTML content! Crash report:" + e.getMessage());

        }

        System.out.println(res.body().string());
    }
}
