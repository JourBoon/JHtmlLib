package fr.jhtml.html.req;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import fr.jhtml.html.References;

import java.io.IOException;
import java.util.logging.Level;

public class HTMLHead {

    private String git = "https://github.com/JourBoon/JHtmlLib";
    private String mUrl;

    public HTMLHead(String url) throws IOException {
        this.mUrl = url;
        OkHttpClient okHttpClient = new OkHttpClient();

        Request.Builder builder = new Request.Builder().url(this.mUrl);
        Request req = builder.get().build();

        Response res = okHttpClient.newCall(req).execute();

        String head = res.body().string();


        if (head.contains("<head")) {
            String split = head.split("<head")[1].split("</head>")[0];
            System.out.println("<head" + split + "</head>");
            References.logger.log(Level.INFO, "[" + References.NAME + "]: Succesfully got head content of " + this.mUrl + "!");
            References.logger.log(Level.INFO, "[" + References.NAME + "]: More info on GitHub" + this.git);
        }

    }
}
