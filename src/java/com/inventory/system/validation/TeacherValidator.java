/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.validation;

import com.inventory.system.model.Teacher;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Abiodun.Ayeola
 */
public class TeacherValidator implements Validator{
    
    private Resource location;

    private static final Logger logger = Logger.getLogger(AdminValidator.class.getName());

    @Required
    public void setLocation(Resource location) {
        this.location = location;
    }

    @Override
    public boolean supports(Class<?> type) {
        return (Teacher.class).isAssignableFrom(type);
    }

    @Override
    public void validate(Object targetObject, Errors errors) {
        Teacher teacher = (Teacher) targetObject;
         Properties props;
        try {
            props = PropertiesLoaderUtils.loadProperties(location);

            String firstName = props.getProperty("firstName.required");
            String middleName = props.getProperty("middleName.required");
            String lastName = props.getProperty("lastName.required");
            String title = props.getProperty("title.required");
            String registrationNumber = props.getProperty("registrationNumber.required");
            String localGovernment = props.getProperty("localGovernment.required");
            String email = props.getProperty("email.required");
            String phoneNumber = props.getProperty("phoneNumber.required");
            String gender = props.getProperty("gender.required");
            String academicclass = props.getProperty("academicClass.required");

            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.required", firstName);
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "middleName", "middleName.required", middleName);
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.required", lastName);
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title.required", title);
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.required", email);
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "phoneNumber.required", phoneNumber);
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "gender.required", gender);
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "registrationNumber", "registrationNumber.required", registrationNumber);

            if (teacher.getLocalGovernment()!= null && teacher.getLocalGovernment().getId() == -1) {
                if (teacher.getLocalGovernment().getId() < 1) {
                    errors.rejectValue("localgovernment", "localgovernment.required", localGovernment);
                }
            }
            if (teacher.getAcademicclass()!= null && teacher.getAcademicclass().getId() == -1) {
                if (teacher.getLocalGovernment().getId() < 1) {
                    errors.rejectValue("academicclass", "academicclass.required", academicclass);
                }
            }
            if (teacher.getAcademicclass()!= null && teacher.getAcademicclass().getId() == -1) {
                if (teacher.getLocalGovernment().getId() < 1) {
                    errors.rejectValue("academicclass", "academicclass.required", academicclass);
                }
            }
            if (teacher.getGender().equals("-1")) {                
                    errors.rejectValue("gender", "gender.required", gender);                
            }
                                    

        } catch (IOException ex) {
            ex.printStackTrace();
            errors.rejectValue("exception", "exception.handler", ex.getMessage());
        }
    }
}
