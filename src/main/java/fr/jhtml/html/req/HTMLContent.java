package fr.jhtml.html.req;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import fr.jhtml.html.References;

import java.io.IOException;
import java.util.logging.Level;

public class HTMLContent {

    private String mUrl;
    private String git = "https://github.com/JourBoon/JHtmlLib";

    public HTMLContent(String url, Type type) throws IOException {
        this.mUrl = url;
        try{
            if(type.equals(Type.ALL)){
                OkHttpClient okHttpClient = new OkHttpClient();

                Request.Builder builder = new Request.Builder().url(this.mUrl);
                Request req = builder.get().build();

                Response res = null;

                res = okHttpClient.newCall(req).execute();

                System.out.println(res.body().string());

                References.logger.log(Level.INFO, "[" + References.NAME + "]: Succesfully got all HTML content of" + this.mUrl + "!");
                References.logger.log(Level.INFO, "[" + References.NAME + "]: More info on GitHub" + this.git);
            }

            if(type.equals(Type.HEAD)){
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
            if(type.equals(Type.BODY)){
                OkHttpClient okHttpClient = new OkHttpClient();

                Request.Builder builder = new Request.Builder().url(this.mUrl);
                Request req = builder.get().build();

                Response res = okHttpClient.newCall(req).execute();

                String body = res.body().string();


                if (body.contains("<body")) {
                    String split = body.split("<body")[1].split("</body>")[0];
                    System.out.println("<body" + split + "</body>");
                    References.logger.log(Level.INFO, "[" + References.NAME + "]: Succesfully got body of " + this.mUrl + "!");
                    References.logger.log(Level.INFO, "[" + References.NAME + "]: More info on GitHub" + this.git);
                }
            }
            if(type.equals(Type.DOCTYPE)){
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
        }catch (Exception e){
            References.logger.log(Level.SEVERE, "[" + References.NAME + "]: Something went wrong!" + e.getMessage());
        }

    }
}
