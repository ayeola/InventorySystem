/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.validation;

import com.inventory.system.model.NonTeachingStaff;
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
public class NTSValidator implements Validator{
    
    private Resource location;

    private static final Logger logger = Logger.getLogger(AdminValidator.class.getName());

    @Required
    public void setLocation(Resource location) {
        this.location = location;
    }

    @Override
    public boolean supports(Class<?> type) {
        return (NonTeachingStaff.class).isAssignableFrom(type);
    }

    @Override
    public void validate(Object targetObject, Errors errors) {
        NonTeachingStaff nts = (NonTeachingStaff) targetObject;
         Properties props;
        try {
            props = PropertiesLoaderUtils.loadProperties(location);

            String firstName = props.getProperty("firstName.required");
            String middleName = props.getProperty("middleName.length");
            String lastName = props.getProperty("lastName.length");
            String title = props.getProperty("title.required");
            String registrationNumber = props.getProperty("registrationNumber.required");
            String localGovernment = props.getProperty("localGovernment.required");
            String email = props.getProperty("email.required");
            String phoneNumber = props.getProperty("phoneNumber.required");
            String placeOfBirth = props.getProperty("placeOfBirth.required");
            String gender = props.getProperty("gender.required");

            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.required", firstName);
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "middleName", "middleName.required", middleName);
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.required", lastName);
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title.required", title);
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.required", email);
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "phoneNumber.required", phoneNumber);
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "placeOfBirth", "placeOfBirth.required", placeOfBirth);
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "registrationNumber", "registrationNumber.required", registrationNumber);
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "gender.required", gender);

            if (nts.getLocalGovernment()!= null || nts.getLocalGovernment().getId().equals("-1")) {
                if (nts.getLocalGovernment().getId() < 1) {
                    errors.rejectValue("localgovernment", "localgovernment.required", localGovernment);
                }
            }
               
            if (nts.getGender().equals("-1")) {                
                    errors.rejectValue("gender", "gender.required", gender);                
            }

        } catch (IOException ex) {
            ex.printStackTrace();
            errors.rejectValue("exception", "exception.handler", ex.getMessage());
        }
    }
    
}
