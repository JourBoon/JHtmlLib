# JHtmlLib

JHtmlLib is a Java library to retrieve the code of an HTML page.

**_`! JHtml is in a SNAPSHOT VERSION. You can only get head content to an html page. !`_**


## Usage

```java
import fr.jhtml.html.req.HTMLHeader;
import java.io.IOException;

public class HTML{

    public static void main(String[] args) throws IOException{
        
    HTMLHeader <yourhtml> = new HTMLReader("https://examplesite.com/");

    }

}
```

## To Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.



