package annotation.java;

import java.lang.annotation.*;

/**
 * @author 阿昌
 * @create 2020-10-11 20:24
 */

@Repeatable(MyAnnotations.class)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.
        FIELD, ElementType.
        METHOD, ElementType.
        PARAMETER, ElementType.
        CONSTRUCTOR, ElementType.
        TYPE_PARAMETER, ElementType.TYPE_USE})
public @interface MyAnnotation {
    String value() default "hello";//default 默认值:

}
