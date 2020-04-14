package com.mvc.entity;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


/**
 * @Author: zengsm.
 * @Description:
 * @Date:Created in 2018/7/18 23:26.
 * @Modified By:
 */
public class UserValidator implements Validator
{
    @Override
    public boolean supports(Class<?> aClass)
    {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors)
    {
        User user= (User)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"username","username.required");
        ValidationUtils.rejectIfEmpty(errors,"password","password.required");
        int id = user.getId();
        if(id < 1)
        {
            errors.rejectValue("id","id.incorrect");
        }
    }
}