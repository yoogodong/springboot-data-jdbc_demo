package sample.common;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.HashMap;

/**
 * 代表应答数据
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Value
public class Out<T> {
    public static Out OK = new Out(0, "success", new HashMap());
    private int code;
    private String message;
    private T data;

    public static Out okWithData(Object data) {
        return new Out(0, "success", data);
    }

    public static Out with(int code, String message, Object data) {
        return new Out(code, message, data);
    }
}
