/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.system.controller;

import com.inventory.system.dao.AdminDAO;
import com.inventory.system.dao.AdminDAOImpl;
import com.inventory.system.model.Admin;
import com.inventory.system.model.Teacher;
import com.inventory.system.response.ServiceResponse;
import com.inventory.system.service.AdminService;
import com.inventory.system.validation.AdminValidator;
import java.util.Arrays;
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
public class AdminController {
    @Autowired
    private AdminService adminService;
    private static final Logger logger = Logger.getLogger(AdminController.class.getName());
    
    @Autowired
    @Qualifier("adminValidator")
    private AdminValidator adminValidator;    

    //Set a form validator
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(adminValidator);
    }
        
    
    @RequestMapping(value = {"/CreateUser", "CreateUser2"}, method = RequestMethod.GET)
    public ModelAndView CreateUser(ModelMap model, HttpServletRequest request, HttpServletResponse response) {

        ModelAndView modelAndView;

        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("admin");
//        if (user == null) {
//            modelAndView = new ModelAndView("redirect:login", "command", new Admin());
//            return modelAndView;
//        }
        modelAndView = new ModelAndView("CreateUser", "command", new Admin());
        

        return modelAndView;

    }
    
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("addUser")@Validated Admin admin, BindingResult result, ModelMap model,
            HttpServletRequest request, HttpServletResponse response) {

        ModelAndView modelAndView = new ModelAndView("CreateUser");                              
        
        //adminValidator.validate(admin, result);
        if (result.hasErrors()) {
            List<ObjectError> fieldList = result.getAllErrors();
            modelAndView.addObject("errors", fieldList);
            return modelAndView;
        }
        
        logger.log(Level.INFO, "Username : {0}, Password : {1}, Category : {2},Staff RegistrationNo : {3}",
                new Object[]{admin.getUsername(), admin.getPassword(),admin.getCategory(),admin.getStaffRegistrationNo()});
        
        ServiceResponse rsp = adminService.addUser(admin);
        if(rsp!=null){
            
        }

        


        return modelAndView;
    }
   
}
