/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.controller;

import com.inventory.system.model.NonTeachingStaff;
import com.inventory.system.response.ServiceResponse;
import com.inventory.system.service.StaffServiceImpl;
import com.inventory.system.validation.NTSValidator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Abiodun.Ayeola
 */
@Controller
public class NonTeachingStaffController {
    
    @Autowired
    private StaffServiceImpl staffServiceimpl;
    private static final Logger logger = Logger.getLogger(TeacherController.class.getName());
    
    @Autowired
    @Qualifier("ntsValidator")
    private NTSValidator ntsValidator;    

    //Set a form validator
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(ntsValidator);
    }
    
    @RequestMapping(value = {"/CreateNonTeachingStaff", "CreateNonTeachingStaff2"}, method = RequestMethod.GET)
    public ModelAndView CreateUser(ModelMap model, HttpServletRequest request, HttpServletResponse response) {

        ModelAndView modelAndView;

        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("admin");
//        if (user == null) {
//            modelAndView = new ModelAndView("redirect:login", "command", new Admin());
//            return modelAndView;
//        }
        modelAndView = new ModelAndView("CreateNonTeachingStaff", "command", new NonTeachingStaff());
        

        return modelAndView;

    }
    
    @RequestMapping(value = "/addNonTeachingStaff", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("addNonTeachingStaff")@Validated NonTeachingStaff nts, BindingResult result, ModelMap model,
            HttpServletRequest request, HttpServletResponse response) {

        ModelAndView modelAndView = new ModelAndView("CreateNonTeachingStaff");                              
        
        //adminValidator.validate(admin, result);
        if (result.hasErrors()) {
            List<ObjectError> fieldList = result.getAllErrors();
            modelAndView.addObject("errors", fieldList);
            return modelAndView;
        }
        
        logger.log(Level.INFO, "RegNo : {0}, FirstName : {1}, LastName : {2},PhoneNumber : {3}",
                new Object[]{nts.getRegistrationNumber(), nts.getFirstName(),nts.getLastName(),nts.getPhoneNumber()});
        
        
        ServiceResponse rsp = staffServiceimpl.addNTS(nts);
        if(rsp!=null){
            
        }

        


        return modelAndView;
    }
}
