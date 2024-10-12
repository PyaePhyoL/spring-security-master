package org.jdc.securitymaster.annotation;

import org.springframework.security.access.annotation.Secured;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Secured({"ROLE_SUPER_ADMIN", "ROLE_EMPLOYEES_ADMIN"})
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SuperAdmin {
}
