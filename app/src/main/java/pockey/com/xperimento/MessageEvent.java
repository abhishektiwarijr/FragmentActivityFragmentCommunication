package pockey.com.xperimento;

/**
 * Created by abhishek.tiwari on 7/8/17.
 **/

public class MessageEvent {
    public MessageEvent(String data) {
        this.data = data;
    }

    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
