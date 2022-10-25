package com.digipay.store.Practice;

import java.lang.annotation.*;

//@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(CreatorsContainer.class)
public @interface Creator {
    String value() default "Ali Ahmadi";

}
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
@Documented
@interface  CreatorsContainer {
    Creator[] value();
}