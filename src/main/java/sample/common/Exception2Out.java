package sample.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class Exception2Out {

    @ExceptionHandler(Throwable.class)
    public Out handle(Throwable e) {
        return Out.with(1, e.getMessage(), e);
    }
}
