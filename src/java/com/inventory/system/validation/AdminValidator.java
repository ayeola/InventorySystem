/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.validation;

import com.inventory.system.model.Admin;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author ayeola
 */
@ComponentScan
public class AdminValidator implements Validator {

    private Resource location;

    private static final Logger logger = Logger.getLogger(AdminValidator.class.getName());

    @Required
    public void setLocation(Resource location) {
        this.location = location;
    }

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    public boolean supports(Class<?> type) {
        return (Admin.class).isAssignableFrom(type);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Admin admin = (Admin) target;

        Properties props;
        try {
            props = PropertiesLoaderUtils.loadProperties(location);

            String username = props.getProperty("username.required");
            String usernameLength = props.getProperty("username.length");
            String passwordLength = props.getProperty("password.length");
            String password = props.getProperty("password.required");
            String category = props.getProperty("category.required");
            String staffRegistrationNo = props.getProperty("staffRegistrationNo.required");

            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.required", username);
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required", password);
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "category", "category.required", category);
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "staffRegistrationNo", "staffRegistrationNo.required", staffRegistrationNo);

            if (admin.getUsername() != null) {
                if (admin.getUsername().length() < 8) {
                    errors.rejectValue("password", "username.length", usernameLength);
                }
            }

            if (admin.getPassword() != null) {
                if (admin.getPassword().length() < 10) {
                    errors.rejectValue("password", "password.length", passwordLength);
                }
            }
            
            if(admin.getCategory().equals("-1")){
                errors.rejectValue("category", "category.empty", category);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
            errors.rejectValue("exception", "exception.handler", ex.getMessage());
        }
    }

}
