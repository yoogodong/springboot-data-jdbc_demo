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
    private static final HashMap EMPTY = new HashMap();
    public static Out OK = new Out(0, "success", EMPTY);

    private int code;
    private String message;
    private T data;

    public static Out successOf(Object data) {
        return new Out(0, "success", data);
    }

    public static Out of(int code, String message, Object data) {
        return new Out(code, message, data);
    }

    public static Out of(int code, String message) {
        return new Out(code, message, EMPTY);
    }
}
