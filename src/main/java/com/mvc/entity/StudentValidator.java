package com.mvc.entity;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Date;


/**
 * @Author: zengsm.
 * @Description:
 * @Date:Created in 2018/7/18 23:26.
 * @Modified By:
 */
public class StudentValidator implements Validator
{
    @Override
    public boolean supports(Class<?> aClass)
    {
        return Student.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors)
    {
        Student student = (Student)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"user_name","userName.required");
        ValidationUtils.rejectIfEmpty(errors,"user_no","userNo.required");
        Date date = student.getUserBirth();
        if(!date.after(new Date()))
        {
            errors.rejectValue("birthday","birthday.incorrect");
        }
    }
}
