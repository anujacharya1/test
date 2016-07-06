import java.io.Serializable;

/**
 * Created by anujacharya on 7/3/16.
 */
public class Token implements Serializable {

    public final String ccPanToken;

    public Token(String ccPanToken) {
        this.ccPanToken = ccPanToken;
    }
}

