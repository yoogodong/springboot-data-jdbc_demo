package sample.common;

import org.springframework.data.relational.core.conversion.DbActionExecutionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class Exception2Out {

    @ExceptionHandler(DbActionExecutionException.class)
    public Out dbAction(DbActionExecutionException e) {
        return Out.of(1, e.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    public Out last(Throwable e) {
        System.out.println(e.getClass().getName());
        return Out.of(1, e.getMessage(), e.getClass().getName());
    }

}
