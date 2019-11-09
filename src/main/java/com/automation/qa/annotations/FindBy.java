package com.automation.qa.annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.support.AbstractFindByBuilder;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FindBy {

    /**
     * specify locator in conventional String format.
     *
     * @return
     */
    public String locator() default "";




    public static class FindByBuilder extends AbstractFindByBuilder {
        public By buildIt(Object annotation, Field field) {
            org.openqa.selenium.support.FindBy findBy = (org.openqa.selenium.support.FindBy) annotation;
            assertValidFindBy(findBy);

            By ans = buildByFromShortFindBy(findBy);
            if (ans == null) {
                ans = buildByFromLongFindBy(findBy);
            }

            return ans;

        }

    }
}
