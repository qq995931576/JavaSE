package annotation.java;

import java.lang.annotation.*;

/**
 * @author 阿昌
 * @create 2020-10-12 22:00
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,
        ElementType.FIELD,
        ElementType.METHOD,
        ElementType.PARAMETER,
        ElementType.CONSTRUCTOR,
        ElementType.TYPE_PARAMETER,
        ElementType.TYPE_USE})
public @interface MyAnnotations {

    MyAnnotation[] value();

}
