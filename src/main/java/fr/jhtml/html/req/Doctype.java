package fr.jhtml.html.req;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import fr.jhtml.html.References;
import sun.util.logging.PlatformLogger;

import java.io.IOException;
import java.util.logging.Level;

public class Doctype {

    private String git = "https://github.com/JourBoon/JHtmlLib";
    private String mUrl;

    public Doctype(String url) throws IOException{
        this.mUrl = url;
        OkHttpClient okHttpClient = new OkHttpClient();

        Request.Builder builder = new Request.Builder().url(this.mUrl);
                Request req = builder.get().build();

        Response res = okHttpClient.newCall(req).execute();

        String doc = res.body().string();


        if (doc.contains("<!DOCTYPE")) {
            String split = doc.split("<")[1].split(">")[0];
            System.out.println("<" + split + ">");
            References.logger.log(Level.INFO, "[" + References.NAME + "]: Succesfully got Doctype of " + this.mUrl + "!");
            References.logger.log(Level.INFO, "[" + References.NAME + "]: More info on GitHub" + this.git);
        }

    }

}
